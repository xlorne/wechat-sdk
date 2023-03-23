package com.codingapi.wechat.sdk.pay.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotifyResponse {

    private String code;
    private String message;


    private NotifyResponse() {
    }

    public static NotifyResponse success(){
        NotifyResponse response = new NotifyResponse();
        response.setCode("SUCCESS");
        return response;
    }


    public static NotifyResponse fail(String message){
        NotifyResponse response = new NotifyResponse();
        response.setCode("FAIL");
        response.setMessage(message);
        return response;
    }
}
