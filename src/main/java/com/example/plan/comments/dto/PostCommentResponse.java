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
	private String writerId;
	private String contents;
	private LocalDateTime createdAt;

	@Builder
	public PostCommentResponse(Long planId, Long commentId, String writerId, String contents, LocalDateTime createdAt) {
		this.planId = planId;
		this.commentId = commentId;
		this.writerId = writerId;
		this.contents = contents;
		this.createdAt = createdAt;
	}

	public PostCommentResponse(Comment comment) {
		this.planId = comment.getPlan().getId();
		this.commentId = comment.getId();
		this.writerId = comment.getWriterId();
		this.contents = comment.getContents();
		this.createdAt = comment.getCreatedAt();
	}
}
