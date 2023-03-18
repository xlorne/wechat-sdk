package com.codingapi.wechat.sdk.cgibin.exception;

import com.codingapi.wechat.sdk.cgibin.dto.ErrorResponse;
import lombok.Getter;

public class ResponseErrorException extends RuntimeException {

    @Getter
    private final ErrorResponse response;

    public ResponseErrorException(ErrorResponse error) {
        super(error.getErrmsg());
        this.response = error;
    }
}
