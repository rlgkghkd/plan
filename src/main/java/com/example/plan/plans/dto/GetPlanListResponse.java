package com.example.plan.plans.dto;

import java.time.LocalDateTime;

import com.example.plan.plans.entity.Plan;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPlanListResponse {
	private Long planId;
	private String writer;
	private String title;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int commentsCount;

	@Builder
	public GetPlanListResponse(Long planId, String writer, String title, LocalDateTime createdAt,
		LocalDateTime updatedAt) {
		this.planId = planId;
		this.writer = writer;
		this.title = title;
	}

	public GetPlanListResponse(Plan plan) {
		this.planId = plan.getId();
		this.writer = plan.getWriter();
		this.title = plan.getTitle();
		this.createdAt = plan.getCreatedAt();
		this.updatedAt = plan.getUpdatedAt();
		this.commentsCount = plan.getCommentCount();
	}
}
