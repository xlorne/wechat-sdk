package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.oauth2.api.WebAppsApi;
import com.codingapi.wechat.sdk.oauth2.model.AccessToken;
import com.codingapi.wechat.sdk.oauth2.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class WebAppsApiTest {

    @Autowired
    private WebAppsApi webAppsApi;

    @Test
    void userInfo() {
//        String code = "081WyOkl2dTWZa4iHinl276qRW2WyOkK";
//        AccessToken.Response response = webAppsApi.getAccessToken(code);
//        String openId = response.getOpenId();
        UserInfo userInfo =  webAppsApi.getUserInfo("66_84LVY1HQ1yFAb9pZWdkRMqirn1icshKuCq1AhTY0XxITwRg4ddUYsY97JGCcyl6enYHn4JbBn2A63zQjsgw5gf3bBSF4ylZo1inoSpAGcwE",
                "oT3FC6ZQ-rJgq9jXgfHtq4WxRx-4");
        assertNotNull(userInfo);
        log.info("response:{}",userInfo);
        System.out.println(userInfo.decodeNickName());
    }



}