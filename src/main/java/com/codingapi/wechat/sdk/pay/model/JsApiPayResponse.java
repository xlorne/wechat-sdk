package com.codingapi.wechat.sdk.pay.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class JsApiPayResponse {


    private String appId;
    private long timestamp;
    private String nonceStr;
    private String packageStr;
    private String signType;
    private String paySign;

}
