package com.example.plan.comments.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DeleteCommentRequest {
	@NotEmpty
	private String password;

	@Builder
	public DeleteCommentRequest(String password) {
		this.password = password;
	}
}
