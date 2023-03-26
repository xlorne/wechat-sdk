package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson.JSON;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.model.MsgSec;

public class WxaApi {

    private final CgiBinClient cgiBinClient;

    public WxaApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    public MsgSec.Response msgSecCheck(MsgSec.Request request){
        String json = cgiBinClient.authPost("/wxa/msg_sec_check", request.getParameters());
        return JSON.parseObject(json, MsgSec.Response.class);
    }


}
