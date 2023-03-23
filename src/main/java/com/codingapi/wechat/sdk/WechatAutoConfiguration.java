package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.api.*;
import com.codingapi.wechat.sdk.oauth2.Oauth2Client;
import com.codingapi.wechat.sdk.oauth2.api.WebAppsApi;
import com.codingapi.wechat.sdk.pay.WechatV3Config;
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
    @ConfigurationProperties(prefix = "codingapi.pay")
    public WechatV3Config wechatV3Config(){
        return new WechatV3Config();
    }

    @Bean
    public CgiBinClient cgiBinClient(WechatProperty property){
        return new CgiBinClient(property.getApiBaseUrl(), property.getAppId(), property.getAppSecret());
    }

    @Bean
    public Oauth2Client oauth2Client(WechatProperty property){
        return new Oauth2Client(property.getApiBaseUrl(), property.getAppId(), property.getAppSecret());
    }

    @Bean
    public MessageManagementApi messageManagementApi(CgiBinClient client){
        return new MessageManagementApi(client);
    }

    @Bean
    public MediaApi mediaApi(CgiBinClient client){
        return new MediaApi(client);
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

    @Bean
    public TicketApi ticketApi(CgiBinClient client){
        return new TicketApi(client);
    }

    @Bean
    public CustomServiceApi customServiceApi(CgiBinClient client){
        return new CustomServiceApi(client);
    }

}
