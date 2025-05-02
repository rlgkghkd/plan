package com.example.plan.replies.repository;

import com.example.plan.replies.entity.QReply;
import com.example.plan.replies.entity.Reply;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ReplyRepositoryImpl implements ReplyRepositoryCustom{
	private final JPAQueryFactory queryFactory;

	@Override
	public Reply findReplyById(Long replyId) {
		return queryFactory.selectFrom(QReply.reply)
			.where(QReply.reply.id.eq(replyId))
			.fetchFirst();
	}
}
