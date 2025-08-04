package com.issue_commenting_api.service;

import org.junit.jupiter.api.Test;

import com.issue_commenting_api.model.Comment;

import java.util.List;



import static org.junit.jupiter.api.Assertions.*;

public class CommentServiceTest {
	
	
	 private final CommentService commentService = new CommentServiceImpl();

	    @Test
	    void testAddAndRetrieveCommentsByIssueId() {
	        String issueId = "0e8400-e29b-4d4-16-55440000";
	        commentService.addComment(issueId, "aaa", "First comment");
	        commentService.addComment(issueId, "bbb", "Second comment");

	        List<Comment> comments = commentService.getCommentsByIssueId(issueId);
	        assertEquals(2, comments.size());
	    }

	    @Test
	    void testGetCommentsByAuthor() {
	        commentService.addComment("id1", "john", "test 1");
	        commentService.addComment("id2", "john", "test 2");
	        commentService.addComment("id3", "alice", "not john");

	        List<Comment> johnsComments = commentService.getCommentsByAuthor("john");
	        assertEquals(2, johnsComments.size());
	    }

}
