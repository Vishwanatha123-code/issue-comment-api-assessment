package com.issue_commenting_api.model;

import javax.validation.constraints.NotBlank;

public class CommentRequest {
	
	
	
	@NotBlank(message = "IssueId is required")
    private String issueId;

    @NotBlank(message = "Author is required")
    private String author;

    @NotBlank(message = "Message is required")
    private String message;

    public String getIssueId() { 
    	return issueId; 
    	}
    public void setIssueId(String issueId) {
    	this.issueId = issueId; 
        }
    public String getAuthor() { 
    	return author; 
    	}
    public void setAuthor(String author) {
    	this.author = author; 
    	}
    public String getMessage() { 
    	return message; 
    	}
    public void setMessage(String message) {
    	this.message = message; 
    	}

}
