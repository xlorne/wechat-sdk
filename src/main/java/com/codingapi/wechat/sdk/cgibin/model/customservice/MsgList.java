package com.codingapi.wechat.sdk.cgibin.model.customservice;

import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

public class MsgList {

    @Setter
    @Getter
    public static class Request implements RestParam {

        private Long starttime;
        private Long endtime;
        private Long msgid;
        private Integer number;
    }

    @Setter
    @Getter
    @ToString
    public static class Response{
        private int number;
        private long msgid;
        private List<Record> recordList;
    }


    @Setter
    @Getter
    @ToString
    public static class Record{
        private String openid;
        //操作码，2002（客服发送信息），2003（客服接收消息）
        private int opercode;
        private String text;
        private long time;
        private String worker;

        public boolean isSendMsg(){
            return opercode == 2003;
        }

        public boolean isReplyMsg(){
            return opercode == 2002;
        }
    }
}
