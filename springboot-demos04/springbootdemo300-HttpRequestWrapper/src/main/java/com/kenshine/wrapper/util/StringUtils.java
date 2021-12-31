package com.kenshine.wrapper.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.ReUtil;

import java.util.Collection;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 9:39
 * @description：
 * @modified By：
 * @version: $
 */
public class StringUtils {

    /**
     * * 判断一个对象是否为空
     *
     * @param object 要判断的对象数组
     *                * @return true：为空 false：非空
     */
    public static boolean isEmpty(Object object) {
        return ObjectUtil.isEmpty(object);
    }

    /**
     * * 判断一个对象是否非空
     *
     * @param object 要判断的对象数组
     * @return true：非空 false：空
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    /**
     * 查找指定字符串是否匹配指定字符串列表中的任意一个字符串
     *
     * @param str  指定字符串
     * @param strs 需要检查的字符串数组
     * @return 是否匹配
     */
    public static boolean matches(String str, List<String> strs) {
        if (isEmpty(str) || isEmpty(strs)) {
            return false;
        }
        for (String pattern : strs) {
            if (isMatch(pattern, str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isMatch(String pattern, String url) {
        return ReUtil.isMatch(pattern, url);
    }
}
