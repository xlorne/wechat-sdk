package com.codingapi.wechat.sdk.cgibin.api;

import com.alibaba.fastjson.JSON;
import com.codingapi.springboot.framework.rest.param.RestParamBuilder;
import com.codingapi.wechat.sdk.cgibin.CgiBinClient;
import com.codingapi.wechat.sdk.cgibin.dto.user.UserList;
import com.codingapi.wechat.sdk.cgibin.dto.user.UsersBasicInformation;
import org.springframework.util.StringUtils;

public class UserManagementApi {

    private final CgiBinClient cgiBinClient;

    public UserManagementApi(CgiBinClient cgiBinClient) {
        this.cgiBinClient = cgiBinClient;
    }

    public UsersBasicInformation.Response userBasicInfo(String openId){
        return userBasicInfo(openId,"zh_CN");
    }


    /**
     * 获取用户基本信息(UnionID机制)
     * @param openId 普通用户的标识，对当前公众号唯一
     * @param lang 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
     * @return {@link UsersBasicInformation.Response}
     */
    public UsersBasicInformation.Response userBasicInfo(String openId, String lang){
        UsersBasicInformation.Request request = new UsersBasicInformation.Request();
        request.setLang(lang);
        request.setOpenId(openId);
        String json = cgiBinClient.authGet("/cgi-bin/user/info",request.getParameters());
        return JSON.parseObject(json,UsersBasicInformation.Response.class);
    }


    /**
     * 获取用户列表
     * @param nextOpenId 第一个拉取的OPENID，不填默认从头开始拉取
     * @return  {@link UserList}
     */
    public UserList userList(String nextOpenId){
        RestParamBuilder builder = RestParamBuilder.create();
        if(StringUtils.hasText(nextOpenId)){
            builder.add("next_openid",nextOpenId);
        }
        String json = cgiBinClient.authGet("/cgi-bin/user/get",builder);
        return JSON.parseObject(json,UserList.class);
    }

    public UserList userList(){
        return userList(null);
    }

}
