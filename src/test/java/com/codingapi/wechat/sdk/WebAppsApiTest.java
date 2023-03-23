package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.oauth2.api.WebAppsApi;
import com.codingapi.wechat.sdk.oauth2.model.AccessToken;
import com.codingapi.wechat.sdk.oauth2.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class WebAppsApiTest {

    @Autowired
    private WebAppsApi webAppsApi;

    @Test
    void userInfo() {
        String code = "0612cEFa1XrSWE0GVGFa1AOgjw12cEFv";
        AccessToken.Response response = webAppsApi.getAccessToken(code);
        String openId = response.getOpenId();
        UserInfo userInfo =  webAppsApi.getUserInfo(response.getAccessToken(),openId);
        assertNotNull(userInfo);
        log.info("response:{}",userInfo);
    }



}