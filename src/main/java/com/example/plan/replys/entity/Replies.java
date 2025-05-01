package com.example.plan.replys.entity;

import com.example.plan.comments.entity.Comments;
import com.example.plan.common.BaseEntity;
import com.example.plan.plans.entity.Plans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "replies")
public class Replies extends BaseEntity {
	@Id
	@Column(name = "replies_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String password;

	@Size(max = 255)
	private String Contents;

	@ManyToOne
	@JoinColumn(name = "plans_id")
	private Plans plans;

	@ManyToOne
	@JoinColumn(name = "comments_id")
	private Comments comments;
}
