package com.codingapi.wechat.sdk.cgibin.model.message;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 发送模板消息
 * <a href="https://developers.weixin.qq.com/doc/offiaccount/Message_Management/Template_Message_Interface.html#%E5%8F%91%E9%80%81%E6%A8%A1%E6%9D%BF%E6%B6%88%E6%81%AF">api</a>
 */
public class TemplateSend {


    @Setter
    @Getter
    public static class Request{
        /**
         * 接收者openid
         */
        @JSONField(name = "touser")
        private String toUser;
        /**
         * 模板ID
         */
        @JSONField(name = "template_id")
        private String templateId;
        /**
         * 模板跳转链接（海外帐号没有跳转能力）
         * 是否必填 否
         */
        private String url;

        /**
         * 跳小程序所需数据，不需跳小程序可不用传该数据
         * 是否必填 否
         */
        @JSONField(name = "miniprogram")
        private String miniProgram;

        /**
         * 所需跳转到的小程序appid（该小程序 appid 必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
         */
        @JSONField(name = "appid")
        private String appId;

        /**
         * 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），要求该小程序已发布，暂不支持小游戏
         * 是否必填 否
         */
        @JSONField(name = "pagepath")
        private String pagePath;

        /**
         * 模板数据
         */
        private Map<String,Value> data;

        /**
         * 模板内容字体颜色，不填默认为黑色
         * 是否必填 否
         */
        private String color;

        /**
         * 防重入id。对于同一个openid + client_msg_id, 只发送一条消息,10分钟有效,超过10分钟不保证效果。若无防重入需求，可不填
         * 是否必填 否
         */
        @JSONField(name = "client_msg_id")
        private String clientMsgId;

        public Request() {
            this.data = new HashMap<>();
        }

        public Request addData(String key,String value,String color){
            this.data.put(key,new Value(value,color));
            return this;
        }

        public Request addData(String key,String value){
            return addData(key, value,"");
        }
    }

    @Setter
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Value{
        private String value;
        private String color;

    }

    @Setter
    @Getter
    @ToString
    public static class Response{
        @JSONField(name = "errcode")
        private int errCode;
        @JSONField(name = "errmsg")
        private String errMsg;
        @JSONField(name = "msgid")
        private long msgId;
    }
}
