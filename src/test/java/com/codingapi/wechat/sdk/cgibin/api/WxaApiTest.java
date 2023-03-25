package com.codingapi.wechat.sdk.cgibin.api;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class WxaApiTest {

    @Autowired
    private WxaApi wxaApi;

    @Test
    void test(){
        wxaApi.msgSecCheck();
    }

}