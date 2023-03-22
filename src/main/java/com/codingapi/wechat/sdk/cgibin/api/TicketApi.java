package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson.JSON;
import com.codingapi.springboot.framework.rest.param.RestParamBuilder;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.dto.ticket.Ticket;
import com.codingapi.wechat.sdk.cgibin.dto.user.UserList;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TicketApi {

    private final CgiBinClient cgiBinClient;

    private final Map<String,Ticket> cache = new ConcurrentHashMap<>();

    public TicketApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    private Ticket _getTicket(String type){
        RestParamBuilder builder = RestParamBuilder.create();
        if(StringUtils.hasText(type)){
            builder.add("type",type);
        }
        String json = cgiBinClient.authGet("/cgi-bin/ticket/getticket",builder);
        return JSON.parseObject(json,Ticket.class);
    }

    /**
     * 获得jsapi_ticket
     * @param type jsapi
     * @return  {@link UserList}
     */
    public Ticket getTicket(String type){
        Ticket ticket = cache.get(type);
        if(ticket!=null && !ticket.isExpire()){
            return ticket;
        }
        ticket = _getTicket(type);
        cache.put(type,ticket);
        return ticket;
    }


    public Ticket getTicket(){
        return getTicket("jsapi");
    }
}
