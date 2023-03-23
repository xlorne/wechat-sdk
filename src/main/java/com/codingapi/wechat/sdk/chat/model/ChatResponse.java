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

}
