package com.kenshine.kilim.demo02;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 9:38
 * @description：简单Task
 * @modified By：
 * @version: $
 */
public class SimpleTask extends Task {
    static Mailbox<String> mb = new Mailbox<>();

    public static void main(String[] args) throws Exception {
        if (kilim.tools.Kilim.trampoline(false,args)) return;
        new SimpleTask().start();
        Thread.sleep(10);
        mb.putnb("Hello ");
        mb.putnb("World\n");
        mb.putnb("done");
        idledown();
    }

    /**
     * The entry point. mb.get() is a blocking call that yields
     * the thread ("pausable")
     */

    public void execute() throws Pausable {
        while (true) {
            String s = mb.get();
            if (s.equals("done")) break;
            System.out.print(s);
        }

    }
}
