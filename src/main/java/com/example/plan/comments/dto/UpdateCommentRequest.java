package com.example.plan.comments.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateCommentRequest {
	@NotEmpty
	private String password;
	@NotEmpty
	private String content;

	@Builder
	public UpdateCommentRequest(String password, String content) {
		this.password = password;
		this.content = content;
	}
}
