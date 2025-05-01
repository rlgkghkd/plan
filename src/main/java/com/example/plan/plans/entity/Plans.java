package com.example.plan.plans.entity;

import java.util.List;

import org.hibernate.annotations.Cascade;

import com.example.plan.comments.entity.Comments;
import com.example.plan.common.BaseEntity;
import com.example.plan.plans.dto.CreatePlanRequest;
import com.example.plan.replys.entity.Replies;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Entity
@Table(name = "plans")
@Getter
public class Plans extends BaseEntity {
	@Id
	@Column(name = "plans_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Size(max = 30)
	@Column(name = "writer_id")
	private String writerId;

	private String password;

	@Size(max = 30)
	private String title;

	@Size(max = 255)
	private String content;

	@OneToMany(mappedBy = "plans", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comments> comments;

	@OneToMany(mappedBy = "plans", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Replies> replies;

	@Transient
	private Long commentCount;

	public Plans(CreatePlanRequest request) {
		this.writerId = request.getWriterId();
		this.password = request.getPassword();
		this.title = request.getTitle();
		this.content = request.getContent();
	}
}
