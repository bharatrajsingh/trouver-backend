package com.example.backend.repository;

import com.example.backend.entity.CommentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.PollEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface PollRepository extends JpaRepository<PollEntity, Long> {

    PollEntity findByPollId(Long pollId);

    @Query("select p.comments from PollEntity p where p.pollId = :pollId")
    List<CommentEntity> findAllCommentsOnPoll(Long pollId);

}
