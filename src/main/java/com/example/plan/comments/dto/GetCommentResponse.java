package com.example.plan.comments.dto;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import com.example.plan.comments.entity.Comment;
import com.example.plan.replies.dto.SimpleReplyResponse;
import com.example.plan.replies.entity.Reply;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetCommentResponse {
	private Long planId;
	private Long commentId;
	private String writerId;
	private String contents;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<SimpleReplyResponse> replies;

	@Builder
	public GetCommentResponse(Long planId, Long commentId, String writerId, String contents, LocalDateTime createdAt,
		LocalDateTime updatedAt, List<SimpleReplyResponse> replies) {
		this.planId = planId;
		this.commentId = commentId;
		this.writerId = writerId;
		this.contents = contents;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.replies = replies;
	}

	public GetCommentResponse(Comment comment) {
		this.planId = comment.getPlan().getId();
		this.commentId = comment.getId();
		this.writerId = comment.getWriterId();
		this.contents = comment.getContents();
		this.createdAt = comment.getCreatedAt();
		this.updatedAt = comment.getUpdatedAt();
		this.replies = comment.getReplies().stream().map(SimpleReplyResponse::new).sorted(Comparator.comparing(SimpleReplyResponse::getCreatedAt)).toList();
	}
}
