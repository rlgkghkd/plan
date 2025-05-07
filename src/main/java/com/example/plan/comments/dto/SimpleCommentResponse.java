package com.example.plan.comments.dto;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import com.example.plan.comments.entity.Comment;
import com.example.plan.replies.dto.SimpleReplyResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SimpleCommentResponse {
	private String writerId;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<SimpleReplyResponse> replyResponses;

	public SimpleCommentResponse(String writerId, String content, LocalDateTime createdAt, LocalDateTime updatedAt,
		List<SimpleReplyResponse> replyResponses) {
		this.writerId = writerId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.replyResponses = replyResponses;
	}

	public SimpleCommentResponse(Comment comment) {
		this.writerId = comment.getWriterId();
		this.content = comment.getContents();
		this.createdAt = comment.getCreatedAt();
		this.updatedAt = comment.getUpdatedAt();
		this.replyResponses = comment.getReplies().stream().map(SimpleReplyResponse::new).sorted(Comparator.comparing(SimpleReplyResponse::getCreatedAt)).toList();
	}
}
