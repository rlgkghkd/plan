package com.example.plan.plans;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.plan.plans.dto.CreatePlansRequest;
import com.example.plan.plans.dto.CreatePlansResponse;
import com.example.plan.plans.dto.DeletePlansRequest;
import com.example.plan.plans.dto.GetPlansListResponse;
import com.example.plan.plans.dto.GetPlansResponse;
import com.example.plan.plans.dto.UpdatePlansRequest;
import com.example.plan.plans.dto.UpdatePlansResponse;
import com.example.plan.plans.entity.Plans;
import com.example.plan.plans.repository.PlansRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlansService {
	private final PlansRepository plansRepository;

	public CreatePlansResponse postPlans(CreatePlansRequest request) {
		Plans plans = new Plans(request);
		Plans savedPlans = plansRepository.save(plans);
		return new CreatePlansResponse(savedPlans);
	}

	public void deletePlans(DeletePlansRequest request, Long planId) {
		Plans plans = plansRepository.findPlansById(planId);
		if (!plans.getPassword().equals(request.getPassword())){throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");}
		plansRepository.delete(plans);
	}

	@Transactional
	public UpdatePlansResponse updatePlans(UpdatePlansRequest request, Long planId) {
		if (request.getTitle().isEmpty() && request.getContent().isEmpty()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "빈 요청입니다.");
		}
		Plans plans = plansRepository.findPlansById(planId);
		if (!request.getTitle().isEmpty()){plans.changeTitle(request.getTitle());}
		if (!request.getContent().isEmpty()){plans.chageContent(request.getContent());}
		return new UpdatePlansResponse(plans);
	}

	public List<GetPlansListResponse> getPlansList(int index, String writer, LocalDateTime before, LocalDateTime after){
		List<Plans> plansList= plansRepository.getPlansList(writer, before, after);
		int start = plansList.size() >(index-1)*10?(index-1)*10:0;
		List<GetPlansListResponse> list = plansList.stream().map(GetPlansListResponse::new).skip(start).limit(10).toList();
		return list;
	}

	public GetPlansResponse getPlans(Long planId) {
		Plans plans = plansRepository.findPlansById(planId);
		return new GetPlansResponse(plans);
	}
}
