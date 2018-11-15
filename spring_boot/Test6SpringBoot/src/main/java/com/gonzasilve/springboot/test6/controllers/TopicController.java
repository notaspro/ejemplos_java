package com.gonzasilve.springboot.test6.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzasilve.springboot.test6.dto.TopicDto;
import com.gonzasilve.springboot.test6.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<TopicDto> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	//solo si tienen distinto nombre se agrega el parametro a @PathVariable("algunNommbre"), ejemplo:
	//@RequestMapping("/topics/{myId}")
	//public TopicDto getTopicById(@PathVariable("myId") String id) {
	@RequestMapping("/topics/{id}")
	public TopicDto getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
		
	}
	
}
