package com.kenshine.kilim.demo03;

import kilim.ExitMsg;
import kilim.Mailbox;
import kilim.Pausable;
import kilim.Task;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 10:02
 * @description：测试
 * @modified By：
 * @version: $
 * 《java程序性能优化中的示例》
 */
public class HelloWorldTask extends Task {
    static Mailbox<String> mb = new Mailbox<>();
    static Mailbox<ExitMsg> exitmb = new Mailbox<>();
    //类型区分 0为接受者，1为发布者
    int type = 0;

    public HelloWorldTask(int type){
        this.type = type;
    }


    public void execute() throws Pausable {
        if (type==0){
            while (true){
                String s = mb.get();
                if(s.equals("over")){
                    break;
                }
                System.out.println(s);
            }
        }else if(type==1){
            mb.putnb("Hello ");
            mb.putnb("World \n");
            mb.putnb("over");
        }
    }


    public static void main(String[] args) {
        if (kilim.tools.Kilim.trampoline(false,args)) return;

        Task sender = new HelloWorldTask(1).start();
        Task receiver = new HelloWorldTask(0).start();
        //接收结束后退出邮箱
        receiver.informOnExit(exitmb);
        //退出邮箱，接受者已经结束
        exitmb.getb();
        System.exit(0);
    }
}
