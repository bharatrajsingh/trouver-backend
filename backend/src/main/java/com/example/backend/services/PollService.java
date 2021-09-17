package com.example.backend.services;

import com.example.backend.core.object.WrappedCommonResponse;
import com.example.backend.entity.PollEntity;
import com.example.backend.models.PollRequest;

public interface PollService {
    WrappedCommonResponse createPoll(PollRequest pollRequest);

    PollEntity getPollById(long id);

    WrappedCommonResponse getAllCommentsOnPoll(Long pollId);
}
