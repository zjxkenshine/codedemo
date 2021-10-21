package com.kenshine.pattern3.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ClassName: Waitor
 * @Description: 服务员类（属于请求者角色）
 * @Author: kenshine
 */
public class Waitor {

    /**持有多个命令对象*/
    private List<Command> commands = new ArrayList<>();

    public void setCommand(Command cmd) {
        //将cmd对象存储到list集合中
        commands.add(cmd);
    }

    /**发起命令功能  喊 订单来了*/
    public void orderUp() {
        System.out.println("美女服务员：大厨，新订单来了。。。。");
        //遍历list集合
        for (Command command : commands) {
           if(command != null) {
               command.execute();
           }
        }
    }
}
