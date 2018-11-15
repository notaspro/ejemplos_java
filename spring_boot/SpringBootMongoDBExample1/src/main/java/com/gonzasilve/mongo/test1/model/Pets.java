package com.gonzasilve.mongo.test1.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Pets {
	
	@Id
	private ObjectId _id;

	private String name;
	private String species;
	private String breed;

	public Pets() {

	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Override
	public String toString() {
		return "Pets [_id=" + _id + ", name=" + name + ", species=" + species + ", breed=" + breed + "]";
	}

}
