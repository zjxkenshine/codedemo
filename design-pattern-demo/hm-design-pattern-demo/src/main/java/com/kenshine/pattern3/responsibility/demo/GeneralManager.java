package com.kenshine.pattern3.responsibility.demo;

/**
 * @version v1.0
 * @ClassName: GroupLeader
 * @Description: 总经理类（具体的处理者）
 * @Author: kenshine
 */
public class GeneralManager extends Handler {

    public GeneralManager() {
        super(Handler.NUM_THREE,Handler.NUM_SEVEN);
    }

    @Override
    protected void handleLeave(LeaveRequest leave) {
        System.out.println(leave.getName() + "请假" + leave.getNum() + "天，" + leave.getContent() + "。");
        System.out.println("总经理审批：同意");
    }
}
