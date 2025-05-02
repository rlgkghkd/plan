package com.example.plan.replies;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/plan/{planId}/comment/{commentId}/reply")
public class ReplyController {
	private final ReplyService replyService;
}
