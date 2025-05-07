package com.example.plan.replies;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.plan.comments.CommentService;
import com.example.plan.comments.entity.Comment;
import com.example.plan.plans.PlanService;
import com.example.plan.plans.entity.Plan;
import com.example.plan.replies.dto.DeleteReplyRequest;
import com.example.plan.replies.dto.GetReplyResponse;
import com.example.plan.replies.dto.JustACommentResponse;
import com.example.plan.replies.dto.PostReplyRequest;
import com.example.plan.replies.dto.PostReplyResponse;
import com.example.plan.replies.dto.SimpleReplyResponse;
import com.example.plan.replies.dto.UpdateReplyRequest;
import com.example.plan.replies.dto.UpdateReplyResponse;
import com.example.plan.replies.entity.Reply;
import com.example.plan.replies.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {
	private final ReplyRepository replyRepository;
	private final PlanService planService;
	private final CommentService commentService;

	public PostReplyResponse postReply(PostReplyRequest request, Long planId, Long commentId) {
		Plan plan = planService.findPlan(planId);
		Comment comment = commentService.findComment(commentId);
		Reply reply = new Reply(request, plan, comment);
		Reply saved = replyRepository.save(reply);
		return new PostReplyResponse(saved);
	}

	public void deleteReply(DeleteReplyRequest request, Long replyId) {
		Reply reply = replyRepository.findReplyById(replyId);
		if (!reply.getPassword().equals(request.getPassword())){throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");}
		replyRepository.delete(reply);
	}

	@Transactional
	public UpdateReplyResponse updateReply(UpdateReplyRequest request, Long replyId) {
		Reply reply = replyRepository.findReplyById(replyId);
		if (!reply.getPassword().equals(request.getPassword())){throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");}
		reply.updateContents(request.getContents());
		return new UpdateReplyResponse(reply);
	}

	public JustACommentResponse getReply(Long replyId) {
		Reply reply = replyRepository.findReplyById(replyId);
		Comment comment = reply.getComment();
		return new JustACommentResponse(comment, reply);
	}
}
