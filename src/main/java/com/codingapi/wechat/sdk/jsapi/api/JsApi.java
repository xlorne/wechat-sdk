package com.codingapi.wechat.sdk.jsapi.api;

import com.codingapi.wechat.sdk.cgibin.api.TicketApi;
import com.codingapi.wechat.sdk.cgibin.model.ticket.Ticket;
import com.codingapi.wechat.sdk.jsapi.model.JsSignResponse;
import com.codingapi.wechat.sdk.properties.WechatProperty;
import com.codingapi.wechat.sdk.utils.RandomUtils;
import com.wechat.pay.java.core.util.ShaUtil;
import lombok.AllArgsConstructor;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;

@AllArgsConstructor
public class JsApi {

    private final TicketApi ticketApi;

    private final WechatProperty wechatProperty;

    /**
     * 微信JS-SDK config认证
     * @param base64Url base64加密的url地址
     * @return 认证返回的参数信息
     */
    public JsSignResponse jsSign(String base64Url){
        Ticket ticket =  ticketApi.getTicket();
        String nonceStr = RandomUtils.getRandomStr();
        String jsapiTicket = ticket.getTicket();
        long timestamp = System.currentTimeMillis()/1000;
        String url = new String(Base64Utils.decodeFromString(base64Url));
        String content = "jsapi_ticket="+jsapiTicket+"&noncestr="+nonceStr+"&timestamp="+timestamp+"&url="+url;
        String signature = ShaUtil.getSha1HexString(content.getBytes(StandardCharsets.UTF_8));
        JsSignResponse response = new JsSignResponse();
        response.setSignature(signature);
        response.setTimestamp(timestamp);
        response.setAppId(wechatProperty.getAppId());
        response.setNonceStr(nonceStr);
        return response;
    }
}
