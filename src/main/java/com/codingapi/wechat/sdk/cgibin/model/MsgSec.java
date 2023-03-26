package com.codingapi.wechat.sdk.cgibin.model;

import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


public class MsgSec {


    @Setter
    @Getter
    public static class Request implements RestParam {
        private String content;

        private String openid;

        private String scene;

        private String version;
    }


    @Setter
    @Getter
    public static class Response{
        private int errcode;
        private String errmsg;
        private Result result;
        private List<Detail> detail;
        private String trace_id;
    }

    @Setter
    @Getter
    public static class Result {
        private String suggest;
        private int label;
    }

    @Setter
    @Getter
    public static class Detail {
        private String strategy;
        private int errcode;
        private String suggest;
        private int label;
        private int prob;
        private int level;
        private String keyword;
    }


}
