package com.example.plan.comments.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCommentRequest {

	@Size(max = 30)
	@NotEmpty
	private String writer;
	@NotEmpty
	private String password;
	@Size(max = 255)
	private String contents;

	@Builder
	public PostCommentRequest(String writer, String password, String contents) {
		this.writer = writer;
		this.password = password;
		this.contents = contents;
	}
}
