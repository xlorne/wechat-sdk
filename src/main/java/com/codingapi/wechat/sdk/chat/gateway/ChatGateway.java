package com.codingapi.wechat.sdk.chat.gateway;

import com.codingapi.wechat.sdk.chat.model.ChatRequest;

public interface ChatGateway {

    String ask(String openid, ChatRequest chatRequest);

}
