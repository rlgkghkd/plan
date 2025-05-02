package com.example.plan.comments;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.plan.comments.dto.DeleteCommentRequest;
import com.example.plan.comments.dto.PostCommentRequest;
import com.example.plan.comments.dto.PostCommentResponse;
import com.example.plan.comments.dto.UpdateCommentRequest;
import com.example.plan.comments.dto.UpdateCommentResponse;
import com.example.plan.comments.dto.GetCommentResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/plan/{planId}/comment")
public class CommentController {

	private CommentService commentService;

	@PostMapping
	public ResponseEntity<PostCommentResponse> postComment(@RequestBody PostCommentRequest request, @PathVariable Long planId){
		return ResponseEntity.created(URI.create("/api/plan/{planId}/comment/created")).body(commentService.postComment(request, planId));
	}

	@DeleteMapping("/{commentId}")
	public ResponseEntity<String> deleteComment(@RequestBody DeleteCommentRequest request, @PathVariable Long commentId){
		commentService.deleteComment(request, commentId);
		return ResponseEntity.ok().body("댓글 삭제되었습니다.");
	}

	@PatchMapping("/{commentId}")
	public ResponseEntity<UpdateCommentResponse> updateComment(@RequestBody UpdateCommentRequest request, @PathVariable Long commentId){
		return ResponseEntity.ok().body(commentService.updateComment(request, commentId));
	}

	@GetMapping("/{commentId}")
	public ResponseEntity<GetCommentResponse> getComment(@PathVariable Long commentId){
		return ResponseEntity.ok().body(commentService.getComment(commentId));
	}

	@GetMapping("/{commentId}")
	public ResponseEntity<Long> getParentPlanId(@PathVariable Long commentId){
		return ResponseEntity.ok().body(commentService.getParentPlanId(commentId));
	}
}
