package com.issue_commenting_api.model;

import java.time.Instant;
import java.util.UUID;



public class Comment {
	
	    private String id;
	    private String issueId;
	    private String author;
	    private String message;
	    private Instant createdAt;

	    public Comment(String issueId, String author, String message) {
	        this.id = UUID.randomUUID().toString();
	        this.issueId = issueId;
	        this.author = author;
	        this.message = message;
	        this.createdAt = Instant.now();
	    }

	    public String getId() {
	        return id;
	    }

	    public String getIssueId() {
	        return issueId;
	    }

	    public String getAuthor() {
	        return author;
	    }

	    public String getMessage() {
	        return message;
	    }

	    public Instant getCreatedAt() {
	        return createdAt;
	    }

}
