package com.issue_commenting_api.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.issue_commenting_api.model.Comment;
@Service
public class CommentServiceImpl extends AbstractCommentService{
	
	
	
	private final Map<String, List<Comment>> commentStore = new ConcurrentHashMap<>();

    @Override
    public Comment addComment(String issueId, String author, String message) {
        Comment comment = new Comment(issueId, author, message);
        commentStore.computeIfAbsent(issueId, k -> new ArrayList<>()).add(comment);
        return comment;
    }

    @Override
    public List<Comment> getCommentsByIssueId(String issueId) {
        return commentStore.getOrDefault(issueId, Collections.emptyList());
    }

    @Override
    public List<Comment> getCommentsByAuthor(String author) {
        return commentStore.values().stream()
                .flatMap(List::stream)
                .filter(c -> c.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

}
