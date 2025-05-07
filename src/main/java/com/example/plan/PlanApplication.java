package com.example.plan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.plan.comments.entity.Comment;
import com.example.plan.comments.repository.CommentRepository;
import com.example.plan.plans.entity.Plan;
import com.example.plan.plans.repository.PlanRepository;

@EnableJpaAuditing
@SpringBootApplication
public class PlanApplication {

	public static void main(String[] args) {

		var context = SpringApplication.run(PlanApplication.class, args);
		var repository = context.getBean(PlanRepository.class);
		var commentRepo = context.getBean(CommentRepository.class);
		Plan plan = Plan.builder()
			.content("testContent1")
			.title("testTitle1")
			.password("testPassword")
			.writerId("tester1")
			.build();
		repository.save(plan);
		Comment comment = Comment.builder()
			.contents("testComment")
			.password("testPassword")
			.plan(plan)
			.writerId("testWriter")
			.build();
		commentRepo.save(comment);
		System.out.println("result = " + repository.findPlanById(1L).getTitle());
		System.out.println("result = " + repository.getPlanList(null, null, null).get(0).getTitle());
	}
}
