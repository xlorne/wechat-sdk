package com.codingapi.wechat.sdk.cgibin.api;

import com.codingapi.springboot.framework.rest.RestTemplateContext;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import lombok.SneakyThrows;
import org.springframework.http.*;
import org.springframework.util.Base64Utils;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;

public class MediaApi {

    private final String accessToken;

    private final RestTemplate restTemplate = RestTemplateContext.getInstance().getRestTemplate();

    public MediaApi(CgiBinClient cgiBinClient) {
        this.accessToken = cgiBinClient.getAccessToken();
    }

    public String addVoice(String voice_id,String data){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        HttpEntity<byte[]> requestEntity = new HttpEntity<>(Base64Utils.decodeFromString(data),headers);
        String url = "https://api.weixin.qq.com/cgi-bin/media/voice/addvoicetorecofortext?access_token="+accessToken+"&format=mp3&voice_id="+voice_id+"&lang=zh_CN";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }

    public String voice2Text(String mediaId){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);
        MultiValueMap<String,String> request = new LinkedMultiValueMap<>();
        request.add("access_token",accessToken);
        request.add("voice_id",mediaId);
        request.add("lang","zh_CN");
        HttpEntity<MultiValueMap<String,String>> requestEntity = new HttpEntity<>(request,headers);
        String url = "https://api.weixin.qq.com/cgi-bin/media/voice/queryrecoresultfortext";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);
        return response.getBody();
    }


    @SneakyThrows
    public String getVoice(String mediaId){
        String url = "https://api.weixin.qq.com/cgi-bin/media/get?access_token="+accessToken+"&media_id="+mediaId;
        System.setProperty("ffmpeg.home","D:\\developer\\tools\\ffmpeg\\bin\\");
        byte[] data = Objects.requireNonNull(restTemplate.getForObject(url, byte[].class));
        return Base64Utils.encodeToString(data);
    }

}
