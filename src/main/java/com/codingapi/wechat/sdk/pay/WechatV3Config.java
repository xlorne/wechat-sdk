package com.codingapi.wechat.sdk.pay;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class WechatV3Config {

    /**
     * 商户编号
     */
    private String mchId;

    /**
     * 应用Id
     */
    private String appid;

    /**
     * 证书编号
     */
    private String mchSerialNo;

    /**
     * apiV3Key
     */
    private String apiV3Key;

    /**
     * 证书私钥
     */
    private String privateKeys;

    /**
     * 支付回调地址
     */
    private String notifyUrl;

}
