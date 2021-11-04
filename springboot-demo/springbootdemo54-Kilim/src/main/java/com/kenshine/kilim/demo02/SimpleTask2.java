package com.kenshine.kilim.demo02;

import kilim.ExitMsg;
import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 9:48
 * @description：测试2
 * @modified By：
 * @version: $
 */
public class SimpleTask2 extends Task{
    static Mailbox<String> mb = new Mailbox<>();
    static Mailbox<ExitMsg> exitmb = new Mailbox<>();

    public static void main(String[] args) throws Exception {
        if (kilim.tools.Kilim.trampoline(false,args)) return;
        Task t = new SimpleTask2().start();
        t.informOnExit(exitmb);
        mb.putnb("Hello ");
        mb.putnb("World\n");
        mb.putnb("done");

        exitmb.getb();
        System.exit(0);
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
        Task.exit(0); // Strictly optional.
    }

}
