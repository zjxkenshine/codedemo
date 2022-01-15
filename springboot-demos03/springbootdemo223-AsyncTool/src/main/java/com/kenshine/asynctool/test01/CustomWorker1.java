package com.kenshine.asynctool.test01;

import com.jd.platform.async.callback.ICallback;
import com.jd.platform.async.callback.IWorker;
import com.jd.platform.async.worker.WorkResult;
import com.jd.platform.async.wrapper.WorkerWrapper;
import com.kenshine.asynctool.domain.User;

import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 10:55
 * @description：自定义任务1
 * @modified By：
 * @version: $
 */
public class CustomWorker1 implements IWorker<String,User>, ICallback<String, User> {

    /**
     * 回调处理
     */
    @Override
    public void result(boolean b, String s, WorkResult<User> workResult) {
        System.out.println("worker1 的结果是：" + workResult.getResult());
    }

    /**
     * 模拟的耗时任务
     */
    @Override
    public User action(String s, Map<String, WorkerWrapper> map) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new User("user1");
    }

    /**
     * 默认值
     */
    @Override
    public User defaultValue() {
        return new User("default User");
    }

    @Override
    public void begin() {
        //System.out.println(Thread.currentThread().getName() + "- start --" + System.currentTimeMillis());
    }
}
