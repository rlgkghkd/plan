package com.example.plan.comments;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.plan.comments.dto.DeleteCommentRequest;
import com.example.plan.comments.dto.PostCommentRequest;
import com.example.plan.comments.dto.PostCommentResponse;
import com.example.plan.comments.dto.UpdateCommentRequest;
import com.example.plan.comments.dto.UpdateCommentResponse;
import com.example.plan.comments.entity.Comment;
import com.example.plan.comments.repository.CommentRepository;
import com.example.plan.plans.PlanService;
import com.example.plan.comments.dto.GetCommentResponse;
import com.example.plan.plans.entity.Plan;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {

	private CommentRepository commentRepository;
	private PlanService planService;

	public PostCommentResponse postComment(PostCommentRequest request, Long planId) {
		Plan plan = planService.findPlan(planId);
		Comment saved = commentRepository.save(new Comment(request, plan));
		return new PostCommentResponse(saved);
	}

	public void deleteComment(DeleteCommentRequest request, Long commentId) {
		Comment comment = commentRepository.findCommentById(commentId);
		if(!comment.getPassword().equals(request.getPassword())){
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
		}
		commentRepository.delete(comment);
	}

	@Transactional
	public UpdateCommentResponse updateComment(UpdateCommentRequest request, Long commentId) {
		Comment comment = commentRepository.findCommentById(commentId);
		if (!comment.getPassword().equals(request.getPassword())){throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");}
		comment.changeContents(request.getContent());
		return new UpdateCommentResponse(comment);
	}

	public GetCommentResponse getComment(Long commentId) {
		return new GetCommentResponse(commentRepository.findCommentById(commentId));
	}

	public Long getParentPlanId(Long commentId) {
		Comment comment = commentRepository.findCommentById(commentId);
		return comment.getPlan().getId();
	}
}
