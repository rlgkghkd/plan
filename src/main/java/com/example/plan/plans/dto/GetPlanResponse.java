package com.example.plan.plans.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.example.plan.comments.entity.Comment;
import com.example.plan.plans.entity.Plan;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPlanResponse {
	private Long planId;
	private String writer;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int commentsCount;

	@Builder
	public GetPlanResponse(Long planId, String writer, String title, String content, LocalDateTime createdAt,
		LocalDateTime updatedAt, int commentsCount) {
		this.planId = planId;
		this.writer = writer;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.commentsCount = commentsCount;
	}

	public GetPlanResponse(Plan plan) {
		this.planId = plan.getId();
		this.writer = plan.getWriter();
		this.title = plan.getTitle();
		this.content = plan.getContent();
		this.createdAt = plan.getCreatedAt();
		this.updatedAt = plan.getUpdatedAt();
		this.commentsCount = plan.getCommentCount();
	}
}
