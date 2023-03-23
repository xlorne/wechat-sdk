package com.codingapi.wechat.sdk.jsapi.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsSignResponse {

    private long timestamp;
    private String nonceStr;
    private String signature;
    private String appId;

}
