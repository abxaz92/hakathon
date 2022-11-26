package com.ebooth.core.controller;

import com.ebooth.core.model.ScheduleLecture;
import com.ebooth.core.model.User;
import com.ebooth.core.service.ScheduleLectureService;
import com.ebooth.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("schedule")
public class ScheduledLectureController {

    @Autowired
    private ScheduleLectureService scheduleLectureService;

    @GetMapping(path = "upcoming")
    public List<ScheduleLecture> upcomingLectures() {
        return scheduleLectureService.findUpcomingEvents();
    }

    @PostMapping()
    public ScheduleLecture schedule(@RequestBody ScheduleLecture scheduleLecture) {
        return scheduleLectureService.schedule(scheduleLecture);
    }
}
