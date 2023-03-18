package com.codingapi.wechat.sdk.properties;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WechatProperty {

    private String apiBaseUrl = "https://api.weixin.qq.com";
    /**
     * 公众号下的appId
     */
    private String appId;
    /**
     * 公众号下的appSecret
     */
    private String appSecret;


    /**
     * 公众平台上，开发者设置的token
     */
    private String token;
    /**
     * 公众平台上，开发者设置的EncodingAESKey
     */
    private String encodingAesKey;


}
