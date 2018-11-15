package com.gonzasilve.springboot.test15.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gonzasilve.springboot.test15.dao.TopicRepository;
import com.gonzasilve.springboot.test15.entity.Topic;

@Service
public class TopicService {

	@Autowired
	private TopicRepository topicRepository;
	
	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopicById(String id) {
		return topicRepository.findOne(id);
	}
	
	public void save(Topic topicDto) {
		topicRepository.save(topicDto);
	}
	
	public void update(String id, Topic topicDto) {
		topicRepository.save(topicDto);
	}
	
	public void delete(String id) {
		topicRepository.delete(id);
	}
	
}
