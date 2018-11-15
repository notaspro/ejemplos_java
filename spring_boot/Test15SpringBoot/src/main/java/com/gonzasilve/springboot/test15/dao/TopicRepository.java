package com.gonzasilve.springboot.test15.dao;

import org.springframework.data.repository.CrudRepository;

import com.gonzasilve.springboot.test15.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
