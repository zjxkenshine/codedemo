package com.kenshine.kilim.demo02;

import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 9:46
 * @description：测试
 * @modified By：
 * @version: $
 *
 * 把上面的simpleTask拆开
 */
public class Task01 extends Task {
    Mailbox<String> mb;

    public Task01(Mailbox<String> box){
        this.mb=box;
    }

    public void execute() throws Pausable {
        while (true) {
            String s = mb.get();
            if (s.equals("done")) break;
            System.out.print(s);
        }

    }
}
