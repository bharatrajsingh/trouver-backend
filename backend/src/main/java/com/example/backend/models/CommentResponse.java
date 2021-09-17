package com.example.backend.models;

import com.example.backend.core.object.ICommonResponse;
import com.example.backend.enums.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse {

    @Valid
    private ICommonResponse iCommentResponse;

    @Valid
    private ResultCode resultCode;
}
