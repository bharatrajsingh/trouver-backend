package com.example.backend.webservices;

import com.example.backend.config.URL;
import com.example.backend.core.object.WrappedCommonResponse;
import com.example.backend.models.CommentResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.backend.models.PollRequest;
import com.example.backend.models.PollResponse;
import com.example.backend.services.PollServiceImpl;

@RestController
@RequestMapping(value = URL.BASE_URL)
public class PollController {

    @Autowired
    private PollServiceImpl pollService;

    @PostMapping(value = URL.POLL)
    ResponseEntity<PollResponse> createPoll(@RequestBody PollRequest request) {
        WrappedCommonResponse wrappedCommonResponse = pollService.createPoll(request);
        PollResponse pollResponse = new PollResponse();
        pollResponse.setICommonResponse(wrappedCommonResponse.getResponse());
        pollResponse.setResultCode(wrappedCommonResponse.getResultCode());
        return new ResponseEntity<>(pollResponse, HttpStatus.OK);
    }

    @GetMapping(value = URL.POLL + URL.COMMENTS)
    ResponseEntity<CommentResponse> getAllCommentsOnPoll(@RequestParam Long pollId) {
        WrappedCommonResponse wrappedCommonResponse = pollService.getAllCommentsOnPoll(pollId);
        CommentResponse commentResponse = new CommentResponse();
        commentResponse.setICommentResponse(wrappedCommonResponse.getResponse());
        commentResponse.setResultCode(wrappedCommonResponse.getResultCode());
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }
}
