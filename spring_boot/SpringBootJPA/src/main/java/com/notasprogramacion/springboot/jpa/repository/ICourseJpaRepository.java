package com.notasprogramacion.springboot.jpa.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.notasprogramacion.springboot.jpa.entity.Course;

@Repository(value="courseJpaRepository")
public interface ICourseJpaRepository extends JpaRepository<Course, Serializable> {

	public abstract Course findByPrice(int price);
	
	public abstract Course findByPriceAndName(int price, String name);
	
	public abstract List<Course> findByNameOrderByHours(String name);
	
	public abstract List<Course> findByNameOrPrice(String name, int price);
	
}
