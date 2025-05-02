package com.example.plan.plans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreatePlansRequest {
	@Size(max = 30)
	@NotEmpty
	private String writerId;
	@NotEmpty
	private String password;
	@Size(max = 30)
	@NotEmpty
	private String title;
	@Size(max = 255)
	private String content;

	@Builder
	public CreatePlansRequest(String writerId, String password, String title, String content) {
		this.writerId = writerId;
		this.password = password;
		this.title = title;
		this.content = content;
	}
}
