package com.ebooth.core.controller;

import com.ebooth.core.model.Lecture;
import com.ebooth.core.model.User;
import com.ebooth.core.repository.LectureRepository;
import com.ebooth.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LectureController {
    @Autowired
    private LectureRepository lectureRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/lecture")
    public List<Lecture> findAll() {
        return lectureRepository.findLecturesByScheduledFalseOrScheduledIsNull();
    }

    @GetMapping("/lecture/{id}")
    public Optional<Lecture> findById(@PathVariable("id") String lectureId) {
        return lectureRepository.findById(lectureId);
    }

    @PostMapping(path = "/lecture/")
    public Lecture post(@RequestBody Lecture lecture) {

        User currentUser = userService.getCurrentUser();
        lecture.setTeacherUsername(currentUser.getUsername());
        lecture.setTeacherName(currentUser.getName());

        return lectureRepository.save(lecture);
    }

    @DeleteMapping("/lecture/{id}")
    public void delete(@PathVariable("id") String lectureId) {
        lectureRepository.deleteById(lectureId);
    }
}
