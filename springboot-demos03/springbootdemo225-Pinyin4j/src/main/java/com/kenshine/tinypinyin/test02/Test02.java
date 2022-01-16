package com.kenshine.tinypinyin.test02;

import com.github.promeg.pinyinhelper.Pinyin;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 12:38
 * @description：
 * @modified By：
 * @version: $
 */
public class Test02 {

    public static String convertToPinyin(String src) {
        char[] t1 = null;
        t1 = src.toCharArray();
        String t4 = "";
        int t0 = t1.length;
        for (int i = 0; i < t0; i++) {
            // 判断是否为汉字字符
            if (java.lang.Character.toString(t1[i]).matches(
                    "[\\u4E00-\\u9FA5]+")) {
                t4 += Pinyin.toPinyin(t1[i]);
            } else{
                t4 += java.lang.Character.toString(t1[i]);
            }
        }
        return t4;
    }

    public static void main(String[] args) {
        System.out.println(convertToPinyin("这里是Kenshine"));
    }

}
