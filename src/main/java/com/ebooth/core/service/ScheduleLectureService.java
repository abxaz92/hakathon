package com.ebooth.core.service;

import com.ebooth.core.model.Lecture;
import com.ebooth.core.model.ScheduleLecture;
import com.ebooth.core.model.User;
import com.ebooth.core.repository.LectureRepository;
import com.ebooth.core.repository.ScheduleLectureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ScheduleLectureService {

    @Autowired
    private ScheduleLectureRepository scheduleLectureRepository;
    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private UserService userService;

    public ScheduleLecture schedule(ScheduleLecture scheduleLecture) {
        log.info("Schedule lecture {}", scheduleLecture);
        Optional<Lecture> lecture = lectureRepository.findById(scheduleLecture.getLectureId());
        if (lecture.isEmpty())
            return null;
        User currentUser = userService.getCurrentUser();
        Lecture ll = lecture.get();
        List<ScheduleLecture> idAndStudentUsername = scheduleLectureRepository
                .findScheduleLecturesByLectureIdAndStudentUsername(ll.getId(), currentUser.getUsername());
        if (idAndStudentUsername.size() > 0) {
            throw new RuntimeException("Lecture for student already scheduler");
        }
        scheduleLecture.setLectureName(ll.getName());
        scheduleLecture.setStartTime(ll.getStartTime());
        scheduleLecture.setStudentUsername(currentUser.getUsername());
        scheduleLecture.setTeacherUsername(ll.getTeacherUsername());

        ll.setScheduled(true);
        lectureRepository.save(ll);

        return scheduleLectureRepository.save(scheduleLecture);
    }

    public List<ScheduleLecture> findUpcomingEvents() {
        String username = userService.getCurrentUser().getUsername();
        return scheduleLectureRepository.findScheduleLecturesByTeacherUsernameOrStudentUsername(username, username);
    }

    public List<ScheduleLecture> findNearLectures() {
        return scheduleLectureRepository.findScheduleLecturesByStartTimeBefore(LocalDateTime.now().plusMinutes(15));
    }
}
