package com.codingapi.wechat.sdk.oauth2.exception;

public class AccessTokenException extends RuntimeException{

    public AccessTokenException(String code) {
        super("sns get accessToken error: code="+code);
    }

}
