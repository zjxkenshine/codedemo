package com.kenshine.jcommander.demo09;

import com.beust.jcommander.JCommander;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:39
 * @description： 参数委托
 * @modified By：
 * @version: $
 */
public class demo09 {
    public static void main(String[] args) {
        MainParams p = new MainParams();
        JCommander.newBuilder().addObject(p).build()
                .parse("-v", "-port", "1234");

        System.out.println(p);
    }
}
