package com.ebooth.core.repository;

import com.ebooth.core.model.ScheduleLecture;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleLectureRepository extends MongoRepository<ScheduleLecture, String> {

    List<ScheduleLecture> findScheduleLecturesByStartTimeBefore(LocalDateTime currentTime);

    List<ScheduleLecture> findScheduleLecturesByLectureIdAndStudentUsername(String lectureId, String studentUsername);
    List<ScheduleLecture> findScheduleLecturesByTeacherUsernameOrStudentUsername(String teacherId, String studentId);
}
