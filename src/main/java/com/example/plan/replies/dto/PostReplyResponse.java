package com.example.plan.replies.dto;

import java.time.LocalDateTime;

import com.example.plan.replies.entity.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostReplyResponse {
	private Long planId;
	private Long commentId;
	private Long replyId;
	private String writerId;
	private String content;
	private LocalDateTime createdAt;

	@Builder
	public PostReplyResponse(Long planId, Long commentId, Long replyId, String writerId, String content,
		LocalDateTime createdAt) {
		this.planId = planId;
		this.commentId = commentId;
		this.replyId = replyId;
		this.writerId = writerId;
		this.content = content;
		this.createdAt = createdAt;
	}

	public PostReplyResponse(Reply reply) {
		this.planId = reply.getPlan().getId();
		this.commentId = reply.getComment().getId();
		this.replyId = reply.getId();
		this.writerId = reply.getWriterId();
		this.content = reply.getContents();
		this.createdAt = reply.getCreatedAt();
	}
}
