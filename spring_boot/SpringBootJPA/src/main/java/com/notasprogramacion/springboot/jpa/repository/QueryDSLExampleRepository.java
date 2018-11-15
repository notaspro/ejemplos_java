package com.notasprogramacion.springboot.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.notasprogramacion.springboot.jpa.entity.Course;
import com.notasprogramacion.springboot.jpa.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLExampleRepository")
public class QueryDSLExampleRepository {

	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	//example udemy
	public Course find(boolean exists) {
		
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		if(exists) {
			Predicate predicate1 = qCourse.id.eq(23);
			predicateBuilder.and(predicate1);
		} else {
			Predicate predicate2 = qCourse.name.endsWith("AP");
			predicateBuilder.or(predicate2);
		}
		
		//query.select(qCourse.id, qCourse.name, qCourse.description).from(qCourse).where(predicateBuilder).fetchOne();
		
		return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
	}
	
	public List<Course> findAll() {
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		return query.select(qCourse).from(qCourse).fetch();
	}
	
}