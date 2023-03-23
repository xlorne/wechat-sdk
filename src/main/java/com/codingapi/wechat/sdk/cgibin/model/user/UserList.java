package com.codingapi.wechat.sdk.cgibin.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 获取用户列表
 * <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Getting_a_User_List.html">api</a>
 */
@Setter
@Getter
public class UserList {

    private int total;
    private int count;
    private Data data;

    @JSONField(name = "next_openid")
    private String nextOpenId;

    public List<String> getOpenIds(){
        return data.getOpenId();
    }

    @Setter
    @Getter
    public static class Data{

        @JSONField(name = "openid")
        private List<String> openId;


    }
}
