package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.model.account.QrcodeCreate;

public class AccountManagementApi {

    private final CgiBinClient cgiBinClient;

    public AccountManagementApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    /**
     * 生成带参数的二维码
     * @param request {@link QrcodeCreate.Request}
     * @return  {@link QrcodeCreate.Response}
     */
    public QrcodeCreate.Response qrcodeCreate(QrcodeCreate.Request request){
        String json = cgiBinClient.authPost("/cgi-bin/qrcode/create",
                (JSONObject)JSONObject.toJSON(request));
        return JSON.parseObject(json, QrcodeCreate.Response.class);
    }


}
