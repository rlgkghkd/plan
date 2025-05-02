package com.example.plan.replies.repository;

import com.example.plan.replies.entity.Reply;

public interface ReplyRepositoryCustom {
	Reply findReplyById(Long replyId);
}
