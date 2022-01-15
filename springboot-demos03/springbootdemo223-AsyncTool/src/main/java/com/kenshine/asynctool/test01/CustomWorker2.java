package com.kenshine.asynctool.test01;

import com.jd.platform.async.callback.ICallback;
import com.jd.platform.async.callback.IWorker;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;
import com.kenshine.asynctool.domain.User;

import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 10:59
 * @description：
 * @modified By：
 * @version: $
 */
public class CustomWorker2 implements IWorker<WorkResult<User>, User>, ICallback<WorkResult<User>, User> {

    @Override
    public User action(WorkResult<User> result, Map<String, WorkerWrapper> allWrappers) {
        System.out.println("worker2的入参来自于worker1： " + result.getResult());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User("user1");
    }


    @Override
    public User defaultValue() {
        return new User("default User");
    }

    @Override
    public void begin() {
        //System.out.println(Thread.currentThread().getName() + "- start --" + System.currentTimeMillis());
    }

    @Override
    public void result(boolean success, WorkResult<User> param, WorkResult<User> workResult) {
        System.out.println("worker2 的结果是：" + workResult.getResult());
    }
}
