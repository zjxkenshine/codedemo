package com.kenshine.pattern3.command;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 命令模式
 * @Author: kenshine
 *
 * 命令模式使用场景：
 * 系统需要将请求调用者和请求接收者解耦，使得调用者和接收者不直接交互。
 * 系统需要在不同的时间指定请求、将请求排队和执行请求。
 * 系统需要支持命令的撤销(Undo)操作和恢复(Redo)操作
 */
public class Client {
    public static void main(String[] args) {
        //创建第一个订单对象
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFood("西红柿鸡蛋面",1);
        order1.setFood("小杯可乐",2);

        //创建第二个订单对象
        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFood("尖椒肉丝盖饭",1);
        order2.setFood("小杯雪碧",1);

        //创建厨师对象
        SeniorChef receiver = new SeniorChef();
        //创建命令对象
        OrderCommand cmd1 = new OrderCommand(receiver,order1);
        OrderCommand cmd2 = new OrderCommand(receiver,order2);

        //创建调用者（服务员对象）
        Waitor invoke = new Waitor();
        invoke.setCommand(cmd1);
        invoke.setCommand(cmd2);

        //让服务员发起命令
        invoke.orderUp();
    }
}
