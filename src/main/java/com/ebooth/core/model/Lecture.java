package com.ebooth.core.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class Lecture {
    @Id
    private String id;
    private String name;
    private String topicId;
    private String teacherUsername;
    private String teacherName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean scheduled;
}
