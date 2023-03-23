package com.codingapi.wechat.sdk.cgibin.dto.customservice;

import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;


public class MsgSend  {

    @Setter
    @Getter
    public static class Request implements RestParam{
        private String touser;
        private String msgtype;

        private Text text;

        public Request(String touser,String content) {
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

    @Setter
    @Getter
    public static class Response{
        private int errcode;
        private String errmsg;

        public boolean isSuccess(){
            return errcode==0 && "ok".equalsIgnoreCase(errmsg);
        }
    }
}
