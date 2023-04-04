package com.codingapi.wechat.sdk.cgibin.api;

import com.codingapi.wechat.sdk.cgibin.model.media.Media;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class MediaApiTest {

    @Autowired
    private MediaApi mediaApi;

    @Test
    void upload() throws IOException {
        String file = "C:\\developer\\test\\test.jpg";
        byte[] data = Files.readAllBytes(new File(file).toPath());
        Media media = mediaApi.upload("image","xxxx.png",data);
        assertNotNull(media);
        log.info("mediaId:{}",media.getMediaId());
    }
}