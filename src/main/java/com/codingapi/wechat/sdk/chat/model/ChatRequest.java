package com.codingapi.wechat.sdk.chat.model;

import lombok.Getter;
import lombok.SneakyThrows;
import lombok.ToString;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

@Getter
@ToString
public class ChatRequest {

    /**
     * 发送方帐号（一个OpenID）
     */
    private String formUserName;
    /**
     * 消息创建时间 （整型）
     */
    private String createTime;
    /**
     * 开发者微信号
     */
    private String toUserName;
    /**
     * 消息类型，文本为text
     */
    private String msgType;
    /**
     * 文本消息内容
     */
    private String content;
    /**
     * 消息id，64位整型
     */
    private String msgId;
    /**
     * 语音消息媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String mediaId;
    /**
     * 消息的数据ID（消息如果来自文章时才有）
     */
    private String msgDataId;
    /**
     * 多图文时第几篇文章，从1开始（消息如果来自文章时才有）
     */
    private String idx;
    /**
     * 语音格式，如amr，speex等
     */
    private String format;

    /**
     * 语音识别结果，UTF8编码
     */
    private String recognition;

    /**
     * 视频消息缩略图的媒体id，可以调用获取临时素材接口拉取数据。
     */
    private String thumbMediaId;

    /**
     * 地理位置纬度
     */
    private String locationX;

    /**
     * 地理位置经度
     */
    private String locationY;
    /**
     * 地图缩放大小
     */
    private String scale;

    /**
     * 地理位置信息
     */
    private String label;

    /**
     * 消息标题
     */
    private String title;
    /**
     * 消息描述
     */
    private String description;
    /**
     * 消息链接
     */
    private String url;

    /**
     * 事件类型，LOCATION
     */
    private String event;


    /**
     * 事件KEY值，与自定义菜单接口中KEY值对应
     */
    private String eventKey;

    /**
     * 地理位置纬度
     */
    private String ticket;


    /**
     * 地理位置纬度
     */
    private String latitude;

    /**
     * 地理位置经度
     */
    private String longitude;

    /**
     * 地理位置精度
     */
    private String precision;


    @SneakyThrows
    public ChatRequest(String xml) {
        Document document = DocumentHelper.parseText(xml);
        Element root = document.getRootElement();

        this.formUserName =  root.element("FromUserName").getTextTrim();
        this.toUserName =  root.element("ToUserName").getTextTrim();
        this.createTime =  root.element("CreateTime").getTextTrim();
        this.msgType =  root.element("MsgType").getTextTrim();
        if(root.element("MsgId")!=null) {
            this.msgId = root.element("MsgId").getTextTrim();
        }
        if(root.element("Recognition")!=null) {
            this.recognition = root.element("Recognition").getTextTrim();
        }
        if(root.element("ThumbMediaId")!=null) {
            this.thumbMediaId = root.element("ThumbMediaId").getTextTrim();
        }
        if(root.element("Format")!=null) {
            this.format = root.element("Format").getTextTrim();
        }
        if(root.element("Content")!=null) {
            this.content = root.element("Content").getTextTrim();
        }
        if(root.element("MediaId")!=null) {
            this.mediaId = root.element("MediaId").getTextTrim();
        }
        if(root.element("MsgDataId")!=null) {
            this.msgDataId = root.element("MsgDataId").getTextTrim();
        }
        if(root.element("Idx")!=null) {
            this.idx = root.element("Idx").getTextTrim();
        }

        if(root.element("Location_X")!=null) {
            this.locationX = root.element("Location_X").getTextTrim();
        }
        if(root.element("Location_Y")!=null) {
            this.locationY = root.element("Location_Y").getTextTrim();
        }
        if(root.element("Scale")!=null) {
            this.scale = root.element("Scale").getTextTrim();
        }
        if(root.element("Label")!=null) {
            this.label = root.element("Label").getTextTrim();
        }

        if(root.element("Url")!=null) {
            this.url = root.element("Url").getTextTrim();
        }

        if(root.element("Description")!=null) {
            this.description = root.element("Description").getTextTrim();
        }

        if(root.element("Event")!=null) {
            this.event = root.element("Event").getTextTrim();
        }

        if(root.element("EventKey")!=null) {
            this.eventKey = root.element("EventKey").getTextTrim();
        }

        if(root.element("Ticket")!=null) {
            this.ticket = root.element("Ticket").getTextTrim();
        }
        if(root.element("Latitude")!=null) {
            this.latitude = root.element("Latitude").getTextTrim();
        }
        if(root.element("Longitude")!=null) {
            this.longitude = root.element("Longitude").getTextTrim();
        }
        if(root.element("Precision")!=null) {
            this.precision = root.element("Precision").getTextTrim();
        }

    }


    public boolean isText(){
        return msgType.equals("text");
    }

    public boolean isEvent(){
        return msgType.equals("event");
    }

    public boolean isVoice(){
        return msgType.equals("voice");
    }
}
