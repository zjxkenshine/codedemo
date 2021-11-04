package com.kenshine.pattern3.state.after;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 状态模式改造测试
 * @Author: kenshine
 *
 *
 *
 * 使用场景：
 * - 当一个对象的行为取决于它的状态，并且它必须在运行时根据状态改变它的行为时，就可以考虑使用状态模式。
 * - 一个操作中含有庞大的分支结构，并且这些分支决定于对象的状态时。
 */
public class Client {
    public static void main(String[] args) {
        //创建环境角色对象
        Context context = new Context();
        //设置当前电梯状态
        context.setLiftState(new ClosingState());

        context.open();
        context.run();
        context.close();
        context.stop();
    }
}
