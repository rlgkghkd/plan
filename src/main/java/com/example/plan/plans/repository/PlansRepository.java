package com.example.plan.plans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.plan.plans.entity.Plans;

@Repository
public interface PlansRepository extends JpaRepository<Plans, Long>, PlansRepositoryCustom {
}
