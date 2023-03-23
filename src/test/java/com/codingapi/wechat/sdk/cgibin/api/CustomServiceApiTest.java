package com.codingapi.wechat.sdk.cgibin.api;

import com.codingapi.wechat.sdk.cgibin.dto.customservice.MsgList;
import com.codingapi.wechat.sdk.cgibin.dto.customservice.MsgSend;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class CustomServiceApiTest {


    @Autowired
    private CustomServiceApi customServiceApi;


    @Test
    void getMsgList() {
        MsgList.Request request = new MsgList.Request();
        request.setNumber(10000);

        long now = System.currentTimeMillis() / 1000;
        long start = now - (60 * 60 * 24);
        long end = now;
        request.setStarttime(start);
        request.setEndtime(end);
        request.setMsgid(1L);

        MsgList.Response response = customServiceApi.getMsgList(request);
        System.out.println(response);
    }


    @Test
    void send() {
        MsgSend.Request request = new MsgSend.Request("oT3FC6WvexVrYLj66nyFvRsLpJw8", "你好");
        MsgSend.Response response =customServiceApi.sendMsg(request);
        assertTrue(response.isSuccess());
    }
}