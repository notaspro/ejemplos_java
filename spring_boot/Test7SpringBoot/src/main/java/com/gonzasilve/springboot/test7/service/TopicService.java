package com.gonzasilve.springboot.test7.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gonzasilve.springboot.test7.dto.TopicDto;

@Service
public class TopicService {

	private List<TopicDto> topics   =  new ArrayList<>(Arrays.asList(
			new TopicDto("spring","Spring Framework","Spring Framework Description"),
			new TopicDto("jquery","JQuery Framework","JQuery Framework Description"),
			new TopicDto("angular","Angular Core","Angular Framework Description")
		));
		
	public List<TopicDto> getAllTopics() {
		return topics;
	}
	
	public TopicDto getTopicById(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void save(TopicDto topicDto) {
		topics.add(topicDto);
	}
}
