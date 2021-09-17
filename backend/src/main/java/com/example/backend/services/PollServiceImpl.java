package com.example.backend.services;

import com.example.backend.core.object.ICommonResponse;
import com.example.backend.core.object.WrappedCommonResponse;
import com.example.backend.entity.CommentEntity;
import com.example.backend.entity.PollEntity;
import com.example.backend.enums.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.backend.models.PollRequest;
import com.example.backend.repository.PollRepository;
import com.example.backend.helper.PollHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class PollServiceImpl implements PollService {

    @Autowired
    private PollHelper pollHelper;

    @Autowired
    private PollRepository pollRepository;

    @Override
    public WrappedCommonResponse createPoll(PollRequest pollRequest) {

        PollEntity pollEntity = pollHelper.convertPollRequestToPollEntity(pollRequest);
        PollEntity pollEntityResponse = pollRepository.save(pollEntity);
        return new WrappedCommonResponse<>(pollEntityResponse, ResultCode.SUCCESS);
    }

    public PollEntity getPollById(long pollId) {
        return pollRepository.getById(pollId);
    }

    public WrappedCommonResponse getAllCommentsOnPoll(Long pollId) {
        PollEntity poll = pollRepository.findByPollId(pollId);

        if (Objects.isNull(poll)) {
            log.error("No poll exist for this pollId " + pollId);
            return new WrappedCommonResponse<>(null, ResultCode.FAIL, "No poll exist for this pollId");
        }

        List<CommentEntity> comments = pollRepository.findAllCommentsOnPoll(pollId);

        if (CollectionUtils.isEmpty(comments)) {
            log.error("There are no comments on this poll yet");
            return new WrappedCommonResponse<>(null, ResultCode.FAIL, "There are no comments on this poll yet");
        }
        return new WrappedCommonResponse((ICommonResponse) comments, ResultCode.SUCCESS);
    }
}
