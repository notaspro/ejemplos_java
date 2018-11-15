package com.gonzasilve.springboot.test5.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzasilve.springboot.test5.dto.TopicDto;
import com.gonzasilve.springboot.test5.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<TopicDto> getAllTopics() {
		return topicService.getAllTopics();
		
	}
}
