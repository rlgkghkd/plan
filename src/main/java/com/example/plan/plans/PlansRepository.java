package com.example.plan.plans;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.example.plan.plans.entity.Plans;

public interface PlansRepository extends JpaRepository<Plans, Long> {
	Optional<Plans> findById(Long id);
	default Plans findByIdOrElseThrow(Long id){
		return findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
}
