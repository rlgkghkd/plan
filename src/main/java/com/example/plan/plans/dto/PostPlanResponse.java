package com.example.plan.plans.dto;

import java.time.LocalDateTime;

import com.example.plan.plans.entity.Plan;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostPlanResponse {
	private Long planId;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime createdAt;

	@Builder
	public PostPlanResponse(Long planId, String writer, String title, String content, LocalDateTime createdAt) {
		this.planId = planId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}

	public PostPlanResponse(Plan plan){
		this.planId = plan.getId();
		this.writer = plan.getWriter();
		this.title = plan.getTitle();
		this.content = plan.getContent();
		this.createdAt = plan.getCreatedAt();
	}
}
