package com.gonzasilve.mongo.test1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gonzasilve.mongo.test1.model.Customer;
import com.gonzasilve.mongo.test1.repositories.CustomerRepository;

//endpoint: http://localhost:8080/customer/tests
@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerRepository repository;

	@RequestMapping(value = "tests", method = RequestMethod.GET)
	public void getAllPets() {
		runTest();
	}

	public void runTest() {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}

	}
}
