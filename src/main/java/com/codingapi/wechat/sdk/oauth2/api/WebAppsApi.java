package com.codingapi.wechat.sdk.oauth2.api;

import com.alibaba.fastjson.JSON;
import com.codingapi.springboot.framework.rest.param.RestParamBuilder;
import com.codingapi.wechat.sdk.oauth2.Oauth2Client;
import com.codingapi.wechat.sdk.oauth2.model.AccessToken;
import com.codingapi.wechat.sdk.oauth2.model.UserInfo;

public class WebAppsApi {

    private final Oauth2Client oauth2Client;

    public WebAppsApi(Oauth2Client oauth2Client) {
        this.oauth2Client = oauth2Client;
    }

    /**
     * 通过 code 换取网页授权access_token
     * @param code 填写第一步获取的 code 参数
     * @return {@link AccessToken.Response}
     */
    public AccessToken.Response getAccessToken(String code){
        AccessToken.Request request = new AccessToken.Request();
        request.setCode(code);
        request.setSecret(oauth2Client.getAppSecret());
        request.setAppid(oauth2Client.getAppId());
        request.setGrant_type("authorization_code");
        String json = oauth2Client.get("/sns/oauth2/access_token",request.getParameters());
        return JSON.parseObject(json,AccessToken.Response.class);
    }


    /**
     * 拉取用户信息
     * @param openId  用户的唯一标识
     * @return  {@link UserInfo}
     */
    public UserInfo getUserInfo(String accessToken,String openId){
        RestParamBuilder builder = RestParamBuilder.create();
        builder.add("openid",openId);
        builder.add("lang","zh_CN");
        builder.add("access_token",accessToken);
        String json = oauth2Client.get("/sns/userinfo",builder);
        return JSON.parseObject(json,UserInfo.class);
    }


}
