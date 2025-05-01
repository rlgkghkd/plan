package com.example.plan.plans;

import org.springframework.stereotype.Service;

import com.example.plan.plans.dto.CreatePlanRequest;
import com.example.plan.plans.dto.CreatePlanResponse;
import com.example.plan.plans.entity.Plans;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlansService {
	private final PlansRepository plansRepository;

	public CreatePlanResponse postPlan(CreatePlanRequest request) {
		Plans plans = new Plans(request);
		Plans savedPlans = plansRepository.save(plans);
		return new CreatePlanResponse(savedPlans);
	}

	public void deletePlan(Long planId) {
		Plans plans = plansRepository.findByIdOrElseThrow(planId);
		plansRepository.delete(plans);
	}
}
