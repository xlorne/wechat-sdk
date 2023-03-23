package com.codingapi.wechat.sdk.chat.service;

import com.codingapi.wechat.sdk.chat.WXBizMsgCrypt;
import com.codingapi.wechat.sdk.chat.gateway.ChatGateway;
import com.codingapi.wechat.sdk.chat.model.ChatRequest;
import com.codingapi.wechat.sdk.chat.model.ChatResponse;
import com.codingapi.wechat.sdk.chat.utils.SHA1;
import com.codingapi.wechat.sdk.exception.AesException;
import com.codingapi.wechat.sdk.properties.WechatProperty;
import com.codingapi.wechat.sdk.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

@Slf4j
public class ChatService {

    private final ChatGateway chatGateway;
    private final WXBizMsgCrypt msgCrypt;
    private final WechatProperty wechatProperty;

    public ChatService(ChatGateway chatGateway, WechatProperty wechatProperty) throws AesException {
        this.chatGateway = chatGateway;
        this.msgCrypt = new WXBizMsgCrypt(wechatProperty.getToken(), wechatProperty.getEncodingAesKey(), wechatProperty.getAppId());
        this.wechatProperty = wechatProperty;
    }


    /**
     * 签名验证
     * @param request request请求对象
     * @return 签名结果
     * @throws Exception 异常信息
     */
    public String sign(HttpServletRequest request) throws Exception {
        String signature = request.getParameter("signature");
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");
        String echostr = request.getParameter("echostr");
        String msgSignature = SHA1.getSHA1(wechatProperty.getToken(), timestamp, nonce);
        if(signature.equals(msgSignature)){
            return echostr;
        }
        return "error";
    }


    /**
     * 响应回答
     * @param request request请求对象
     * @return 响应结果
     * @throws Exception 异常信息
     */
    public String answer(HttpServletRequest request) throws Exception {
        String body = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        String msg_signature = request.getParameter("msg_signature");
        String timestamp = request.getParameter("timestamp");
        String openid = request.getParameter("openid");
        String nonce = request.getParameter("nonce");
        String data = msgCrypt.decryptMsg(msg_signature,timestamp,nonce,body);
        ChatRequest chatRequest = new ChatRequest(data);
        log.info("request:{}",chatRequest);
        ChatResponse chatResponse = chatGateway.ask(openid,chatRequest);
        String xml = encodeResponse(chatResponse);
        log.info("response:{}",xml);
        return xml;
    }


    private String encodeResponse(ChatResponse chatResponse) throws AesException {
        String r_nonce = RandomUtils.getRandomStr();
        String r_timestamp =  Long.toString(System.currentTimeMillis());
        return msgCrypt.encryptMsg(chatResponse.toXml(), r_timestamp,r_nonce);
    }

}
