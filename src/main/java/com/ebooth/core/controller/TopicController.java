package com.ebooth.core.controller;

import com.ebooth.core.model.Topic;
import com.ebooth.core.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {
    @Autowired
    private TopicRepository topicRepository;

    @GetMapping(path = "topic")
    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }

    @GetMapping(path = "/topic/{id}")
    public Optional<Topic> getTopic(@PathVariable("id") String topicId) {
        return topicRepository.findById(topicId);
    }

    @PostMapping(path = "topic")
    public Topic post(@RequestBody Topic topic) {
        topicRepository.save(topic);
        return topic;
    }

    @DeleteMapping(path = "topic/{id}")
    public void deleteTopic(@PathVariable("id") String topicId) {
        topicRepository.deleteById(topicId);
    }
}
