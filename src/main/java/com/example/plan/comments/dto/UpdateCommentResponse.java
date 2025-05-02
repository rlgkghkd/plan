package com.example.plan.comments.dto;

import java.time.LocalDateTime;

import com.example.plan.comments.entity.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateCommentResponse {

	private Long commentId;
	private String writer;
	private String contents;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@Builder
	public UpdateCommentResponse(Long commentId, String writer, String contents, LocalDateTime createdAt,
		LocalDateTime updatedAt) {
		this.commentId = commentId;
		this.writer = writer;
		this.contents = contents;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UpdateCommentResponse(Comment comment) {
		this.commentId = comment.getId();
		this.writer = comment.getWriter();
		this.contents = comment.getContents();
		this.createdAt = comment.getCreatedAt();
		this.updatedAt = comment.getUpdatedAt();
	}
}
