package com.example.backend.webservices;

import com.example.backend.config.URL;
import com.example.backend.core.object.WrappedCommonResponse;
import com.example.backend.models.CommentRequest;
import com.example.backend.models.CommentResponse;
import com.example.backend.services.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class CommentController {

    @RestController
    @RequestMapping(value = URL.BASE_URL)
    public class PollController {

        @Autowired
        private CommentServiceImpl commentService;

        @PostMapping(value = URL.COMMENT)
        ResponseEntity<CommentResponse> addComment(@RequestBody CommentRequest request) {
            WrappedCommonResponse wrappedCommonResponse = commentService.addComment(request);
            CommentResponse commentResponse = new CommentResponse();
            commentResponse.setICommentResponse(wrappedCommonResponse.getResponse());
            commentResponse.setResultCode(wrappedCommonResponse.getResultCode());
            return new ResponseEntity<>(commentResponse, HttpStatus.OK);
        }

        @GetMapping(value = URL.COMMENT)
        ResponseEntity<CommentResponse> getCommentById(@RequestParam Long commentId) {
            WrappedCommonResponse wrappedCommonResponse = commentService.getCommentById(commentId);
            CommentResponse commentResponse = new CommentResponse();
            commentResponse.setICommentResponse(wrappedCommonResponse.getResponse());
            commentResponse.setResultCode(wrappedCommonResponse.getResultCode());
            return new ResponseEntity<>(commentResponse, HttpStatus.OK);
        }

    }

}
