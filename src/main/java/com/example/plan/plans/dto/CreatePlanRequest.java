package com.example.plan.plans.dto;

import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePlanRequest {
	@Size(max = 30)
	private String writerId;
	private String password;
	@Size(max = 30)
	private String title;
	@Size(max = 255)
	private String content;

	@Builder
	public CreatePlanRequest(String writerId, String password, String title, String content) {
		this.writerId = writerId;
		this.password = password;
		this.title = title;
		this.content = content;
	}
}
