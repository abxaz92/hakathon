package com.ebooth.core.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class ScheduleLecture {
    @Id
    private String id;
    private String lectureId;
    private String lectureName;
    private LocalDateTime startTime;
    private String teacherUsername;
    private String studentUsername;
}
