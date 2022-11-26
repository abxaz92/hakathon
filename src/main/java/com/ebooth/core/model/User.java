package com.ebooth.core.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private String id;
    private String username;
    private String name;
    private String bio;
    private String reputation;
    private int marksCount;
    private String password;
    private String email;
}
