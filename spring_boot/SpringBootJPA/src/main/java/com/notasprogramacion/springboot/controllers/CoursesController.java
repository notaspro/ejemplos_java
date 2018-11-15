package com.notasprogramacion.springboot.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.notasprogramacion.springboot.jpa.entity.Course;
import com.notasprogramacion.springboot.jpa.repository.ExampleComponent;
import com.notasprogramacion.springboot.jpa.service.ICourseService;

@Controller
@RequestMapping("/courses")
public class CoursesController {

	private static final Log LOG = LogFactory.getLog(ExampleComponent.class);
	
	@Autowired
	private ICourseService courseService;
	
	private static final String COURSES_VIEW = "courses";
	private static final String ADD_COURSES_VIEW = "addCourses";
	
	@GetMapping("/list")
	private ModelAndView getAll() {
		LOG.info("calling to CoursesController.getAll()...");
		ModelAndView mv = new ModelAndView(COURSES_VIEW);
		//mv.addObject("courses", courseService.listAll());
		mv.addObject("courses", courseService.findAll());
		
		return mv;
	}
	
	@GetMapping("/add")
	private ModelAndView showAddCourse() {
		LOG.info("calling to CoursesController.showAddCourse()...");
		ModelAndView mv = new ModelAndView(ADD_COURSES_VIEW);
		mv.addObject("course", new Course());
		
		return mv;
	}
	
	@PostMapping("/add")
	private String add(@ModelAttribute("course") Course course) {
		LOG.info("calling to POST CoursesController.add()...");
		LOG.info("@ModelAttribute: "+course.toString());
		courseService.add(course);
		
		return "redirect:/courses/list";
	}
}
