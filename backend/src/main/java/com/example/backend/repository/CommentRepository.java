package com.example.backend.repository;

import com.example.backend.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    Optional<CommentEntity> findByPollId(Long pollId);

    CommentEntity findByCommentId(Long commentId);
}
