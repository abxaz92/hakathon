package com.ebooth.core.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SchedulesChecker {
    private ScheduleLectureService scheduleLectureService;

//    @Scheduled(fixedDelay = 5000)
    public void schedule() {
        log.info("find scheduleLectures...");
        log.info("finish scheduleLectures...");
    }
}
