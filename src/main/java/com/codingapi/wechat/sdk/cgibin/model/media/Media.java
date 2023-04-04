package com.codingapi.wechat.sdk.cgibin.model.media;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Media {

    private String type;
    @JSONField(name = "media_id")
    private String mediaId;

    @JSONField(name = "created_at")
    private long createdAt;

}
