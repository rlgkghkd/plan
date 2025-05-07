package com.example.plan.replies.dto;

import java.time.LocalDateTime;

import com.example.plan.replies.entity.Reply;

import lombok.Getter;

@Getter
public class SimpleReplyResponse {
	private String writerId;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	public SimpleReplyResponse(String writerId, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.writerId = writerId;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public SimpleReplyResponse(Reply reply) {
		this.writerId = reply.getWriterId();
		this.content = reply.getContents();
		this.createdAt = reply.getCreatedAt();
		this.updatedAt = reply.getUpdatedAt();
	}
}
