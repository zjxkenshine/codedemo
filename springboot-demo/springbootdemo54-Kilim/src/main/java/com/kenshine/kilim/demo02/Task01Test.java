package com.kenshine.kilim.demo02;

import kilim.Mailbox;

import java.util.concurrent.TimeUnit;

import static kilim.Task.idledown;
import static kilim.Task.sleep;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 9:39
 * @description：bug测试
 * @modified By：
 * @version: $
 */
public class Task01Test {

    public static void main(String[] args) throws Exception {
        if (kilim.tools.Kilim.trampoline(false,args)) return;
        Mailbox<String> mb = new Mailbox<>();
        mb.putnb("Hello ");
        mb.putnb("World\n");
        mb.putnb("done");
        new Task01(mb).start();
        Thread.sleep(100);
        idledown();
    }

}
