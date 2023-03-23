package com.codingapi.wechat.sdk.cgibin.dto.customservice;

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
        private int opercode;
        private String text;
        private long time;
        private String worker;
    }
}
