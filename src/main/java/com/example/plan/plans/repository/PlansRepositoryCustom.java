package com.example.plan.plans.repository;

import java.time.LocalDateTime;
import java.util.List;

import com.example.plan.plans.entity.Plans;

public interface PlansRepositoryCustom {
	Plans findPlansById(Long id);
	List<Plans> getPlansList(String writer, LocalDateTime before, LocalDateTime after);
}
