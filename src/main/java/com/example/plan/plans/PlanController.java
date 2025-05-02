package com.example.plan.plans;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.plan.plans.dto.PostPlanRequest;
import com.example.plan.plans.dto.PostPlanResponse;
import com.example.plan.plans.dto.DeletePlanRequest;
import com.example.plan.plans.dto.GetPlanListResponse;
import com.example.plan.plans.dto.GetPlanResponse;
import com.example.plan.plans.dto.UpdatePlanRequest;
import com.example.plan.plans.dto.UpdatePlanResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/plan")
public class PlanController {
	private final PlanService planService;

	@PostMapping
	public ResponseEntity<PostPlanResponse> postPlan(@RequestBody PostPlanRequest request){
		return ResponseEntity.created(URI.create("/api/plan/created")).body(planService.postPlan(request));
	}

	@DeleteMapping("/{planId}")
	public ResponseEntity<String> deletePlan(@RequestBody DeletePlanRequest request, @PathVariable Long planId){
		planService.deletePlan(request, planId);
		return ResponseEntity.ok().body("삭제 되었습니다.");
	}

	@PatchMapping("/{planId}")
	public ResponseEntity<UpdatePlanResponse> updatePlan(@RequestBody UpdatePlanRequest request, @PathVariable Long planId){
		return ResponseEntity.ok().body(planService.updatePlan(request, planId));
	}

	@GetMapping
	public ResponseEntity<List<GetPlanListResponse>> getPlanPage(
		@RequestParam(name = "index", defaultValue = "1", required = false) int index,
		@RequestParam(name = "writer", required = false) String writer,
		@RequestParam(name = "before", required = false) String before,
		@RequestParam(name = "after", required = false) String after) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime afterDate = after==null || after.isEmpty()?null:formatter.parse(after, LocalDateTime::from);
		LocalDateTime beforeDate = before==null || before.isEmpty()?null:formatter.parse(before, LocalDateTime::from);
		return ResponseEntity.ok().body(planService.getPlanList(index, writer, afterDate, beforeDate));
	}

	@GetMapping("/{planId}")
	public ResponseEntity<GetPlanResponse> getPlan(@PathVariable Long planId){
		return ResponseEntity.ok().body(planService.getPlan(planId));
	}
}
