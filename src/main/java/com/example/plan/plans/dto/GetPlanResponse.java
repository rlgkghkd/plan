package com.example.plan.plans.dto;

import java.time.LocalDateTime;

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

	@Builder
	public GetPlanResponse(Long planId, String writerId, String title, String content, LocalDateTime createdAt,
		LocalDateTime updatedAt, int commentsCount) {
		this.planId = planId;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.commentsCount = commentsCount;
	}

	public GetPlanResponse(Plan plan) {
		this.planId = plan.getId();
		this.writerId = plan.getWriterId();
		this.title = plan.getTitle();
		this.content = plan.getContent();
		this.createdAt = plan.getCreatedAt();
		this.updatedAt = plan.getUpdatedAt();
		this.commentsCount = plan.getCommentCount();
	}
}
