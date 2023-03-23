package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson.JSON;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.dto.customservice.MsgList;
import com.codingapi.wechat.sdk.cgibin.dto.customservice.MsgSend;

public class CustomServiceApi {

    private final CgiBinClient cgiBinClient;

    public CustomServiceApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    public  MsgList.Response getMsgList(MsgList.Request request){
        String json = cgiBinClient.authPost("/customservice/msgrecord/getmsglist", request.getParameters());
        return JSON.parseObject(json, MsgList.Response.class);
    }

    public MsgSend.Response sendMsg(MsgSend.Request request){
        String json = cgiBinClient.authPost("/cgi-bin/message/custom/send", request.getParameters());
        return JSON.parseObject(json, MsgSend.Response.class);
    }
}
