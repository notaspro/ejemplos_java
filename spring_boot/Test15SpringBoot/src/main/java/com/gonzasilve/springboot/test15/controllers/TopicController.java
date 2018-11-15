package com.gonzasilve.springboot.test15.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gonzasilve.springboot.test15.entity.Topic;
import com.gonzasilve.springboot.test15.service.TopicService;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	//solo si tienen distinto nombre se agrega el parametro a @PathVariable("algunNommbre"), ej.
	//@RequestMapping("/topics/{myId}")
	//public TopicDto getTopicById(@PathVariable("myId") String id) {
	@RequestMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
	}
	
	@RequestMapping(method= RequestMethod.POST, value = "/topics")
	public void save(@RequestBody Topic topicDto) {
		topicService.save(topicDto);
		
	}
	
	@RequestMapping(method= RequestMethod.PUT, value = "/topics/{id}")
	public void save(@RequestBody Topic topicDto,@PathVariable String id) {
		topicService.update(id, topicDto);
		
	}
	
	@RequestMapping(method= RequestMethod.DELETE, value = "/topics/{id}")
	public void save(@PathVariable String id) {
		topicService.delete(id);
	}
	
}
