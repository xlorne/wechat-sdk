package com.codingapi.wechat.sdk.cgibin.dto.basic;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

public class AccessToken {


    @Setter
    @Getter
    @ToString
    public static class Response{

        /**
         * 获取到的凭证
         */
        @JSONField(name = "access_token")
        private String accessToken;

        /**
         * 凭证有效时间，单位：秒
         */
        @JSONField(name = "expires_in")
        private int expiresIn;


        public boolean isSuccess(){
            return expiresIn==7200 && StringUtils.hasText(accessToken);
        }

    }
}
