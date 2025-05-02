package com.example.plan.replies.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeleteReplyRequest {

	@NotEmpty
	private String password;

	@Builder
	public DeleteReplyRequest(String password) {
		this.password = password;
	}
}
