package com.ebooth.core.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Topic {
    @Id
    private String id;
    private String name;
}
