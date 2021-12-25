package com.kenshine.jcommander.demo01;

import com.beust.jcommander.JCommander;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:19
 * @description：基本使用
 * @modified By：
 * @version: $
 */
public class demo01 {
    public static void main(String[] args) {
        Args arg = new Args();
        //模拟传入的args
        String[] argv = { "-log", "2", "-groups", "unit" };
        JCommander.newBuilder()
                .addObject(arg)
                .build()
                .parse(argv);
        System.out.println(arg);
    }
}
