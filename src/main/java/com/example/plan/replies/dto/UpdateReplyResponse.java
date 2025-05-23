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
	private String writerId;
	private String contents;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;

	@Builder
	public UpdateReplyResponse(Long replyId, String writerId, String contents, LocalDateTime createdAt,
		LocalDateTime updatedAt) {
		this.replyId = replyId;
		this.writerId = writerId;
		this.contents = contents;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public UpdateReplyResponse(Reply reply) {
		this.replyId = reply.getId();
		this.writerId = reply.getWriterId();
		this.contents = reply.getContents();
		this.createdAt = reply.getCreatedAt();
		this.updatedAt = reply.getUpdatedAt();
	}
}
