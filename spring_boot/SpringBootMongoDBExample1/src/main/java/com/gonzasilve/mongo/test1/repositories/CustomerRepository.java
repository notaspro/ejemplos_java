package com.gonzasilve.mongo.test1.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gonzasilve.mongo.test1.model.Customer;

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
	public Customer findByFirstName(String firstName);
	public List<Customer> findByLastName(String lastName);
	
}
