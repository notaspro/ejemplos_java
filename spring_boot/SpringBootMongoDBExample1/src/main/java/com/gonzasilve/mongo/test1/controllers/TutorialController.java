package com.gonzasilve.mongo.test1.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gonzasilve.mongo.test1.dao.ITutorialDao;
import com.gonzasilve.mongo.test1.model.Comment;
import com.gonzasilve.mongo.test1.model.Tutorial;

//endpoint: http://localhost:8080/customer/tests
@RestController
@RequestMapping("/tutorial")
public class TutorialController {

	@Autowired
	private ITutorialDao tutorialDao;

	@RequestMapping(value = "tests", method = RequestMethod.GET)
	public void getAllPets() {
		runTest();
	}

	public void runTest() {
		Tutorial tutorial = new Tutorial();
		tutorial.setUrl("http://www.tutorialspoint.com/mongodb/");
		tutorial.setTitle("MongoDB");
		tutorial.setDescription("database tecnology");
		tutorial.setLikes(77);
		List<Comment> listDocuments = new ArrayList<>();
		Comment comment = new Comment();
		comment.setDateCreated(new Date());
		comment.setLikes(34L);
		comment.setMessage("nuevo mensaje ");
		comment.setUser("gonzasilve");
		listDocuments.add(comment);

		tutorial.setComments(listDocuments);

		tutorialDao.save(tutorial);
	}
}
