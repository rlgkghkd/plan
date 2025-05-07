package com.example.plan.replies.dto;

import java.time.LocalDateTime;

import com.example.plan.comments.entity.Comment;
import com.example.plan.replies.entity.Reply;

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
	private GetReplyResponse replyResponses;

	@Builder
	public JustACommentResponse(String writerId, String content, LocalDateTime createdAt, LocalDateTime updatedAt,
		GetReplyResponse replyResponses) {
		this.writerId = writerId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.replyResponses = replyResponses;
	}

	public JustACommentResponse(Comment comment, Reply reply) {
		this.writerId = comment.getWriterId();
		this.content = comment.getContents();
		this.createdAt = comment.getCreatedAt();
		this.updatedAt = comment.getUpdatedAt();
		this.replyResponses = new GetReplyResponse(reply);

	}
}
