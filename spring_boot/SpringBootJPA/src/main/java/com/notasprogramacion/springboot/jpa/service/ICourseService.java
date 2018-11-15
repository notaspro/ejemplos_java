package com.notasprogramacion.springboot.jpa.service;

import java.util.List;

import com.notasprogramacion.springboot.jpa.entity.Course;

public interface ICourseService {

	public abstract List<Course> listAll();
	
	public abstract Course add(Course course);
	
	public abstract int remove(int id);
	
	public abstract Course update(Course course);
	
	//Example with DSLQuery
	public List<Course> findAll();
}
