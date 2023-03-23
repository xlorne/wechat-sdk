package com.codingapi.wechat.sdk;

import com.codingapi.wechat.sdk.cgibin.api.UserManagementApi;
import com.codingapi.wechat.sdk.cgibin.model.user.UserList;
import com.codingapi.wechat.sdk.cgibin.model.user.UsersBasicInformation;
import com.codingapi.wechat.sdk.cgibin.exception.ResponseErrorException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class UserManagementApiTest {

    @Autowired
    private UserManagementApi userManagementApi;

    @Test
    void userInfo1() {
        assertThrows(ResponseErrorException.class,()->{
                UsersBasicInformation.Response response =  userManagementApi.userBasicInfo("123123");
                assertNotNull(response);
                log.info("response:{}",response);
        });
    }


    @Test
    void userInfo2() {
        UsersBasicInformation.Response response =  userManagementApi.userBasicInfo("oK1F_6R8AwFqHqQCPNshVUdh2k2E");
        assertNotNull(response);
        log.info("response:{}",response);
    }

    @Test
    void userList() {
        UserList userList =  userManagementApi.userList();
        List<String> openIds = userList.getOpenIds();
        assertTrue(openIds.size()>0);
        log.info("openIds:{}",openIds);
    }

}