package com.example.plan.plans.dto;

import java.time.LocalDateTime;

import com.example.plan.plans.entity.Plans;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPlansListResponse {
	private Long planId;
	private String writerID;
	private String title;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int commentsCount;

	@Builder
	public GetPlansListResponse(Long planId, String writerID, String title, LocalDateTime createdAt,
		LocalDateTime updatedAt) {
		this.planId = planId;
		this.writerID = writerID;
		this.title = title;
	}

	public GetPlansListResponse(Plans plans) {
		this.planId = plans.getId();
		this.writerID = plans.getWriterId();
		this.title = plans.getTitle();
		this.createdAt = plans.getCreatedAt();
		this.updatedAt = plans.getUpdatedAt();
		this.commentsCount = plans.getCommentCount();
	}
}
