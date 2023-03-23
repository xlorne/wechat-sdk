package com.codingapi.wechat.sdk.chat.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ChatResponse {

    private String formUserName;
    private String createTime;
    private String toUserName;
    private String msgType;
    private String content;
    private String funcFlag;


    public String toXml() {
        return "<xml>\n" +
                "<ToUserName>"+toUserName+"</ToUserName>\n" +
                "<FromUserName>"+formUserName+"</FromUserName>\n" +
                "<CreateTime>"+createTime+"</CreateTime>\n" +
                "<MsgType>"+msgType+"</MsgType>\n" +
                "<Content>"+content+"</Content>\n" +
                "<FuncFlag>"+funcFlag+"</FuncFlag>\n" +
                "</xml>";
    }


    public static ChatResponse answer(ChatRequest chatRequest,String answer){
        ChatResponse response = new ChatResponse();
        response.setToUserName(chatRequest.getFormUserName());
        response.setFormUserName(chatRequest.getToUserName());
        response.setCreateTime(chatRequest.getCreateTime());
        response.setMsgType("text");
        response.setContent(answer);
        response.setFuncFlag("0");
        return response;
    }

}
