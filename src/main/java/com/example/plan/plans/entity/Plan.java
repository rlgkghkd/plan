package com.example.plan.plans.entity;

import java.util.List;

import com.example.plan.comments.entity.Comment;
import com.example.plan.common.BaseEntity;
import com.example.plan.plans.dto.PostPlanRequest;
import com.example.plan.replies.entity.Reply;

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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plan")
@Getter
@NoArgsConstructor
public class Plan extends BaseEntity {
	@Id
	@Column(name = "plan_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;

	@Size(max = 30)
	private String writerId;

	private String password;

	@Size(max = 30)
	private String title;

	@Size(max = 255)
	private String content;

	@Transient
	private int commentCount;

	@OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Comment> comments;

	@OneToMany(mappedBy = "plan", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reply> replies;

	@Builder
	public Plan(String writerId, String password, String title, String content) {
		this.writerId = writerId;
		this.password = password;
		this.title = title;
		this.content = content;
	}

	public Plan(PostPlanRequest request) {
		this.writerId = request.getWriterId();
		this.password = request.getPassword();
		this.title = request.getTitle();
		this.content = request.getContent();
	}

	public void updateCount(){this.commentCount = comments.size() + replies.size();}
	public void changeTitle(String title){
		this.title = title;
	}
	public void changeContent(String content){
		this.content = content;
	}
}
