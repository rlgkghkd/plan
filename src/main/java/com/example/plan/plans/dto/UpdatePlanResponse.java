package com.example.plan.plans.dto;

import java.time.LocalDateTime;

import com.example.plan.plans.entity.Plan;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePlanResponse {
	private Long planId;
	private String write;
	private String title;
	private String content;
	private LocalDateTime updatedAt;

	@Builder
	public UpdatePlanResponse(Long planId, String write, String title, String content,
		LocalDateTime updatedAt) {
		this.planId = planId;
		this.write = write;
		this.title = title;
		this.content = content;
		this.updatedAt = updatedAt;
	}

	public UpdatePlanResponse(Plan plan) {
		this.planId = plan.getId();
		this.write = plan.getWriter();
		this.title = plan.getTitle();
		this.content = plan.getContent();
		this.updatedAt = plan.getUpdatedAt();
	}
}
