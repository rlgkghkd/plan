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
	private String writer;
	private String password;
	@NotEmpty
	@Size(max = 30)
	private String content;

	@Builder
	public PostReplyRequest(String writer, String password, String content) {
		this.writer = writer;
		this.password = password;
		this.content = content;
	}
}
