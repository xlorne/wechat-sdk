package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.cgibin.api.BaseInformationApi;
import com.codingapi.wechat.sdk.oauth2.dto.AccessToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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

        assertEquals(response.getExpiresIn(),7200);
        assertNotNull(response.getAccessToken());
    }
}