package com.example.plan.replies.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateReplyRequest {

	@NotNull
	private String password;
	@NotNull
	@Size(max = 255)
	private String contents;

	@Builder
	public UpdateReplyRequest(String password, String contents) {
		this.password = password;
		this.contents = contents;
	}
}
