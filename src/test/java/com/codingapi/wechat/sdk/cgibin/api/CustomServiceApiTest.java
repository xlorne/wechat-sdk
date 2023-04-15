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
        MsgSend request = MsgSend.createText("o_KcF6S8b94P1MuEcCXMqrgEpbac", "通讯员：李华\n" +
                "\n" +
                "采访对象：农民工王师傅\n" +
                "\n" +
                "我从小就听说过一个故事，叫做《草房子》。那个时候，我总是幻想着自己能够像庆余年中的大牛一样去历练，走遍全国。而今天，我有机会采访了一位真正的“旅行者”，他来自甘肃省临夏市积石山县，名叫王师傅。\n" +
                "\n" +
                "王师傅出生在一个普通的农民家庭，在父母的教育下，他自幼懂得了勤劳和坚韧不拔的精神。中学毕业后他来到城市打工，在互联网公司当过保安、在建筑工地上干过泥瓦工、搬运工等各种职业。虽然岁月如水，但他一直坚守着最初的信 仰，要做一名劳动者。\n" +
                "\n" +
                "我认为这是一个很好的切入点来探究这位“旅行者”的真正内心世界。 “师傅您常被称为‘劳动模范’，您觉得劳动对您人生有何意义？”我打开提纲问道。\n" +
                "\n" +
                "“劳动是我的全部。从小我就知道，没有劳动就没有生活，更不可能有价值。”说到这里王师傅眼中含着泪水，我明白了这个话题对他来说意义重大。\n" +
                "\n" +
                "“那么您觉得劳动带给您哪些变化呢？”\n" +
                "\n" +
                "“首先是经济上的改变。劳动让我拥有了自给自足的能力，并且还积累了一定的财富。其次是精神上的变化，通过长期劳动，我的性格变得刚毅、坚定和不怕困难。”\n" +
                "\n" +
                "听完王师傅的回答后，我开始思考一个问题：这位“旅行者”在外游历多年，在异乡打工赚钱养家的同时，又经历了哪些困难与挫折呢？\n" +
                "\n" +
                "接下来我开始询问王师傅游历时发生过的故事。“去年冬天，我们在南方一家企业施工。因为天气太冷而暂停施工，导致队友们都怨气冲天。”王师傅擦拭着额头上流出来的汗水继续讲道，“但是我没有放弃！我跑出房间，在零下十几度的天气里，不停地搓手、踩脚，一遍遍地鼓励自己：‘不能放弃！不能让队友们失望！’最终，我们顺利完成了工作。”\n" +
                "\n" +
                "王师傅的坚韧和决心令人钦佩。而这份坚定与勇气使他在异乡打工的道路上艰辛前行，也赢得了来自身边人们的尊敬和爱戴。他开始享受到“走出去”的感觉，而这个过程中也发现了一些“小幸福”。“我曾在一个工地干活，老板会下午请大家喝一杯奶茶。”王师傅说，“那种感觉很棒。”\n" +
                "\n" +
                "通过对周围人士的调查和采访对象的个性分析，我发现：“旅行者”的本质是勤劳、坚忍、固执。他们将生活放在了劳动与收获之上，并且善于发掘生活中的点滴小幸福。\n" +
                "\n" +
                "斗转星移四季轮回，人生万象如春日繁华。对于王师傅来说，在异乡游历、打工有利有弊。但是他始终没有忘记自己是谁，自己要做什么。在自己的人生中，王师傅就是这样一位值得我们学习和尊敬的“旅行者”。\n" +
                "\n" +
                "（注：本文采用虚构人物、事件及地点，纯属虚构）"
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