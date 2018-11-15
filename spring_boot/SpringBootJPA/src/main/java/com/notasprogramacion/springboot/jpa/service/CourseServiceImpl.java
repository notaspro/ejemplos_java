package com.notasprogramacion.springboot.jpa.service;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notasprogramacion.springboot.jpa.entity.Course;
import com.notasprogramacion.springboot.jpa.repository.ICourseJpaRepository;
import com.notasprogramacion.springboot.jpa.repository.QueryDSLExampleRepository;

@Service(value="courseService")
public class CourseServiceImpl implements ICourseService {

	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	private ICourseJpaRepository courseJpaRepository;
	
	@Autowired
	private QueryDSLExampleRepository queryDSLExampleRepository;
	
	@Override
	public List<Course> listAll() {
		LOG.info("calling to CourseServiceImpl.listAll()...");
		return courseJpaRepository.findAll();
	}

	@Override
	public Course add(Course course) {
		LOG.info("calling to CourseServiceImpl.add()...");
		return courseJpaRepository.save(course);
	}

	@Override
	public int remove(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Course update(Course course) {
		return courseJpaRepository.save(course);
	}
	
	@Override
	public List<Course> findAll() {
		return queryDSLExampleRepository.findAll();
	}
}
