package com.gonzasilve.springboot.test14.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.gonzasilve.springboot.test14.entity.Topic;

@Service
public class TopicService {

	private List<Topic> topics   =  new ArrayList<>(Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("jquery","JQuery Framework","JQuery Framework Description"),
			new Topic("angular","Angular Core","Angular Framework Description")
		));
		
	public List<Topic> getAllTopics() {
		return topics;
	}
	
	public Topic getTopicById(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	
	public void save(Topic topicDto) {
		topics.add(topicDto);
	}
	
	public void update(String id, Topic topicDto) {
		for(int i=0;i<topics.size(); i++) {
			Topic topicItem = topics.get(i);
			if(topicItem.getId().equals(id)) {
				topics.set(i, topicDto);
				return;
			}
		}
	}
	
	public void delete(String id) {
		topics.removeIf(t->t.getId().equals(id));
	}
	
}
