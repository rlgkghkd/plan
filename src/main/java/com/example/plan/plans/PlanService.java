package com.example.plan.plans;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.plan.plans.dto.PostPlanRequest;
import com.example.plan.plans.dto.PostPlanResponse;
import com.example.plan.plans.dto.DeletePlanRequest;
import com.example.plan.plans.dto.GetPlanListResponse;
import com.example.plan.plans.dto.GetPlanResponse;
import com.example.plan.plans.dto.UpdatePlanRequest;
import com.example.plan.plans.dto.UpdatePlanResponse;
import com.example.plan.plans.entity.Plan;
import com.example.plan.plans.repository.PlanRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlanService {
	private final PlanRepository planRepository;

	public PostPlanResponse postPlan(PostPlanRequest request) {
		Plan plan = new Plan(request);
		Plan savedPlan = planRepository.save(plan);
		return new PostPlanResponse(savedPlan);
	}

	public void deletePlan(DeletePlanRequest request, Long planId) {
		Plan plan = planRepository.findPlanById(planId);
		if (!plan.getPassword().equals(request.getPassword())){throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");}
		planRepository.delete(plan);
	}

	@Transactional
	public UpdatePlanResponse updatePlan(UpdatePlanRequest request, Long planId) {
		if (request.getTitle().isEmpty() && request.getContent().isEmpty()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "빈 요청입니다.");
		}
		Plan plan = planRepository.findPlanById(planId);
		if (!plan.getPassword().equals(request.getPassword())){throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");}
		if (!request.getTitle().isEmpty()){
			plan.changeTitle(request.getTitle());}
		if (!request.getContent().isEmpty()){
			plan.chageContent(request.getContent());}
		return new UpdatePlanResponse(plan);
	}

	public List<GetPlanListResponse> getPlanList(int index, String writerId, LocalDateTime before, LocalDateTime after){
		List<Plan> planList = planRepository.getPlanList(writerId, before, after);
		int start = planList.size() >(index-1)*10?(index-1)*10:0;
		List<GetPlanListResponse> list = planList.stream().peek(Plan::updateCount).map(GetPlanListResponse::new).skip(start).limit(10).toList();
		return list;
	}

	public GetPlanResponse getPlan(Long planId) {
		Plan plan = planRepository.findPlanById(planId);
		plan.updateCount();
		return new GetPlanResponse(plan);
	}

	//다른 서비스들이 접근
	public Plan findPlan(Long planId){
		return planRepository.findPlanById(planId);
	}
}
