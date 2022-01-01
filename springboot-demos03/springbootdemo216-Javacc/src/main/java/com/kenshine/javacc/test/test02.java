package com.kenshine.javacc.test;

import com.kenshine.javacc.demo02.Adder;
import com.kenshine.javacc.demo02.ParseException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 12:28
 * @description：累加，文件输入方式
 * @modified By：
 * @version: $
 */
public class test02 {
    /**
     * demo 2生成的解释器 判断是否是合法加法
     * 在system.in 中正确输入形式如 1 + 1 + 2
     * 否则报错，没有计算
     */
    public static void main(String[] args) throws ParseException {
        Adder.main(null);
    }
}
