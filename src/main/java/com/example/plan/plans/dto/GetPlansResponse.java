package com.example.plan.plans.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Stream;

import com.example.plan.comments.entity.Comments;
import com.example.plan.plans.entity.Plans;
import com.example.plan.replys.entity.Replies;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetPlansResponse {
	private Long planId;
	private String writerId;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private int commentsCount;
	private List<Comments> comments;

	@Builder
	public GetPlansResponse(Long planId, String writerId, String title, String content, LocalDateTime createdAt,
		LocalDateTime updatedAt, int commentsCount, List<Comments> comments) {
		this.planId = planId;
		this.writerId = writerId;
		this.title = title;
		this.content = content;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.commentsCount = commentsCount;
		this.comments = comments;
	}

	public GetPlansResponse(Plans plans) {
		this.planId = plans.getId();
		this.writerId = plans.getWriterId();
		this.title = plans.getTitle();
		this.content = plans.getContent();
		this.createdAt = plans.getCreatedAt();
		this.updatedAt = plans.getUpdatedAt();
		this.commentsCount = plans.getCommentCount();
		this.comments = plans.getComments();
	}
}
