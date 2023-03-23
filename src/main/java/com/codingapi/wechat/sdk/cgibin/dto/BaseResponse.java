package com.codingapi.wechat.sdk.cgibin.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BaseResponse {

    private int errcode;

    private String errmsg;


    public boolean isSuccess(){
        return errcode==0 && "ok".equalsIgnoreCase(errmsg);
    }

}
