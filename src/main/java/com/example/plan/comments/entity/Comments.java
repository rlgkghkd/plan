package com.example.plan.comments.entity;

import java.util.List;

import com.example.plan.common.BaseEntity;
import com.example.plan.plans.entity.Plans;
import com.example.plan.replys.entity.Replies;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "comments")
public class Comments extends BaseEntity {
	@Id
	@Column(name = "comments_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String password;

	@Size(max = 255)
	private String Contents;

	@OneToMany(mappedBy = "comments", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Replies> replies;

	@ManyToOne
	@JoinColumn(name = "plans_id")
	private Plans plans;

}
