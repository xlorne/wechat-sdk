package com.codingapi.wechat.sdk.cgibin.dto.account;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * 生成带参数的二维码
 * <a href="https://developers.weixin.qq.com/doc/offiaccount/Account_Management/Generating_a_Parametric_QR_Code.html">api</a>
 * 获取关注后的参数 => 获取用户基本信息
 * <a href="https://developers.weixin.qq.com/doc/offiaccount/User_Management/Get_users_basic_information_UnionID.html#UinonId">api</a>
 */
public class QrcodeCreate {

    public enum Action{
        QR_SCENE("QR_SCENE"),
        QR_STR_SCENE("QR_STR_SCENE"),

        QR_LIMIT_SCENE("QR_LIMIT_SCENE"),
        QR_LIMIT_STR_SCENE("QR_LIMIT_STR_SCENE");

        @Getter
        private final String code;

        Action(String code) {
            this.code = code;
        }

        @Override
        public String toString() {
            return code;
        }
    }

    @Setter
    @Getter
    public static class Request{

        /**
         * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天），此字段如果不填，则默认有效期为60秒。
         */
        @JSONField(name = "expire_seconds")
        private int expireSeconds;

        /**
         * 二维码类型，QR_SCENE为临时的整型参数值，QR_STR_SCENE为临时的字符串参数值，
         * QR_LIMIT_SCENE为永久的整型参数值，QR_LIMIT_STR_SCENE为永久的字符串参数值
         */
        @JSONField(name = "action_name")
        private String actionName;

        /**
         * 二维码详细信息
         */
        @JSONField(name = "action_info")
        private ActionInfo actionInfo;

        public Request(int expireSeconds, Action action,int sceneId) {
            this.expireSeconds = expireSeconds;
            this.actionName = action.code;
            this.actionInfo = new ActionInfo();
            Scene scene = new Scene();
            scene.setSceneId(String.valueOf(sceneId));
            this.actionInfo.setScene(scene);
        }

        public Request(int expireSeconds, Action action,String sceneStr) {
            this.expireSeconds = expireSeconds;
            this.actionName = action.code;
            this.actionInfo = new ActionInfo();
            Scene scene = new Scene();
            scene.setSceneStr(sceneStr);
            this.actionInfo.setScene(scene);
        }

        public Request(String sceneStr) {
            this(2592000,Action.QR_STR_SCENE,sceneStr);
        }

    }

    @Setter
    @Getter
    public static class ActionInfo{

        private Scene scene;
    }

    @Setter
    @Getter
    public static class Scene{
        /**
         * 场景值ID，临时二维码时为32位非0整型，永久二维码时最大值为100000（目前参数只支持1--100000）
         */
        @JSONField(name = "scene_id")
        private String sceneId;

        /**
         * 场景值ID（字符串形式的ID），字符串类型，长度限制为1到64
         */
        @JSONField(name = "scene_str")
        private String sceneStr;
    }



    @Setter
    @Getter
    public static class Response{

        /**
         * 获取的二维码ticket，凭借此 ticket 可以在有效时间内换取二维码。
         */
        private String ticket;
        /**
         * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
         */
        @JSONField(name = "expire_seconds")
        private int expireSeconds;
        /**
         * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
         */
        private String url;


        public String getQrUrl(){
            return "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket="+ URLEncoder.encode(ticket, StandardCharsets.UTF_8);
        }
    }

}
