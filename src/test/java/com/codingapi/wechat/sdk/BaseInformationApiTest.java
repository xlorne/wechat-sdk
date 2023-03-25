package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.cgibin.api.BaseInformationApi;
import com.codingapi.wechat.sdk.oauth2.model.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class BaseInformationApiTest {

    @Autowired
    private BaseInformationApi baseInformationApi;

    @Test
    void token() {
        AccessToken.Response response = baseInformationApi.token();
        log.info("response:{}",response);

        assertTrue(response.isSuccess());
        assertFalse(response.isExpire());
        assertNotNull(response.getAccessToken());
    }
}