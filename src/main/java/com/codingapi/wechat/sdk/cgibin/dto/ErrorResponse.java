package com.codingapi.wechat.sdk.cgibin.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {

    private int errcode;

    private String errmsg;

}
