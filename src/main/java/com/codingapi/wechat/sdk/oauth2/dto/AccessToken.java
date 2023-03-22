package com.codingapi.wechat.sdk.oauth2.dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import org.springframework.util.StringUtils;

public class AccessToken {

    @Setter
    @Getter
    public static class Request implements RestParam {
        private String appid;
        private String secret;
        private String code;
        private String grant_type;
    }


    @Setter
    @Getter
    public static class Response{

        @JSONField(name = "access_token")
        private String accessToken;

        @JSONField(name = "expires_in")
        private int expiresIn;

        @JSONField(name = "refresh_token")
        private String refreshToken;

        @JSONField(name = "openid")
        private String openId;

        private String scope;

        @JSONField(name = "is_snapshotuser")
        private String isSnapshotuser;

        @JSONField(name = "unionid")
        private String unionId;


        private long created;

        public Response() {
            this.created = System.currentTimeMillis();
        }

        public boolean isSuccess(){
            return expiresIn>0 && StringUtils.hasText(accessToken);
        }

        public boolean isExpire(){
            long now  = System.currentTimeMillis();
            long time = (now - created)/1000;
            return (time - 10)>expiresIn;
        }


    }

}
