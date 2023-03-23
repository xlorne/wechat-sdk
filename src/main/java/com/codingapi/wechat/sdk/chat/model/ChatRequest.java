package com.codingapi.wechat.sdk.chat.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import lombok.ToString;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

@Getter
@ToString
public class ChatRequest {

    private String formUserName;
    private String createTime;
    private String toUserName;
    private String msgType;
    private String content;
    private String msgId;
    private String mediaId;

    @SneakyThrows
    public ChatRequest(String xml) {
        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();

        this.formUserName =  root.element("FromUserName").getTextTrim();
        this.toUserName =  root.element("ToUserName").getTextTrim();
        this.createTime =  root.element("CreateTime").getTextTrim();
        this.msgType =  root.element("MsgType").getTextTrim();
        this.msgId =  root.element("MsgId").getTextTrim();
        if(this.isText()) {
            this.content = root.element("Content").getTextTrim();
        }
        if(this.isVoice()) {
            this.mediaId = root.element("MediaId").getTextTrim();
        }
    }

    public ChatRequest(String formUserName, String createTime, String toUserName, String msgType, String content, String msgId, String mediaId) {
        this.formUserName = formUserName;
        this.createTime = createTime;
        this.toUserName = toUserName;
        this.msgType = msgType;
        this.content = content;
        this.msgId = msgId;
        this.mediaId = mediaId;
    }


    public ChatRequest(String formUserName, String msgType, String content) {
        this.formUserName = formUserName;
        this.msgType = msgType;
        this.content = content;
    }

    public boolean isText(){
        return msgType.equals("text");
    }

    public boolean isVoice(){
        return msgType.equals("voice");
    }
}
