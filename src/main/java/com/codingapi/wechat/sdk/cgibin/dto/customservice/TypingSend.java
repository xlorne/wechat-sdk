package com.codingapi.wechat.sdk.cgibin.dto.customservice;

import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TypingSend implements RestParam {

    private String touser;
    private String command;

    private TypingSend() {
    }

    public static TypingSend typing(String touser){
        TypingSend send = new TypingSend();
        send.setCommand("Typing");
        send.setTouser(touser);
        return send;
    }


    public static TypingSend cancelTyping(String touser){
        TypingSend send = new TypingSend();
        send.setCommand("CancelTyping");
        send.setTouser(touser);
        return send;
    }
}
