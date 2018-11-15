package com.gonzasilve.mongo.test1.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.gonzasilve.mongo.test1.dao.ITutorialDao;
import com.gonzasilve.mongo.test1.model.Comment;
import com.gonzasilve.mongo.test1.model.Tutorial;
import com.mongodb.client.MongoCollection;

public class TutorialDaoImpl implements ITutorialDao {

	private MongoTemplate mongoTemplate;
	MongoCollection<Document> dbCollection;

	@Autowired
	public TutorialDaoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
		dbCollection = this.mongoTemplate.getCollection("person");
	}
	
	@Override
	public Tutorial save(Tutorial tutorial) {
/*
		// insertar un documento
		Document newDoc = new Document();
		Document newDocChildren = new Document();
		newDocChildren.put("calle", "Dario Fernandez");
		newDocChildren.put("numero", 19);
		newDoc.put("nombre", "Gonzalo");
		newDoc.put("Apellidos", "Pérez Silverio");
		newDoc.put("direccion", newDocChildren);
		dbCollection.insertOne(newDoc);
*/
		//private List<Comment> comments = ;
		Document newTutorialDocument = new Document("tutorialId", tutorial.getTutorialId())
				.append("title", tutorial.getTitle())
				.append("description", tutorial.getDescription())
				.append("url", tutorial.getUrl())
		.append("likes", tutorial.getLikes());
		
		List<Document> listDocuments = new ArrayList<>();
		for(Comment comment: tutorial.getComments()) {
			Document newComentDocument = new Document("user", comment.getUser())
					.append("message", comment.getMessage())
					.append("dateCreated", comment.getDateCreated())
					.append("likes", comment.getLikes());
			listDocuments.add(newComentDocument);
		}
		newTutorialDocument.append("comments", listDocuments);
		dbCollection.insertOne(newTutorialDocument);
		String id = newTutorialDocument.get("_id", String.class);
		tutorial.setTutorialId(id);
		
/*
		// Buscar un documento
		Bson filter = new Document("name", "Shubham");
		FindIterable<Document> list = dbCollection.find(filter);
		//dbCollection.fin
		MongoCursor<Document> cursor = list.iterator();

		while (cursor.hasNext()) {
			Document currentDocument = cursor.next();
			System.out.println(currentDocument.toJson());
		}
*/
		return tutorial;
	}

}
