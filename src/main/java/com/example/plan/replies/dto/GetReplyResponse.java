package com.example.plan.replies.dto;

import java.time.LocalDateTime;

import com.example.plan.replies.entity.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetReplyResponse {
	private Long planId;
	private Long commentId;
	private Long replyId;
	private String writerId;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@Builder
	public GetReplyResponse(Long planId, Long commentId, Long replyId, String writerId, String content,
		LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.planId = planId;
		this.commentId = commentId;
		this.replyId = replyId;
		this.writerId = writerId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public GetReplyResponse(Reply reply) {
		this.planId = reply.getPlan().getId();
		this.commentId = reply.getComment().getId();
		this.replyId = reply.getId();
		this.writerId = reply.getWriterId();
		this.content = reply.getContents();
		this.createdAt = reply.getCreatedAt();
		this.updatedAt = reply.getUpdatedAt();
	}
}
