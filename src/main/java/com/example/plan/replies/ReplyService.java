package com.example.plan.replies;

import org.springframework.stereotype.Service;

import com.example.plan.replies.repository.ReplyRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyService {
	private final ReplyRepository replyRepository;
}
