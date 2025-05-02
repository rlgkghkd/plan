package com.example.plan.plans.dto;

import java.time.LocalDateTime;

import com.example.plan.plans.entity.Plans;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePlansResponse {
	private Long planId;
	private String writeId;
	private String title;
	private String content;
	private LocalDateTime updatedAt;

	@Builder
	public UpdatePlansResponse(Long planId, String writeId, String title, String content,
		LocalDateTime updatedAt) {
		this.planId = planId;
		this.writeId = writeId;
		this.title = title;
		this.content = content;
		this.updatedAt = updatedAt;
	}

	public UpdatePlansResponse(Plans plans) {
		this.planId = plans.getId();
		this.writeId = plans.getWriterId();
		this.title = plans.getTitle();
		this.content = plans.getContent();
		this.updatedAt = plans.getUpdatedAt();
	}
}
