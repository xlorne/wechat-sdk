package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;

public class WxaApi {

    private final CgiBinClient cgiBinClient;

    public WxaApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    public void msgSecCheck(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("openid","oT3FC6ZQ-rJgq9jXgfHtq4WxRx-4");
        jsonObject.put("scene","4");
        jsonObject.put("version","2");
        jsonObject.put("content","你好");
        String json = cgiBinClient.authPost("/wxa/msg_sec_check", jsonObject);
        System.out.println(json);
    }


}
