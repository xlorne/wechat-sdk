package com.codingapi.wechat.sdk.chat.gateway;

import com.codingapi.wechat.sdk.chat.pojo.ChatRequest;

public interface ChatGateway {

    String ask(String openid, ChatRequest chatRequest);

}
