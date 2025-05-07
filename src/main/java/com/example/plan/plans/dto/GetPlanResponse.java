package com.example.plan.plans.dto;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import com.example.plan.comments.dto.SimpleCommentResponse;
import com.example.plan.comments.entity.Comment;
import com.example.plan.plans.entity.Plan;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPlanResponse {
	private Long planId;
	private String writerId;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int commentsCount;
	private List<SimpleCommentResponse> commentResponses;

	@Builder
	public GetPlanResponse(Long planId, String writerId, String title, String content, LocalDateTime createdAt,
		LocalDateTime updatedAt, int commentsCount, List<SimpleCommentResponse> commentResponses) {
		this.planId = planId;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.commentsCount = commentsCount;
		this.commentResponses = commentResponses;
	}

	public GetPlanResponse(Plan plan) {
		this.planId = plan.getId();
		this.writerId = plan.getWriterId();
		this.title = plan.getTitle();
		this.content = plan.getContent();
		this.createdAt = plan.getCreatedAt();
		this.updatedAt = plan.getUpdatedAt();
		this.commentsCount = plan.getCommentCount();
		this.commentResponses = plan.getComments().stream().map(SimpleCommentResponse::new).sorted(Comparator.comparing(SimpleCommentResponse::getCreatedAt)).toList();
	}
}
