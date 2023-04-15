package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson.JSON;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.model.BaseResponse;
import com.codingapi.wechat.sdk.cgibin.model.customservice.MsgList;
import com.codingapi.wechat.sdk.cgibin.model.customservice.MsgSend;
import com.codingapi.wechat.sdk.cgibin.model.customservice.TypingSend;

public class CustomServiceApi {

    private final CgiBinClient cgiBinClient;

    private final static int MAX_MSG_SIZE = 600;

    public CustomServiceApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    public  MsgList.Response getMsgList(MsgList.Request request){
        String json = cgiBinClient.authPost("/customservice/msgrecord/getmsglist", request.getParameters());
        return JSON.parseObject(json, MsgList.Response.class);
    }

    public BaseResponse sendMsg(MsgSend request){
        return sendMsg(request,true);
    }

    public BaseResponse sendMsg(MsgSend request,boolean splitSend){
        if(request.hasText() && splitSend){
            String content = request.getText().getContent();
            if(content.length() <= MAX_MSG_SIZE){
                return _sendMsg(request);
            }else {
                int start = 0;
                int end = MAX_MSG_SIZE;
                BaseResponse response = null;
                while (start < content.length()){
                    String subContent = content.substring(start,end);
                    request.getText().setContent(subContent);
                    response = _sendMsg(request);
                    if(response.getErrcode() != 0){
                        return response;
                    }
                    start = end;
                    end = end + MAX_MSG_SIZE;
                    if(end > content.length()){
                        end = content.length();
                    }
                }
                return response;
            }
        }else {
            return _sendMsg(request);
        }
    }

    private BaseResponse _sendMsg(MsgSend request){
        String json = cgiBinClient.authPost("/cgi-bin/message/custom/send", request.getParameters());
        return JSON.parseObject(json, BaseResponse.class);
    }

    public BaseResponse typing(TypingSend request){
        String json = cgiBinClient.authPost("/cgi-bin/message/custom/typing", request.getParameters());
        return JSON.parseObject(json, BaseResponse.class);
    }
}
