package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson.JSON;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.dto.BaseResponse;
import com.codingapi.wechat.sdk.cgibin.dto.customservice.MsgList;
import com.codingapi.wechat.sdk.cgibin.dto.customservice.MsgSend;
import com.codingapi.wechat.sdk.cgibin.dto.customservice.TypingSend;

public class CustomServiceApi {

    private final CgiBinClient cgiBinClient;

    public CustomServiceApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    public  MsgList.Response getMsgList(MsgList.Request request){
        String json = cgiBinClient.authPost("/customservice/msgrecord/getmsglist", request.getParameters());
        return JSON.parseObject(json, MsgList.Response.class);
    }

    public BaseResponse sendMsg(MsgSend request){
        String json = cgiBinClient.authPost("/cgi-bin/message/custom/send", request.getParameters());
        return JSON.parseObject(json, BaseResponse.class);
    }

    public BaseResponse typing(TypingSend request){
        String json = cgiBinClient.authPost("/cgi-bin/message/custom/typing", request.getParameters());
        return JSON.parseObject(json, BaseResponse.class);
    }
}
