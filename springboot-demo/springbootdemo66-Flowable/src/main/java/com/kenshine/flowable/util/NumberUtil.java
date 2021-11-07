package com.kenshine.flowable.util;

import java.util.Date;
import java.util.Random;

/**
 * 自定义编号工具类
 * @author: kenshine
 * @create: 2019-05-06 11:27
 * @throw
 **/
public class NumberUtil {

    /**
     * 根据传入位数生成随机数
     * @param length
     * @return
     */
    public static String random(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            val += String.valueOf(random.nextInt(10));
        }
        return val;
    }

    /**
     * 根据最大位数字加一，返回生成相同位数的字符串
     * @param max
     * @return
     */
    public static String maxNumber(String max) {
        try {
            Integer len = max.length();
            Integer number = Integer.valueOf(max) + 1;
            max = number.toString();
            len = len - max.length();
            for (int i = 0; i < len; i ++) {
                max = "0" + max;
            }
        } catch (Exception e) {
            return null;
        }
        return max;
    }

    /**
     * 生成申请单编号
     * @return
     */
    public static String formNumber() {
        return "PGB" + DateUtils.getDateFormat(new Date(), "yyyyMMddHHmmss") + random(3);
    }

}
