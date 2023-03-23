package com.codingapi.wechat.sdk.cgibin.model.ticket;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Ticket {

    private int errcode;
    private String errmsg;
    private String ticket;

    @JSONField(name = "expires_in")
    private int expiresIn;

    private long created;

    public Ticket() {
        this.created = System.currentTimeMillis();
    }

    public boolean isExpire(){
        long now = System.currentTimeMillis();
        return (now - created) / 1000 > (expiresIn - 10);
    }
}
