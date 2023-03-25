package com.codingapi.wechat.sdk.cgibin.api;

import com.codingapi.wechat.sdk.cgibin.model.BaseResponse;
import com.codingapi.wechat.sdk.cgibin.model.customservice.MsgList;
import com.codingapi.wechat.sdk.cgibin.model.customservice.MsgSend;
import com.codingapi.wechat.sdk.cgibin.model.customservice.TypingSend;
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
        MsgSend request = new MsgSend("oT3FC6WvexVrYLj66nyFvRsLpJw8", "请点击<a href=\"https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxc62bed375381b5be&redirect_uri=http%3A%2F%2Fchat-api.codingapi.com%2F%23%2Fpay&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect\">充值</a>，然后选择套餐充值");
        BaseResponse response =customServiceApi.sendMsg(request);
        assertTrue(response.isSuccess());
    }

    @Test
    void typing() {
        TypingSend request =TypingSend.typing("oT3FC6WvexVrYLj66nyFvRsLpJw8");
        BaseResponse response =customServiceApi.typing(request);
        assertTrue(response.isSuccess());
    }

    @Test
    void cancelTyping() {
        TypingSend request =TypingSend.cancelTyping("oT3FC6WvexVrYLj66nyFvRsLpJw8");
        BaseResponse response =customServiceApi.typing(request);
        assertTrue(response.isSuccess());
    }
}