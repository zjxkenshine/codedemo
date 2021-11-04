package com.kenshine.pattern3.state.before;

/**
 * @version v1.0
 * @ClassName: ILift
 * @Description: 电梯接口
 * @Author: kenshine
 */
public interface ILift {

    /** 定义四个电梯状态的常量*/
    int OPENING_STATE = 1;
    int CLOSING_STATE = 2;
    int RUNNING_STATE = 3;
    int STOPPING_STATE = 4;

    /** 设置电梯状态的功能
     * @param state 状态
     */
    void setState(int state);

    /**开启 */
    void open();

    /**关闭 */
    void close();

    /**运行 */
    void run();

    /**停止 */
    void stop();
}
