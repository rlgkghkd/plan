package com.example.plan.replies.entity;

import com.example.plan.comments.entity.Comment;
import com.example.plan.common.BaseEntity;
import com.example.plan.plans.entity.Plan;
import com.example.plan.replies.dto.PostReplyRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reply")
@Getter
@NoArgsConstructor
public class Reply extends BaseEntity {
	@Id
	@Column(name = "reply_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Size(max = 30)
	private String writer;
	private String password;

	@Size(max = 255)
	private String contents;

	@ManyToOne
	@JoinColumn(name = "plan_id")
	private Plan plan;

	@ManyToOne
	@JoinColumn(name = "comment_id")
	private Comment comment;

	@Builder
	public Reply(String writer, String password, String contents, Plan plan, Comment comment) {
		this.writer = writer;
		this.password = password;
		this.contents = contents;
		this.plan = plan;
		this.comment = comment;
	}

	public Reply(PostReplyRequest request, Plan plan, Comment comment){
		this.writer = request.getWriter();
		this.password = request.getPassword();
		this.contents = request.getContent();
		this.plan = plan;
		this.comment = comment;
	}

	public void updateContents(String contents){
		this.contents = contents;
	}
}
