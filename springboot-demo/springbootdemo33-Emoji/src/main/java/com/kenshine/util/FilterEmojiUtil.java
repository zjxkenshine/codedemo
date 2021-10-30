package com.kenshine.util;

import org.springframework.util.StringUtils;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 14:01
 * @description：
 * @modified By：
 * @version: $
 */
public class FilterEmojiUtil {
    /**
     * emoji表情替换
     *
     * @param source 原字符串
     * @param slipStr emoji表情替换成的字符串
     * @return 过滤后的字符串
     */
    public static String filterEmoji(String source,String slipStr) {
        if(!StringUtils.isEmpty(source)){
            return source.replaceAll("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]", slipStr);
        }else{
            return source;
        }
    }
    /**
     * 判断是否包含emoji表情
     *
     * @param source 原字符串
     * @paramslipStr emoji表情替换成的字符串
     * @return 过滤后的字符串
     */
    public static boolean checkEmoji(String source) {
        if(!StringUtils.isEmpty(source)){
            return  source.matches("[\\ud800\\udc00-\\udbff\\udfff\\ud800-\\udfff]");
        }else{
            return false;
        }
    }
}
