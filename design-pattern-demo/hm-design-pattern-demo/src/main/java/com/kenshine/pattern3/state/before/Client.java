package com.kenshine.pattern3.state.before;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 测试(未用状态模式之前)
 * @Author: kenshine
 */
public class Client {
    public static void main(String[] args) {
        //创建电梯对象
        Lift lift = new Lift();

        //设置当前电梯的状态
        lift.setState(ILift.RUNNING_STATE);

        //打开
        lift.open();
        lift.close();
        lift.run();
        lift.stop();
    }
}
