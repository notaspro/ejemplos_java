package com.gonzasilve.mongo.test1.model;

import java.util.Date;

public class Comment {

	private String user;
	private String message;
	private Date dateCreated;
	private Long likes;

	public Comment() {
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Long getLikes() {
		return likes;
	}

	public void setLikes(Long likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Comment [user=" + user + ", message=" + message + ", dateCreated=" + dateCreated + ", likes=" + likes
				+ "]";
	}

}
