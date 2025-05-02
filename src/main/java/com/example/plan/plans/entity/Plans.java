package com.example.plan.plans.entity;

import java.util.List;

import com.example.plan.comments.entity.Comments;
import com.example.plan.common.BaseEntity;
import com.example.plan.plans.dto.CreatePlansRequest;
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
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "plans")
@Getter
@NoArgsConstructor
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
	private int commentCount;

	@Builder
	public Plans(String writerId, String password, String title, String content) {
		this.writerId = writerId;
		this.password = password;
		this.title = title;
		this.content = content;
	}

	public Plans(CreatePlansRequest request) {
		this.writerId = request.getWriterId();
		this.password = request.getPassword();
		this.title = request.getTitle();
		this.content = request.getContent();
	}

	public void updateCount(){this.commentCount = comments.size() + replies.size();}
	public void changeTitle(String title){
		this.title = title;
	}
	public void chageContent(String content){
		this.content = content;
	}
}
