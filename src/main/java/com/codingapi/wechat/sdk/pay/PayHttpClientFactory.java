package com.codingapi.wechat.sdk.pay;

import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
import com.wechat.pay.contrib.apache.httpclient.auth.Verifier;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
import com.wechat.pay.contrib.apache.httpclient.cert.CertificatesManager;
import com.wechat.pay.contrib.apache.httpclient.exception.HttpCodeException;
import com.wechat.pay.contrib.apache.httpclient.exception.NotFoundException;
import com.wechat.pay.java.core.util.PemUtil;
import org.apache.http.impl.client.CloseableHttpClient;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.PrivateKey;

public class PayHttpClientFactory {

    public static CloseableHttpClient createClient(WechatV3Config config) throws GeneralSecurityException,
            IOException, HttpCodeException, NotFoundException {

        PrivateKey merchantPrivateKey = PemUtil
                .loadPrivateKeyFromString(config.getPrivateKeys());

        CertificatesManager certificatesManager = CertificatesManager.getInstance();
        certificatesManager.putMerchant(config.getMchId(),
                new WechatPay2Credentials(config.getMchId(),
                        new PrivateKeySigner(config.getMchSerialNo(),
                                merchantPrivateKey)),
                config.getApiV3Key().getBytes(StandardCharsets.UTF_8));

        Verifier verifier = certificatesManager.getVerifier(config.getMchId());

        // 初始化httpClient
        return WechatPayHttpClientBuilder.create()
                .withMerchant(config.getMchId(), config.getMchSerialNo(), merchantPrivateKey)
                .withValidator(new WechatPay2Validator(verifier)).build();
    }

}
