package com.example.plan.replies.entity;

import com.example.plan.comments.entity.Comment;
import com.example.plan.common.BaseEntity;
import com.example.plan.plans.entity.Plan;

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

@Entity
@Table(name = "reply")
public class Reply extends BaseEntity {
	@Id
	@Column(name = "reply_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

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
	public Reply(String password, String contents, Plan plan) {
		this.password = password;
		this.contents = contents;
		this.plan = plan;
	}
}
