package com.notasprogramacion.springboot.security.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notasprogramacion.springboot.security.entity.Employee;

@RestController
@RequestMapping("/rest")
public class TestRestController {

	@GetMapping("/testRequest") 
	public ResponseEntity<Employee> testRest() {
		Employee emp = new Employee(1,"Gonzalo","Silverio");
		
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
}
