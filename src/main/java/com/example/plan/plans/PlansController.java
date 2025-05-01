package com.example.plan.plans;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.plan.plans.dto.CreatePlanRequest;
import com.example.plan.plans.dto.CreatePlanResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/plan")
public class PlansController {
	private final PlansService plansService;

	@PostMapping
	public ResponseEntity<CreatePlanResponse> postPlan(@RequestBody CreatePlanRequest request){
		return ResponseEntity.created(URI.create("/api/plan/result")).body(plansService.postPlan(request));
	}

	@DeleteMapping("/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Long planId){
		return ResponseEntity.ok().body("삭제 되었습니다.");
	}

	@PatchMapping("/{planId}")
	public ResponseEntity<UpdatePlanResponse> updatePlan(@RequestBody UpdatePlanRequest request){
		return ResponseEntity.ok().body(plansService.updatePlan(request));
	}
}
