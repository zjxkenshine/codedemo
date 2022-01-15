package com.kenshine.asynctool.test01;

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
public class CustomWorker3 implements IWorker<WorkResult<User>, String>, ICallback<WorkResult<User>, String> {
    @Override
    public String action(WorkResult<User> result, Map<String, WorkerWrapper> allWrappers) {
        System.out.println("worker3的入参来自于worker2： " + result.getResult());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result.getResult().getName();
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
    public void result(boolean success, WorkResult<User> param, WorkResult<String> workResult) {
        System.out.println("worker3 的结果是：" + workResult.getResult());
    }
}
