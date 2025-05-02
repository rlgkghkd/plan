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
	private String writerId;
	@NotEmpty
	private String password;
	@Size(max = 255)
	private String contents;

	@Builder
	public PostCommentRequest(String writerId, String password, String contents) {
		this.writerId = writerId;
		this.password = password;
		this.contents = contents;
	}
}
