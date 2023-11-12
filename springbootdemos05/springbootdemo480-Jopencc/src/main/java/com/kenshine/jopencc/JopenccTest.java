package com.kenshine.jopencc;

import jopencc.Convertor;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/12 22:48
 * @description：转换测试
 * @modified By：
 * @version: $
 */
public class JopenccTest {
    @Test
    public void test(){
        // 转简体
        System.out.println((new Convertor()).convertToZhs("開放中文轉換"));
        // 转繁体
        System.out.println((new Convertor()).convertToZht("开放中文转换"));
    }
}
