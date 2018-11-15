package com.gonzasilve.mongo.test1.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.gonzasilve.mongo.test1.model.Pets;

public interface PetsRepository extends MongoRepository<Pets, String> {
	
	public Pets findBy_id(ObjectId _id);
	
}
