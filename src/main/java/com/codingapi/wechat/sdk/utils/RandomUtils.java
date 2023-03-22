package com.codingapi.wechat.sdk.utils;

import java.util.Random;

public class RandomUtils {


    // 随机生成16位字符串
    public static String getRandomStr() {
        return getRandomStr(16);
    }

    public static String getRandomStr(int length) {
        String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
