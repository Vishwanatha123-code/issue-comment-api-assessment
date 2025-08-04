package com.issue_commenting_api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.issue_commenting_api.model.Comment;
import com.issue_commenting_api.model.CommentRequest;
import com.issue_commenting_api.service.CommentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/comments")
public class CommentController {
	
	private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public ResponseEntity<Comment> addComment(@Valid @RequestBody CommentRequest request) {
        Comment comment = commentService.addComment(request.getIssueId(), request.getAuthor(), request.getMessage());
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    
    @GetMapping("/by-issue")
    public ResponseEntity<List<Comment>> getCommentsByIssue(@RequestParam String issueId) {
        return ResponseEntity.ok(commentService.getCommentsByIssueId(issueId));
    }

    @GetMapping("/by-author")
    public ResponseEntity<List<Comment>> getCommentsByAuthor(@RequestParam String author) {
        return ResponseEntity.ok(commentService.getCommentsByAuthor(author));
    }


}
