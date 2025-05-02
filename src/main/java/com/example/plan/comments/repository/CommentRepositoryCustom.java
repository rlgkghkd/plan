package com.example.plan.comments.repository;

import com.example.plan.comments.entity.Comment;

public interface CommentRepositoryCustom {
	Comment findCommentById(Long id);
}
