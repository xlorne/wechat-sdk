package com.codingapi.wechat.sdk.pay.notify;

import com.codingapi.wechat.sdk.pay.WechatV3Config;
import com.codingapi.wechat.sdk.pay.model.NotifyResponse;
import com.wechat.pay.java.core.notification.NotificationParser;
import com.wechat.pay.java.service.payments.jsapi.JsapiService;
import com.wechat.pay.java.service.payments.jsapi.model.QueryOrderByOutTradeNoRequest;
import com.wechat.pay.java.service.payments.model.Transaction;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.function.Predicate;

@Slf4j
@AllArgsConstructor
public class NotifyService {


    private final WechatV3Config wechatV3Config;


    /**
     * 支付回调逻辑
     * @param request  请求的数据
     * @param predicate 自定义格式
     * @return 响应数据
     * @throws IOException
     */
    public NotifyResponse notify(HttpServletRequest request, Predicate<Transaction> predicate) throws IOException {

        String body = IOUtils.toString(request.getInputStream(), StandardCharsets.UTF_8);
        String signature = request.getHeader("Wechatpay-Signature");
        String nonce = request.getHeader("Wechatpay-Nonce");
        String timestamp = request.getHeader("Wechatpay-Timestamp");
        String signType = request.getHeader("Wechatpay-Signature-Type");
        String serial = request.getHeader("Wechatpay-Serial");

        // 构造 RequestParam
        com.wechat.pay.java.core.notification.RequestParam requestParam = new com.wechat.pay.java.core.notification.RequestParam.Builder()
                .serialNumber(serial)
                .nonce(nonce)
                .signature(signature)
                .timestamp(timestamp)
                .signType(signType)
                .body(body)
                .build();

        // 初始化 NotificationParser
        NotificationParser parser = new NotificationParser(wechatV3Config.getWechatPayConfig());

        // 以支付通知回调为例，验签、解密并转换成 Transaction
        Transaction transaction = parser.parse(requestParam, Transaction.class);

        QueryOrderByOutTradeNoRequest queryRequest = new QueryOrderByOutTradeNoRequest();
        queryRequest.setMchid(wechatV3Config.getMchId());
        queryRequest.setOutTradeNo(transaction.getOutTradeNo());
        JsapiService jsapiService = new JsapiService.Builder().config(wechatV3Config.getWechatPayConfig()).build();
        Transaction order = jsapiService.queryOrderByOutTradeNo(queryRequest);
        if(predicate!=null){
            if(predicate.test(order)){
                return NotifyResponse.success();
            }else{
                log.warn("order state verify error:{}",order);
                return NotifyResponse.fail("order state "+order.getTradeState().toString());
            }
        }else{
            log.warn("predicate was null verify error:{}",order);
            return NotifyResponse.fail("order state "+order.getTradeState().toString());
        }

    }

}
