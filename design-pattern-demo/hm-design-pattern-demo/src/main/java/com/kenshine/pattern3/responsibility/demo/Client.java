package com.kenshine.pattern3.responsibility.demo;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 责任链模式
 * @Author: kenshine
 *
 *
 *优点
 * 解耦，易扩展
 * 责任链简化了对象之间的连接
 * 责任分担:每个类只需要处理自己该处理的工作
 *
 * 缺点：
 *  不能保证每个请求一定被处理
 *  对比较长的职责链，请求的处理可能涉及多个处理对象，系统性能将受到一定影响
 *  职责链建立的合理性要靠客户端来保证
 */
public class Client {
    public static void main(String[] args) {
        //创建一个请假条对象
        LeaveRequest leave = new LeaveRequest("小明",7,"身体不适");

        //创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();

        //设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);


        //小明提交请假申请
        groupLeader.submit(leave);
    }
}
