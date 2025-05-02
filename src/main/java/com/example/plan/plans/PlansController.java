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

import com.example.plan.plans.dto.CreatePlansRequest;
import com.example.plan.plans.dto.CreatePlansResponse;
import com.example.plan.plans.dto.DeletePlansRequest;
import com.example.plan.plans.dto.GetPlansListResponse;
import com.example.plan.plans.dto.GetPlansResponse;
import com.example.plan.plans.dto.UpdatePlansRequest;
import com.example.plan.plans.dto.UpdatePlansResponse;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/plan")
public class PlansController {
	private final PlansService plansService;

	@PostMapping
	public ResponseEntity<CreatePlansResponse> postPlans(@RequestBody CreatePlansRequest request){
		return ResponseEntity.created(URI.create("/api/plan/result")).body(plansService.postPlans(request));
	}

	@DeleteMapping("/{planId}")
	public ResponseEntity<String> deletePlans(@RequestBody DeletePlansRequest request, @PathVariable Long planId){
		plansService.deletePlans(request, planId);
		return ResponseEntity.ok().body("삭제 되었습니다.");
	}

	@PatchMapping("/{planId}")
	public ResponseEntity<UpdatePlansResponse> updatePlans(@RequestBody UpdatePlansRequest request, @PathVariable Long planId){
		return ResponseEntity.ok().body(plansService.updatePlans(request, planId));
	}

	@GetMapping
	public ResponseEntity<List<GetPlansListResponse>> getPlansPage(
		@RequestParam(name = "index", defaultValue = "1", required = false) int index,
		@RequestParam(name = "writer", required = false) String writer,
		@RequestParam(name = "before", required = false) String before,
		@RequestParam(name = "after", required = false) String after) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime afterDate = after==null || after.isEmpty()?null:formatter.parse(after, LocalDateTime::from);
		LocalDateTime beforeDate = before==null || before.isEmpty()?null:formatter.parse(before, LocalDateTime::from);
		return ResponseEntity.ok().body(plansService.getPlansList(index, writer, afterDate, beforeDate));
	}

	@GetMapping("/{planId}")
	public ResponseEntity<GetPlansResponse> getPlans(@PathVariable Long planId){
		return ResponseEntity.ok().body(plansService.getPlans(planId));
	}
}
