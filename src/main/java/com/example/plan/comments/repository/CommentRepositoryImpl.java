package com.example.plan.comments.repository;

import com.example.plan.comments.entity.Comment;
import com.example.plan.comments.entity.QComment;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CommentRepositoryImpl implements CommentRepositoryCustom{
	private final JPAQueryFactory queryFactory;

	@Override
	public Comment findCommentById(Long commentId) {
		return queryFactory.selectFrom(QComment.comment)
			.where(QComment.comment.id.eq(commentId))
			.fetchFirst();
	}
}
