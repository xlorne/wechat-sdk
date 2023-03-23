package com.codingapi.wechat.sdk.cgibin.dto.customservice;

import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MsgSend implements RestParam {

    private String touser;
    private String msgtype;

    private Text text;

    public MsgSend(String touser,String content) {
        this.msgtype = "text";
        this.touser = touser;
        this.text = new Text();
        this.text.setContent(content);
    }

    @Setter
    @Getter
    private static class Text{
        private String content;
    }
}
