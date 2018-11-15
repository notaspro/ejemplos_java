package com.gonzasilve.springboot.test4.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gonzasilve.springboot.test4.dto.TopicDto;

@RestController
public class TopicController {

	@RequestMapping("/topics")
	public List<TopicDto> getAllTopics() {
		return Arrays.asList(
			new TopicDto("spring","Spring Framework","Spring Framework Description"),
			new TopicDto("jquery","JQuery Framework","JQuery Framework Description"),
			new TopicDto("angular","Angular Core","Angular Framework Description")
		);
		
	}
}
