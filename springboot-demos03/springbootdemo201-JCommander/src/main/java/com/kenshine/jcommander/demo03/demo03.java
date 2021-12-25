package com.kenshine.jcommander.demo03;

import com.beust.jcommander.JCommander;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:45
 * @description：
 * @modified By：
 * @version: $
 */
public class demo03 {
    public static void main(String[] args) {
        Args03 arg = new Args03();
        JCommander.newBuilder()
                .addObject(arg)
                .addConverterFactory(new HostPortFactory())
                .build()
                .parse("-hostport", "kenshine.com:8080");
        System.out.println(arg);
    }
}
