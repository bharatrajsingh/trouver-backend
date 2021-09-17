package com.example.backend.models;

import com.example.backend.entity.CommentEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class CommentRequest {

    @Valid
    private CommentEntity comment;

    @Valid
    private long pollId;

    @Valid
    private long userId;

    @Valid
    private Timestamp createdAt;

    @Valid
    private Timestamp modifiedAt;
}
