package com.codingapi.wechat.sdk.cgibin.api;

import com.codingapi.wechat.sdk.cgibin.model.BaseResponse;
import com.codingapi.wechat.sdk.cgibin.model.customservice.MsgList;
import com.codingapi.wechat.sdk.cgibin.model.customservice.MsgSend;
import com.codingapi.wechat.sdk.cgibin.model.customservice.TypingSend;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "dev")
class CustomServiceApiTest {


    @Autowired
    private CustomServiceApi customServiceApi;


    @Test
    void getMsgList() {
        MsgList.Request request = new MsgList.Request();
        request.setNumber(10000);

        long now = System.currentTimeMillis() / 1000;
        long start = now - (60 * 60 * 24);
        long end = now;
        request.setStarttime(start);
        request.setEndtime(end);
        request.setMsgid(1L);

        MsgList.Response response = customServiceApi.getMsgList(request);
        System.out.println(response);
    }


    @Test
    void sendText() {
        MsgSend request = MsgSend.createText("o_KcF6S8b94P1MuEcCXMqrgEpbac", "不过在俄乌战争之下，美欧关系的共识更多，这给中欧关系也肯定会带来影响。\n" +
                "\n" +
                "比如4月3日木叔注意到，就在冯德莱恩和马克龙联袂来华之前，两人先举行了一次“碰头会”，双方利用工作午餐的机会来谈谈访华的话题，试图在很多讨论中表达相同或者相似的看法。\n" +
                "\n" +
                "根据欧盟委员会代表埃里克·马默在社交媒体上的说法，两人的碰头会讨论俄罗斯对乌克兰的战争、能源合作和访问中国的准备工作。\n" +
                "\n" +
                "美国媒体认为，马克龙访华体现了他和欧洲其他国家对华看法的不同，因为他带领了一个为数众多企业家的商业代表团，还要访问广州，要在中国待上3天左右。\n" +
                "\n" +
                "而上次德国总理朔尔茨来华基本没什么重量级代表团陪同，待了不到24小时就飞回去了。\n" +
                "\n" +
                "冯德莱恩对华和马克龙也有微妙不同。她在前几天的演讲中更多强调中欧官方的“去风险化”，这引发了我们官方的批评。\n" +
                "\n" +
                "两人访华的主要目的之一，除了谈经济合作和中欧关系之外，一个重点就是谈乌克兰问题。也就是说，要明确中国不对俄提供武器的立场，并且探讨中国是不是会在结束俄乌战争中发挥更大斡旋作用。\n" +
                "\n" +
                "从这个角度讲，两人来华也似乎肩负着一些欧洲版的“停火止战”的任务吧！" +
                "不过在俄乌战争之下，美欧关系的共识更多，这给中欧关系也肯定会带来影响。\n" +
                "\n" +
                "比如4月3日木叔注意到，就在冯德莱恩和马克龙联袂来华之前，两人先举行了一次“碰头会”，双方利用工作午餐的机会来谈谈访华的话题，试图在很多讨论中表达相同或者相似的看法。\n" +
                "\n" +
                "根据欧盟委员会代表埃里克·马默在社交媒体上的说法，两人的碰头会讨论俄罗斯对乌克兰的战争、能源合作和访问中国的准备工作。\n" +
                "\n" +
                "美国媒体认为，马克龙访华体现了他和欧洲其他国家对华看法的不同，因为他带领了一个成功。不过在俄乌战争之下，美欧关系的共识更多，这给中欧关系也肯定会带来影响。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"比如4月3日木叔注意到，就在冯德莱恩和马克龙联袂来华之前，两人先举行了一次“碰头会”，双方利用工作午餐的机会来谈谈访华的话题，试图在很多讨论中表达相同或者相似的看法。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"根据欧盟委员会代表埃里克·马默在社交媒体上的说法，两人的碰头会讨论俄罗斯对乌克兰的战争、能源合作和访问中国的准备工作。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"美国媒体认为，马克龙访华体现了他和欧洲其他国家对华看法的不同，因为他带领了一个为数众多企业家的商业代表团，还要访问广州，要在中国待上3天左右。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"而上次德国总理朔尔茨来华基本没什么重量级代表团陪同，待了不到24小时就飞回去了。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"冯德莱恩对华和马克龙也有微妙不同。她在前几天的演讲中更多强调中欧官方的“去风险化”，这引发了我们官方的批评。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"两人访华的主要目的之一，除了谈经济合作和中欧关系之外，一个重点就是谈乌克兰问题。也就是说，要明确中国不对俄提供武器的立场，并且探讨中国是不是会在结束俄乌战争中发挥更大斡旋作用。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"从这个角度讲，两人来华也似乎肩负着一些欧洲版的“停火止战”的任务吧！\" +\n" +
                "                \"不过在俄乌战争之下，美欧关系的共识更多，这给中欧关系也肯定会带来影响。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"比如4月3日木叔注意到，就在冯德莱恩和马克龙联袂来华之前，两人先举行了一次“碰头会”，双方利用工作午餐的机会来谈谈访华的话题，试图在很多讨论中表达相同或者相似的看法。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"根据欧盟委员会代表埃里克·马默在社交媒体上的说法，两人的碰头会讨论俄罗斯对乌克兰的战争、能源合作和访问中国的准备工作。\\n\" +\n" +
                "                \"\\n\" +\n" +
                "                \"美国媒体认为，马克龙访华体现了他和欧洲其他国家对华看法的不同，因为他带领了一个成功。"
        );
        int length = request.getText().getContent().length();
        log.info("length:{}", length);
        BaseResponse response = customServiceApi.sendMsg(request);
        log.info("response:{}", response);
        assertTrue(response.isSuccess());
    }

    @Test
    void sendImage() {
        MsgSend request = MsgSend.createImage("o_KcF6S8b94P1MuEcCXMqrgEpbac", "vbBBzLD5FhKykRK2XvyzO1rv4-oC4L2zNH3ZS2UdSg10wcIdieHRN5Yy-_48GdwE");
        BaseResponse response = customServiceApi.sendMsg(request);
        assertTrue(response.isSuccess());
    }


    @Test
    void typing() {
        TypingSend request = TypingSend.typing("oT3FC6WvexVrYLj66nyFvRsLpJw8");
        BaseResponse response = customServiceApi.typing(request);
        assertTrue(response.isSuccess());
    }

    @Test
    void cancelTyping() {
        TypingSend request = TypingSend.cancelTyping("oT3FC6WvexVrYLj66nyFvRsLpJw8");
        BaseResponse response = customServiceApi.typing(request);
        assertTrue(response.isSuccess());
    }
}