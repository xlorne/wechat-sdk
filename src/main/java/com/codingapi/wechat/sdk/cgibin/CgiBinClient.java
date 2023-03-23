package com.codingapi.wechat.sdk.cgibin;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.codingapi.springboot.framework.rest.RestClient;
import com.codingapi.springboot.framework.rest.param.RestParamBuilder;
import com.codingapi.wechat.sdk.cgibin.api.BaseInformationApi;
import com.codingapi.wechat.sdk.cgibin.dto.ErrorResponse;
import com.codingapi.wechat.sdk.cgibin.exception.ResponseErrorException;
import com.codingapi.wechat.sdk.oauth2.dto.AccessToken;
import com.codingapi.wechat.sdk.oauth2.exception.AccessTokenException;
import lombok.Getter;

public class CgiBinClient {

    private final RestClient restClient;

    @Getter
    private String accessToken;


    private long tokenExpireTimestamp;

    @Getter
    private final String appId;

    @Getter
    private final String appSecret;

    public CgiBinClient(String baseUrl, String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;

        this.restClient = new RestClient(baseUrl);
        this.initToken();
    }


    private void initToken(){
        long now  = System.currentTimeMillis();
        BaseInformationApi baseInformationApi = new BaseInformationApi(this);
        AccessToken.Response response =  baseInformationApi.token();
        if(response.isSuccess()){
            this.accessToken = response.getAccessToken();
            this.tokenExpireTimestamp = now + (response.getExpiresIn() - 10)* 1000L;
        }else{
            throw new AccessTokenException(appId);
        }
    }


    public String get(String api){
        return get(api,null);
    }


    public String get(String api, RestParamBuilder builder){
        String response =  restClient.get(api,builder);
        handlerError(response);
        return response;
    }


    public String post(String api, RestParamBuilder builder){
        String response =  restClient.post(api,builder);
        handlerError(response);
        return response;
    }

    public String post(String api, JSONObject requestBody){
        String response =  restClient.post(api,requestBody);
        handlerError(response);
        return response;
    }


    public String authPost(String api,RestParamBuilder builder){
        api = buildAuthApi(api);
        return post(api,builder);
    }


    public String authPost(String api, JSONObject requestBody){
        api = buildAuthApi(api);
        return post(api,requestBody);
    }


    private void handlerError(String response){
        if(response.contains("\"errcode\"")){
            System.out.println(response);
            ErrorResponse error = JSON.parseObject(response, ErrorResponse.class);
            if(error.getErrcode()!=0){
                throw new ResponseErrorException(error);
            }
        }
    }

    public String authGet(String api,RestParamBuilder builder){
        api = buildAuthApi(api);
        return get(api,builder);
    }


    private String buildAuthApi(String api){
        long now = System.currentTimeMillis();
        if(now>=tokenExpireTimestamp){
            this.initToken();
        }
        if(api.contains("?")){
           return api+"&access_token="+accessToken;
        }else{
           return api+"?access_token="+accessToken;
        }
    }

}
