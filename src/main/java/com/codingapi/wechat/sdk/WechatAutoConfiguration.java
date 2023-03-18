package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.api.AccountManagementApi;
import com.codingapi.wechat.sdk.cgibin.api.BaseInformationApi;
import com.codingapi.wechat.sdk.cgibin.api.MessageManagementApi;
import com.codingapi.wechat.sdk.cgibin.api.UserManagementApi;
import com.codingapi.wechat.sdk.oauth2.Oauth2Client;
import com.codingapi.wechat.sdk.oauth2.api.WebAppsApi;
import com.codingapi.wechat.sdk.properties.WechatProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WechatAutoConfiguration {

    @Bean
    @ConfigurationProperties(prefix = "codingapi.wechat")
    public WechatProperty wechatProperty(){
        return new WechatProperty();
    }

    @Bean
    public CgiBinClient cgiBinClient(WechatProperty property){
        return new CgiBinClient(property.getWechatApiBaseUrl(), property.getWechatAppId(), property.getWechatAppSecret());
    }

    @Bean
    public Oauth2Client oauth2Client(WechatProperty property){
        return new Oauth2Client(property.getWechatApiBaseUrl(), property.getWechatAppId(), property.getWechatAppSecret());
    }

    @Bean
    public MessageManagementApi messageManagementApi(CgiBinClient client){
        return new MessageManagementApi(client);
    }

    @Bean
    public UserManagementApi userManagementApi(CgiBinClient client){
        return new UserManagementApi(client);
    }

    @Bean
    public WebAppsApi webAppsApi(Oauth2Client oauth2Client){
        return new WebAppsApi(oauth2Client);
    }

    @Bean
    public AccountManagementApi accountManagementApi(CgiBinClient client){
        return new AccountManagementApi(client);
    }

    @Bean
    public BaseInformationApi baseInformationApi(CgiBinClient client){
        return new BaseInformationApi(client);
    }

}
