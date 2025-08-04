package com.issue_commenting_api.service;

import java.util.List;

import com.issue_commenting_api.model.Comment;

public interface CommentService {
	
	Comment addComment(String issueId, String author, String message);
    List<Comment> getCommentsByIssueId(String issueId);
    List<Comment> getCommentsByAuthor(String author);

}
