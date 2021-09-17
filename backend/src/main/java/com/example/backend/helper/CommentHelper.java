package com.example.backend.helper;

import com.example.backend.entity.CommentEntity;
import com.example.backend.entity.PollEntity;
import com.example.backend.entity.User;
import com.example.backend.models.CommentRequest;
import com.example.backend.services.PollServiceImpl;
import com.example.backend.services.UserServiceImpl;

import javax.ws.rs.InternalServerErrorException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

@Slf4j
@Component
public class CommentHelper {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private PollServiceImpl pollServiceImpl;

    public CommentEntity convertCommentRequestToCommentEntity(CommentRequest commentRequest) {
        User user = userServiceImpl.getUserById(commentRequest.getUserId());
        if (Objects.isNull(user)) {
            log.error("No user found for given UserId");
            throw new InternalServerErrorException("No user found for given UserId");
        }

        PollEntity pollEntity = pollServiceImpl.getPollById(commentRequest.getPollId());
        if (Objects.isNull(pollEntity)) {
            log.error("No Poll found for given PollId");
            throw new InternalServerErrorException("No Poll found for given PollId");
        }

        CommentEntity commentEntity = new CommentEntity();
        commentEntity.setComment(commentEntity.getComment());
        commentEntity.setCreatedAt(Timestamp.from(Instant.now()));
        commentEntity.setUser(user);
        commentEntity.setPoll(pollEntity);
        commentEntity.setModifiedAt(null);
        return commentEntity;
    }

}
