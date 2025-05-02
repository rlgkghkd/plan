package com.example.plan.plans.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdatePlansRequest {
	@NotEmpty
	private String writeId;
	@NotEmpty
	private String password;
	private String title;
	private String content;

	@Builder
	public UpdatePlansRequest(String writeId, String password, String title, String content) {
		this.writeId = writeId;
		this.password = password;
		this.title = title;
		this.content = content;
	}
}
