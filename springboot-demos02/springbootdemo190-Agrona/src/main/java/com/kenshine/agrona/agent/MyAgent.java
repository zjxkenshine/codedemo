package com.kenshine.agrona.agent;

import org.agrona.concurrent.Agent;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/20 9:46
 * @description：自定义Agent
 * @modified By：
 * @version: $
 */
public class MyAgent implements Agent {
    @Override
    public int doWork() throws Exception {
        System.out.println("kenshine");
        //返回0以上不会执行空闲策略
        return 0;
    }

    @Override
    public String roleName() {
        //角色名称
        return "kenshine";
    }
}
