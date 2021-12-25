package com.kenshine.jcommander.demo07;

import com.beust.jcommander.JCommander;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:10
 * @description：
 * @modified By：
 * @version: $
 */
public class demo07 {
    public static void main(String[] args) {
        ArgsMaster m = new ArgsMaster();
        ArgsSlave s = new ArgsSlave();
        String[] argv = { "-master", "master", "-slave", "slave" };
        JCommander.newBuilder()
                .addObject(new Object[] { m , s })
                .build()
                .parse(argv);

        System.out.println(m);
        System.out.println(s);
    }
}
