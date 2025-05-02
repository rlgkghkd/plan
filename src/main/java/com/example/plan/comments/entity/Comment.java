package com.example.plan.comments.entity;

import java.util.List;

import com.example.plan.comments.dto.PostCommentRequest;
import com.example.plan.common.BaseEntity;
import com.example.plan.plans.entity.Plan;
import com.example.plan.replies.entity.Reply;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comment")
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String writerId;

	private String password;

	@Size(max = 255)
	private String contents;

	@OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Reply> replies;

	@ManyToOne
	private Plan plan;

	@Builder
	public Comment(Long id, String writerId, String password, String contents, List<Reply> replies, Plan plan) {
		this.id = id;
		this.writerId = writerId;
		this.password = password;
		this.contents = contents;
		this.replies = replies;
		this.plan = plan;
	}

	public Comment(PostCommentRequest request, Plan plan) {
		this.writerId = request.getWriterId();
		this.password = request.getPassword();
		this.contents = request.getContents();
		this.plan = plan;
	}

	public void changeContents(String contents){
		this.contents = contents;
	}
}
