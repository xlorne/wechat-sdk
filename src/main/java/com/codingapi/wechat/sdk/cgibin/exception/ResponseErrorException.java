package com.codingapi.wechat.sdk.cgibin.exception;

import com.codingapi.wechat.sdk.cgibin.dto.BaseResponse;
import lombok.Getter;

public class ResponseErrorException extends RuntimeException {

    @Getter
    private final BaseResponse response;

    public ResponseErrorException(BaseResponse error) {
        super(error.getErrmsg());
        this.response = error;
    }
}
