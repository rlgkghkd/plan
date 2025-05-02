package com.example.plan.replies;

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

import com.example.plan.replies.dto.DeleteReplyRequest;
import com.example.plan.replies.dto.GetReplyResponse;
import com.example.plan.replies.dto.PostReplyRequest;
import com.example.plan.replies.dto.PostReplyResponse;
import com.example.plan.replies.dto.UpdateReplyRequest;
import com.example.plan.replies.dto.UpdateReplyResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/plan/{planId}/comment/{commentId}/reply")
public class ReplyController {
	private final ReplyService replyService;

	@PostMapping
	public ResponseEntity<PostReplyResponse> postReply(
		@RequestBody PostReplyRequest request,
		@PathVariable Long planId,
		@PathVariable Long commentId) {
		return ResponseEntity.created(URI.create("/api/plan/{planId}/comment/{commentId}/reply/created")).body(replyService.postReply(request, planId, commentId));
	}

	@DeleteMapping("/{replyId}")
	public ResponseEntity<String> deleteReply(@RequestBody DeleteReplyRequest request, @PathVariable Long replyId){
		replyService.deleteReply(request, replyId);
		return ResponseEntity.ok().body("삭제되었습니다.");
	}

	@PatchMapping("/{replyId}")
	public ResponseEntity<UpdateReplyResponse> updateReply(@RequestBody UpdateReplyRequest request, @PathVariable Long replyId){
		return ResponseEntity.ok().body(replyService.updateReply(request, replyId));
	}

	@GetMapping("/{replyId}")
	public ResponseEntity<GetReplyResponse> getReply(@PathVariable Long replyId){
		return ResponseEntity.ok().body(replyService.getReply(replyId));
	}
}
