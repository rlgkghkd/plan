package com.example.plan.replies.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostReplyRequest {

	@NotEmpty
	@Size(max = 30)
	private String writerId;
	@NotEmpty
	private String password;
	@NotEmpty
	@Size(max = 30)
	private String contents;

	@Builder
	public PostReplyRequest(String writerId, String password, String contents) {
		this.writerId = writerId;
		this.password = password;
		this.contents = contents;
	}
}
