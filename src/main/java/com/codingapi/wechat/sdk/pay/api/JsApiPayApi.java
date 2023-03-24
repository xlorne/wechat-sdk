package com.codingapi.wechat.sdk.pay.api;

import com.codingapi.wechat.sdk.pay.WechatV3Config;
import com.codingapi.wechat.sdk.pay.model.JsApiPayResponse;
import com.codingapi.wechat.sdk.utils.RandomUtils;
import com.wechat.pay.java.core.Config;
import com.wechat.pay.java.core.cipher.SignatureResult;
import com.wechat.pay.java.service.payments.jsapi.JsapiService;
import com.wechat.pay.java.service.payments.jsapi.model.Amount;
import com.wechat.pay.java.service.payments.jsapi.model.Payer;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayRequest;
import com.wechat.pay.java.service.payments.jsapi.model.PrepayResponse;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsApiPayApi {

    private final WechatV3Config wechatV3Config;

    /**
     * 发起JSAPi支付
     * @param openId 用户标识
     * @param amount 支付金额 分
     * @param desc 商品描述
     * @return 支付发起调用参数
     */
    public JsApiPayResponse createJsApiPay(String openId,int amount,String desc,String attach){
        JsapiService jsapiService = new JsapiService.Builder().config(wechatV3Config.getWechatPayConfig()).build();
        PrepayRequest prepayRequest = new PrepayRequest();
        Amount payAmount = new Amount();
        payAmount.setTotal(amount);
        prepayRequest.setAmount(payAmount);
        prepayRequest.setMchid(wechatV3Config.getMchId());
        prepayRequest.setAppid(wechatV3Config.getAppid());
        Payer payer = new Payer();
        payer.setOpenid(openId);
        prepayRequest.setAttach(attach);
        prepayRequest.setPayer(payer);
        prepayRequest.setNotifyUrl(wechatV3Config.getNotifyUrl());
        prepayRequest.setOutTradeNo(RandomUtils.getRandomStr());
        prepayRequest.setDescription(desc);

        PrepayResponse prepayResponse = jsapiService.prepay(prepayRequest);
        System.out.println(prepayResponse.getPrepayId());

        Config config = wechatV3Config.getWechatPayConfig();
        long timestamp = System.currentTimeMillis()/1000;
        String nonceStr = RandomUtils.getRandomStr(32);
        String packageStr = "prepay_id="+prepayResponse.getPrepayId();
        String data = wechatV3Config.getAppid()+"\n"+timestamp+"\n"+nonceStr+"\n"+packageStr+"\n";
        SignatureResult result = config.createSigner().sign(data);

        JsApiPayResponse response = new JsApiPayResponse();
        response.setAppId(wechatV3Config.getAppid());
        response.setPaySign(result.getSign());
        response.setTimestamp(timestamp);
        response.setNonceStr(nonceStr);
        response.setPackageStr(packageStr);
        response.setSignType("RSA");
        return response;
    }

}
