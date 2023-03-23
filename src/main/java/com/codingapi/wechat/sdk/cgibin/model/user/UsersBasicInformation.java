package com.codingapi.wechat.sdk.cgibin.model.user;

import com.alibaba.fastjson.annotation.JSONField;
import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 获取用户基本信息(UnionID机制)
 * <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId">api</a>
 */
public class UsersBasicInformation {

    @Setter
    @Getter
    public static class Request implements RestParam {



        /**
         * 调用接口凭证
         */
        private String accessToken;

        /**
         * 普通用户的标识，对当前公众号唯一
         */
        @JSONField(name = "openid")
        private String openId;

        /**
         * 返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
         */
        private String lang;
    }

    @Setter
    @Getter
    @ToString
    public static class Response{

        /**
         * 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。
         */
        private String subscribe;

        /**
         * 用户的标识，对当前公众号唯一
         */
        @JSONField(name = "openid")
        private String openId;

        /**
         *用户的语言，简体中文为zh_CN
         */
        private String language;

        /**
         * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
         */
        @JSONField(name = "subscribe_time")
        private long subscribeTime;

        /**
         * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
         */
        @JSONField(name = "unionid")
        private String unionId;

        /**
         * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
         */
        private String remark;

        /**
         * 用户所在的分组ID（兼容旧的用户分组接口）
         */
        @JSONField(name = "groupid")
        private String groupId;

        /**
         * 用户被打上的标签 ID 列表
         */
        @JSONField(name = "tagid_list")
        private String tagIdList;

        /**
         * 返回用户关注的渠道来源，
         * ADD_SCENE_SEARCH 公众号搜索，
         * ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，
         * ADD_SCENE_PROFILE_CARD 名片分享，
         * ADD_SCENE_QR_CODE 扫描二维码，
         * ADD_SCENE_PROFILE_LINK 图文页内名称点击，
         * ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，
         * ADD_SCENE_PAID 支付后关注，
         * ADD_SCENE_WECHAT_ADVERTISEMENT 微信广告，
         * ADD_SCENE_REPRINT 他人转载 ,
         * ADD_SCENE_LIVESTREAM 视频号直播，
         * ADD_SCENE_CHANNELS 视频号 ,
         * ADD_SCENE_OTHERS 其他
         */
        @JSONField(name = "subscribe_scene")
        private String subscribeScene;

        /**
         * 二维码扫码场景（开发者自定义）
         */
        @JSONField(name = "qr_scene")
        private String qrScene;

        /**
         * 二维码扫码场景描述（开发者自定义）
         */
        @JSONField(name = "qr_scene_str")
        private String qrSceneStr;
    }
}
