package com.example.plan.comments.dto;

import java.time.LocalDateTime;

import com.example.plan.comments.entity.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCommentResponse {
	private Long planId;
	private Long commentId;
	private String writer;
	private String contents;
	private LocalDateTime createdAt;

	@Builder
	public PostCommentResponse(Long planId, Long commentId, String writer, String contents, LocalDateTime createdAt) {
		this.planId = planId;
		this.commentId = commentId;
		this.writer = writer;
		this.contents = contents;
		this.createdAt = createdAt;
	}

	public PostCommentResponse(Comment comment) {
		this.planId = comment.getPlan().getId();
		this.commentId = comment.getId();
		this.writer = comment.getWriter();
		this.contents = comment.getContents();
		this.createdAt = comment.getCreatedAt();
	}
}
