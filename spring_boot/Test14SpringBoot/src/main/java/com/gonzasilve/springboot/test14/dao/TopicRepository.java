package com.gonzasilve.springboot.test14.dao;

import org.springframework.data.repository.CrudRepository;

import com.gonzasilve.springboot.test14.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
