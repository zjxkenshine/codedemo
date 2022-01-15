package com.kenshine.asynctool.test02;


import com.jd.platform.async.callback.ICallback;
import com.jd.platform.async.callback.IWorker;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;
import com.kenshine.asynctool.domain.User;

import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 11:01
 * @description：
 * @modified By：
 * @version: $
 */
public class DeWorker3 implements IWorker<User, String>, ICallback<User, String> {

    @Override
    public String action(User object, Map<String, WorkerWrapper> allWrappers) {
        System.out.println("-----------------");
        System.out.println("worker2的执行结果是： " + allWrappers.get("second").getWorkResult());
        System.out.println("取worker2的结果作为自己的入参，并将worker2的结果加上一些东西");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        User user1 = (User) allWrappers.get("second").getWorkResult().getResult();
        return user1.getName() + " worker3 add";
    }

    @Override
    public String defaultValue() {
        return "default";
    }

    @Override
    public void begin() {
        //System.out.println(Thread.currentThread().getName() + "- start --" + System.currentTimeMillis());
    }

    @Override
    public void result(boolean success, User param, WorkResult<String> workResult) {
        System.out.println("worker3 的结果是：" + workResult.getResult());
    }

}
