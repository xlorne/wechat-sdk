package com.codingapi.wechat.sdk.pay;

import com.wechat.pay.java.core.RSAAutoCertificateConfig;
import lombok.Getter;
import lombok.Setter;


public class WechatV3Config {

    /**
     * 商户编号
     */
    @Setter
    @Getter
    private String mchId;

    /**
     * 应用Id
     */
    @Setter
    @Getter
    private String appid;

    /**
     * 证书编号
     */
    @Setter
    @Getter
    private String mchSerialNo;

    /**
     * apiV3Key
     */
    @Setter
    @Getter
    private String apiV3Key;

    /**
     * 证书私钥
     */
    @Setter
    @Getter
    private String privateKeys;

    /**
     * 支付回调地址
     */
    @Setter
    @Getter
    private String notifyUrl;

    private RSAAutoCertificateConfig config;

    public RSAAutoCertificateConfig getWechatPayConfig(){
        synchronized (this) {
            if (config == null) {
                this.config = new RSAAutoCertificateConfig.Builder()
                        .merchantId(mchId)
                        .privateKey(privateKeys)
                        .merchantSerialNumber(mchSerialNo)
                        .apiV3Key(apiV3Key)
                        .build();
            }
        }
        return config;
    }



}
