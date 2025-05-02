package com.example.plan.replies.dto;

import java.time.LocalDateTime;

import com.example.plan.replies.entity.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateReplyResponse {
	private Long replyId;
	private String writer;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@Builder
	public UpdateReplyResponse(Long replyId, String writer, String content, LocalDateTime createdAt,
		LocalDateTime updatedAt) {
		this.replyId = replyId;
		this.writer = writer;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UpdateReplyResponse(Reply reply) {
		this.replyId = reply.getId();
		this.writer = reply.getWriter();
		this.content = reply.getContents();
		this.createdAt = reply.getCreatedAt();
		this.updatedAt = reply.getUpdatedAt();
	}
}
