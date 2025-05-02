package com.example.plan.plans.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.plan.plans.entity.Plans;
import com.example.plan.plans.entity.QPlans;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlansRepositoryImpl implements PlansRepositoryCustom{
	private final JPAQueryFactory queryFactory;

	@Override
	public Plans findPlansById(Long id) {
		return queryFactory.selectFrom(QPlans.plans)
			.where(QPlans.plans.Id.eq(id))
			.fetchOne();
	}

	@Override
	public List<Plans> getPlansList(String writer, LocalDateTime before, LocalDateTime after) {
		return queryFactory.selectFrom(QPlans.plans)
			.where(
				before != null ? QPlans.plans.createdAt.before(before) : null,
				after != null ? QPlans.plans.createdAt.after(after) : null,
				writer != null ? QPlans.plans.writerId.like(writer) : null
			)
			.fetch();
	}
}
