package com.kenshine.kilim.demo02;

import kilim.ExitMsg;
import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 9:50
 * @description：示例3
 * @modified By：
 * @version: $
 *
 * 定时执行
 */
public class TimedTask extends Task {

    public static void main(String[] args) {
        if (kilim.tools.Kilim.trampoline(false,args)) return;

        int numTasks = (args.length > 0) ? Integer.parseInt(args[0]) : 100;
        Mailbox<ExitMsg> exitmb= new Mailbox<> ();

        for (int i = 0; i < numTasks; i++) {
            new TimedTask().start().informOnExit(exitmb);
        }

        for (int i = 0; i < numTasks; i++) {
            exitmb.getb();
        }

        System.exit(0);
    }

    public void execute() throws Pausable {
        System.out.println("Task #" + id() + " going to sleep ...");
        Task.sleep(2000);
        System.out.println("           Task #" + id() + " waking up");
    }
}
