package com.example.backend.services;

import com.example.backend.core.object.WrappedCommonResponse;
import com.example.backend.models.CommentRequest;

public interface CommentService {

    WrappedCommonResponse addComment(CommentRequest request);

    WrappedCommonResponse getCommentById(Long commentId);


}
