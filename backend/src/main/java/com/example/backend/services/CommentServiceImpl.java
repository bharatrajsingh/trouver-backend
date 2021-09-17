package com.example.backend.services;

import com.example.backend.core.object.WrappedCommonResponse;
import com.example.backend.entity.CommentEntity;
import com.example.backend.enums.ResultCode;
import com.example.backend.helper.CommentHelper;
import com.example.backend.models.CommentRequest;
import com.example.backend.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentHelper commentHelper;

    @Autowired
    private CommentRepository commentRepository;

    public WrappedCommonResponse addComment(CommentRequest request) {

        CommentEntity commentEntity = commentHelper.convertCommentRequestToCommentEntity(request);
        CommentEntity commentEntityResponse = commentRepository.save(commentEntity);
        return new WrappedCommonResponse(commentEntityResponse, ResultCode.SUCCESS);
    }

    @Override
    public WrappedCommonResponse getCommentById(Long commentId) {
        CommentEntity commentEntity = commentRepository.findByCommentId(commentId);
        if (Objects.isNull(commentEntity)) {
            log.error("No comment found for this commentId");
            return new WrappedCommonResponse(null, ResultCode.FAIL, "No comment found for this commentId");
        }
        return new WrappedCommonResponse(commentEntity, ResultCode.SUCCESS);
    }

}
