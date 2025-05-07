package com.example.plan.replies.dto;

import java.time.LocalDateTime;

import com.example.plan.comments.entity.Comment;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class JustACommentResponse {
	private String writerId;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private SimpleReplyResponse replyResponses;

	@Builder
	public JustACommentResponse(String writerId, String content, LocalDateTime createdAt, LocalDateTime updatedAt,
		SimpleReplyResponse replyResponses) {
		this.writerId = writerId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.replyResponses = replyResponses;
	}

	public JustACommentResponse(Comment comment, SimpleReplyResponse replyResponses) {
		this.writerId = comment.getWriterId();
		this.content = comment.getContents();
		this.createdAt = comment.getCreatedAt();
		this.updatedAt = comment.getUpdatedAt();
		this.replyResponses = replyResponses;

	}
}
