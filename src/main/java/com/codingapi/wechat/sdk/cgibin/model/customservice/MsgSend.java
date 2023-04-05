package com.codingapi.wechat.sdk.cgibin.model.customservice;

import com.codingapi.springboot.framework.rest.param.RestParam;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MsgSend implements RestParam {

    private String touser;
    private String msgtype;

    private Text text;
    private Image image;


    public boolean hasText(){
        return "text".equals(msgtype);
    }

    public static MsgSend createText(String touser,String content){
        MsgSend send = new MsgSend();
        send.setTouser(touser);
        send.setMsgtype("text");
        Text text = new Text();
        text.setContent(content);
        send.setText(text);
        return send;
    }

    public static MsgSend createImage(String touser,String mediaId){
        MsgSend send = new MsgSend();
        send.setTouser(touser);
        send.setMsgtype("image");
        Image image = new Image();
        image.setMedia_id(mediaId);
        send.setImage(image);
        return send;
    }


    @Setter
    @Getter
    public static class Text{
        private String content;
    }

    @Setter
    @Getter
    public static class Image{
        private String media_id;
    }
}
