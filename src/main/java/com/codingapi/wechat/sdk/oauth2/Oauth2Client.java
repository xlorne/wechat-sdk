package com.codingapi.wechat.sdk.oauth2;

import com.codingapi.springboot.framework.rest.RestClient;
import com.codingapi.springboot.framework.rest.param.RestParamBuilder;
import lombok.Getter;
import lombok.Setter;

public class Oauth2Client {

    private final RestClient restClient;
    @Getter
    private final String appId;
    @Getter
    private final String appSecret;

    @Setter
    @Getter
    private String accessToken;

    /**
     * <a href="https://developers.weixin.qq.com/doc/offiaccount/OA_Web_Apps/Wechat_webpage_authorization.html"></a>
     * 第二步：通过 code 换取网页授权access_token
     * @param baseUrl https://api.weixin.qq.com
     * @param appId appId
     * @param appSecret appSecret
     */
    public Oauth2Client(String baseUrl, String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
        this.restClient = new RestClient(baseUrl);
    }


    public String get(String api, RestParamBuilder builder) {
        return restClient.get(api,builder);
    }


    public String authGet(String api,RestParamBuilder builder){
        api = buildAuthApi(api);
        return get(api,builder);
    }


    private String buildAuthApi(String api){
        if(api.contains("?")){
            return api+"&access_token="+accessToken;
        }else{
            return api+"?access_token="+accessToken;
        }
    }




}
