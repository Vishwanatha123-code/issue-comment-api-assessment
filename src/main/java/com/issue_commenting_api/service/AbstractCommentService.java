package com.issue_commenting_api.service;

import java.util.List;

import com.issue_commenting_api.model.Comment;

public class AbstractCommentService implements CommentService{

	@Override
	public Comment addComment(String issueId, String author, String message) {		
		
		return null;
	}

	@Override
	public List<Comment> getCommentsByIssueId(String issueId) {		
		
		return null;
	}

	@Override
	public List<Comment> getCommentsByAuthor(String author) {
	
		return null;
	}

}
