package com.codingapi.wechat.sdk.cgibin.api;

import com.codingapi.wechat.sdk.cgibin.model.MsgSec;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class WxaApiTest {

    @Autowired
    private WxaApi wxaApi;

    @Test
    void test(){
        MsgSec.Request request = new MsgSec.Request();
        request.setContent("你好");
        request.setVersion("1.0");
        MsgSec.Response response = wxaApi.msgSecCheck(request);
        assertNotNull(response);
        log.info("response:{}", response);
    }

}