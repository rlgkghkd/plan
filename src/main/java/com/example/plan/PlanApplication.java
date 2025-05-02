package com.example.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.plan.plans.entity.Plan;
import com.example.plan.plans.repository.PlanRepository;

@EnableJpaAuditing
@SpringBootApplication
public class PlanApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(PlanApplication.class, args);
		var repository = context.getBean(PlanRepository.class);
		Plan plan = Plan.builder()
			.content("testContent1")
			.title("testTitle1")
			.password("testPassword1")
			.writerId("testId1")
			.build();
		repository.save(plan);
		System.out.println("result = " + repository.findPlanById(1L).getTitle());
		System.out.println("result = " + repository.getPlanList(null, null, null).get(0).getTitle());
	}
}
