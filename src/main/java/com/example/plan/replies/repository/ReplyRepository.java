package com.example.plan.replies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.plan.replies.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>, ReplyRepositoryCustom {
}
