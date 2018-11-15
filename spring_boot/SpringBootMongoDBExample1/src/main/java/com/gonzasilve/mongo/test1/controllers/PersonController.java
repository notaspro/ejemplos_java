package com.gonzasilve.mongo.test1.controllers;

import java.util.Arrays;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gonzasilve.mongo.test1.dao.IPersonDao;
import com.gonzasilve.mongo.test1.model.Person;

//endpoint: http://localhost:8080/person/tests
@RestController
@RequestMapping("/person")
public class PersonController {

	private static final Logger LOG = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private IPersonDao personDao;

	@RequestMapping(value = "tests", method = RequestMethod.GET)
	public void getAllPets() {
		runTest();
	}

	public void runTest(String... args) {
		personDao.savePerson(new Person("Shubham", Arrays.asList("Harry potter", "Waking Up"), new Date(769372200000L)));
		personDao.savePerson(new Person("Sergey", Arrays.asList("Startup Guides", "Java"), new Date(664309800000L)));
		personDao.savePerson(new Person("David", Arrays.asList("Harry potter", "Success"), new Date(695845800000L)));
		personDao.savePerson(new Person("Ivan", Arrays.asList("Secrets of Butene", "Meeting Success"), new Date(569615400000L)));
		personDao.savePerson(new Person("Sergey", Arrays.asList("Harry potter", "Startup Guides"), new Date(348777000000L)));
		
		LOG.info("Getting all data from MongoDB: \n{}", personDao.getAllPerson());
		LOG.info("Getting paginated data from MongoDB: \n{}", personDao.getAllPersonPaginated(0, 2));
		LOG.info("Getting person By name 'Sergey': {}", personDao.findByName("Sergey"));
		LOG.info("Getting all person By name 'Sergey': {}", personDao.findOneByName("Sergey"));
		LOG.info("Getting people between age 22 & 26: {}", personDao.findByAgeRange(22, 26));
	}
}
