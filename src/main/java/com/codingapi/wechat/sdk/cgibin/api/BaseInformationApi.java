package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson2.JSON;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.oauth2.dto.AccessToken;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseInformationApi {

    private final CgiBinClient cgiBinClient;

    private final Map<String,AccessToken.Response> cache = new ConcurrentHashMap<>();

    public BaseInformationApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    /**
     * 获取access_token
     * <a href="https://developers.weixin.qq.com/doc/offiaccount/Basic_Information/Get_access_token.html">api<a/>
     * @param grantType 获取access_token填写client_credential
     * @return 获取Access token
     */
    public AccessToken.Response token(String grantType){
        AccessToken.Response token = cache.get(grantType);
        if(token==null) {
            token = getToken(grantType);
            cache.put(grantType,token);
        }
        if(token.isSuccess()&&token.isExpire()){
            token = getToken(grantType);
            cache.put(grantType,token);
        }
        return token;
    }

    private AccessToken.Response getToken(String grantType){
        String appid = cgiBinClient.getAppId();
        String secret = cgiBinClient.getAppSecret();
        String url = "/cgi-bin/token?grant_type=" + grantType + "&appid=" + appid + "&secret=" + secret;
        String response = cgiBinClient.get(url);
        return JSON.parseObject(response, AccessToken.Response.class);
    }


    public AccessToken.Response token(){
       return token("client_credential");
    }

}
