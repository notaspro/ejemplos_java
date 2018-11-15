package com.gonzasilve.springboot.test5.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gonzasilve.springboot.test5.dto.TopicDto;

@Service
public class TopicService {

	private List<TopicDto> topics   =  Arrays.asList(
			new TopicDto("spring","Spring Framework","Spring Framework Description"),
			new TopicDto("jquery","JQuery Framework","JQuery Framework Description"),
			new TopicDto("angular","Angular Core","Angular Framework Description")
		);
		
	public List<TopicDto> getAllTopics() {
		return topics;
		
	}
	
}
