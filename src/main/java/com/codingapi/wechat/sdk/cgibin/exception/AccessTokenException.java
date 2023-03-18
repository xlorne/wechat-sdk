package com.codingapi.wechat.sdk.cgibin.exception;

public class AccessTokenException extends RuntimeException{

    public AccessTokenException(String appId) {
        super("cgi-bin get accessToken error: appId="+appId);
    }
}
