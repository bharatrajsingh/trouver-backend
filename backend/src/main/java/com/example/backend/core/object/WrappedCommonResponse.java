package com.example.backend.core.object;

import com.example.backend.enums.ResultCode;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
public class WrappedCommonResponse<T extends ICommonResponse> implements Serializable {

    // There should be no specific setters
    @Setter(AccessLevel.NONE)
    private T response;

    private ResultCode resultCode;

    private String resultMessage;

    public WrappedCommonResponse(T response, ResultCode resultCode) {
        this.response = response;
        this.resultCode = resultCode;
    }

    public WrappedCommonResponse(T response, ResultCode resultCode, String msg) {
        this.response = response;
        this.resultCode = resultCode;
        this.resultMessage = msg;
    }

}
