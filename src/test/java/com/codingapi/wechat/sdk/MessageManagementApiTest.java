package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.cgibin.api.MessageManagementApi;
import com.codingapi.wechat.sdk.cgibin.model.message.TemplateSend;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class MessageManagementApiTest {

    @Autowired
    private MessageManagementApi messageManagementApi;

    @Test
    void send() {
        //https://www.emojidaquan.com/
        TemplateSend.Request request = new TemplateSend.Request();
        request.setToUser("oK1F_6R8AwFqHqQCPNshVUdh2k2E");
        request.setTemplateId("Ta493p2PVcHzgRaFB0iiBmdC6R5ksLQe_L60xQNDxts");
        request.addData("first","我是测试标题\uD83D\uDD53");
        request.addData("keyword1","我是关键字1");
        request.addData("keyword2","我是关键字2");
        request.addData("remark","我是备注信息");
        TemplateSend.Response response =  messageManagementApi.send(request);
        assertNotNull(response);
        log.info("response:{}",response);
    }
}