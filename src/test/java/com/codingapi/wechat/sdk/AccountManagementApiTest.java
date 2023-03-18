package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.cgibin.api.AccountManagementApi;
import com.codingapi.wechat.sdk.cgibin.dto.account.QrcodeCreate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class AccountManagementApiTest {

    @Autowired
    private AccountManagementApi accountManagementApi;

    @Test
    void qrcodeCreate() {
        QrcodeCreate.Request request = new QrcodeCreate.Request("test");
        QrcodeCreate.Response response = accountManagementApi.qrcodeCreate(request);
        log.info("response:{}",response);
        assertNotNull(response.getTicket());
        log.info("qr:{}",response.getQrUrl());
    }
}