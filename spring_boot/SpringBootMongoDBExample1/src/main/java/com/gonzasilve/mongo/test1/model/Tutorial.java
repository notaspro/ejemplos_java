package com.gonzasilve.mongo.test1.model;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Tutorial {

	@Id
	private String tutorialId;
	private String title;
	private String description;
	private String url;
	private List<Comment> comments;
	private long likes;

	public Tutorial() {

	}

	public String getTutorialId() {
		return tutorialId;
	}

	public void setTutorialId(String tutorialId) {
		this.tutorialId = tutorialId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Tutorial [tutorialId=" + tutorialId + ", title=" + title + ", description=" + description + ", url="
				+ url + ", comments=" + comments + ", likes=" + likes + "]";
	}

}
