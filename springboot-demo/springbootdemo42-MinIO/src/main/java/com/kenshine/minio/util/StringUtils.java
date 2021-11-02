package com.kenshine.minio.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 9:40
 * @description：字符串工具
 * @modified By：
 * @version: $
 */
public class StringUtils {
    private StringUtils(){}
    //判断是否为空字符串或null
    public static boolean isNull(String str){
        return StringUtils.isNullRef(str);
    }

    //不为空字符串或null
    public static boolean isNotNull(String str){
        return !isNull(str);
    }

    //全为空
    public static boolean hasNull(String... strings){
        for(String str:strings){
            if(isNull(str)){
                return true;
            }
        }
        return false;
    }

    //字符串为null或空字符串设置为默认值
    public static String ifNullToString(String str,String defaultStr){
        if(isNullRef(str)){
            return defaultStr;
        }
        return str;
    }

    //null转空字符串
    public static String ifNullToString(String str){
        return ifNullToString(str,"");
    }

    //判断是否为空
    private static boolean isNullRef(String str){
        return str==null||"".equals(str);
    }

    //路径字符串转换
    public static String pathParse(String str){
        //防止转义
        return str.replaceAll("/", Matcher.quoteReplacement(File.separator));
    }

    //获取需要移除的图片信息
    public static List<String> getDiff(List<String> urls, List<String> urls2){
        List<String> newUrls=new ArrayList<>(urls);
        newUrls.removeIf(urls2::contains);
        return newUrls;
    }

    //获取需要移除的图片信息
    public static List<String> getSame(List<String> urls,List<String> urls2){
        urls.removeIf((url)->!urls2.contains(url));
        return urls;
    }

}
