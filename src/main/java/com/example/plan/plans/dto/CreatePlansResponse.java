package com.example.plan.plans.dto;

import java.time.LocalDateTime;

import com.example.plan.plans.entity.Plans;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePlansResponse {
	private Long planId;
	private String writerId;
	private String title;
	private String content;
	private LocalDateTime createdAt;

	@Builder
	public CreatePlansResponse(Long planId, String writerId, String title, String content, LocalDateTime createdAt) {
		this.planId = planId;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
	}

	public CreatePlansResponse(Plans plans){
		this.planId = plans.getId();
		this.writerId = plans.getWriterId();
		this.title = plans.getTitle();
		this.content = plans.getContent();
		this.createdAt = plans.getCreatedAt();
	}
}
