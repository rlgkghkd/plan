package com.example.plan.plans.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.plan.plans.entity.Plan;
import com.example.plan.plans.entity.QPlan;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PlanRepositoryImpl implements PlanRepositoryCustom {
	private final JPAQueryFactory queryFactory;

	@Override
	public Plan findPlanById(Long id) {
		return queryFactory.selectFrom(QPlan.plan)
			.where(QPlan.plan.Id.eq(id))
			.fetchOne();
	}

	@Override
	public List<Plan> getPlanList(String writer, LocalDateTime before, LocalDateTime after) {
		return queryFactory.selectFrom(QPlan.plan)
			.where(
				before != null ? QPlan.plan.createdAt.before(before) : null,
				after != null ? QPlan.plan.createdAt.after(after) : null,
				writer != null ? QPlan.plan.writerId.like(writer) : null
			)
			.fetch();
	}
}
