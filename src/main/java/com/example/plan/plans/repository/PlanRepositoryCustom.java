package com.example.plan.plans.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.plan.plans.entity.Plan;

public interface PlanRepositoryCustom {
	Plan findPlanById(Long id);
	List<Plan> getPlanList(String writerId, LocalDateTime before, LocalDateTime after);
}
