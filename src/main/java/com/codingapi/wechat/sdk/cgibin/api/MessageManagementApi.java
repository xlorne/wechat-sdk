package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.dto.message.TemplateSend;

public class MessageManagementApi {

    private final CgiBinClient cgiBinClient;

    public MessageManagementApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    /**
     * 发送模板消息
     * @param request {@link TemplateSend.Request}
     * @return {@link TemplateSend.Response}
     */
    public TemplateSend.Response send(TemplateSend.Request request){
        if(request!=null){
            request.setAppId(cgiBinClient.getAppId());
        }
        String json = cgiBinClient.authPost("/cgi-bin/message/template/send",
                (JSONObject)JSONObject.toJSON(request));
        return JSON.parseObject(json,TemplateSend.Response.class);
    }


}
