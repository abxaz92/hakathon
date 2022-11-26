package com.ebooth.core.repository;

import com.ebooth.core.model.Lecture;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LectureRepository extends MongoRepository<Lecture, String> {
    List<Lecture> findLecturesByScheduledFalseOrScheduledIsNull();
}
