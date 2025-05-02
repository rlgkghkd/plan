package com.example.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.plan.plans.entity.Plans;
import com.example.plan.plans.repository.PlansRepository;

@EnableJpaAuditing
@SpringBootApplication
public class PlanApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(PlanApplication.class, args);
		var repository = context.getBean(PlansRepository.class);
		Plans plans = Plans.builder()
			.content("testContent1")
			.title("testTitle1")
			.password("testPassword1")
			.writerId("testId1")
			.build();
		repository.save(plans);
		System.out.println("result = " + repository.findPlansById(1L).getTitle());
		System.out.println("result = " + repository.getPlansList(null, null, null).get(0).getTitle());
	}

}
