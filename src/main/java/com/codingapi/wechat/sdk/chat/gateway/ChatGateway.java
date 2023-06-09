package com.codingapi.wechat.sdk.chat.gateway;

import com.codingapi.wechat.sdk.chat.model.ChatRequest;
import com.codingapi.wechat.sdk.chat.model.ChatResponse;

public interface ChatGateway {

    default ChatResponse ask(String openid, ChatRequest chatRequest){
        return null;
    };

    default void handler(String openid, ChatRequest chatRequest){};

}
