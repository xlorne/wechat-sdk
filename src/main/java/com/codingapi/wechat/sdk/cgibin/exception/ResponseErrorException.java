package com.codingapi.wechat.sdk.cgibin.exception;

import com.codingapi.wechat.sdk.cgibin.model.BaseResponse;
import lombok.Getter;

public class ResponseErrorException extends RuntimeException {

    @Getter
    private final BaseResponse response;

    @Getter
    private final int errorCode;

    public ResponseErrorException(BaseResponse error) {
        super(String.format("code:%d,error:%s", error.getErrcode(), error.getErrmsg()));
        this.errorCode = error.getErrcode();
        this.response = error;
    }
}
