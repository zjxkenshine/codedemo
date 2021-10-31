package com.kenshine.sensitive.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 23:31
 * @description：敏感词工具类
 * @modified By：
 * @version: $
 */
public class KeyWordsUtils {

    /**
     * 从文件中构造关键字字符串
     * @param file
     * @return
     */
    public static List<String> loadKeywords(File file) {
        List<String> keyArray = new ArrayList<>();
        try {
            // 构造一个BufferedReader类来读取文件
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s = null;
            // 使用readLine方法，一次读一行
            while ((s = br.readLine()) != null) {
                keyArray.add(s);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return keyArray;
    }


}
