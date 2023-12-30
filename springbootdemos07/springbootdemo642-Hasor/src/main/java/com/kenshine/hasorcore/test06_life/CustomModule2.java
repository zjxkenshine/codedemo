package com.kenshine.hasorcore.test06_life;

import lombok.extern.slf4j.Slf4j;
import net.hasor.core.ApiBinder;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.Module;

/**
 * @author by kenshine
 * @Classname CustomModule2
 * @Description module生命周期，事件机制
 * @Date 2023-12-30 13:59
 * @modified By：
 * @version: 1.0$
 */
@Slf4j
public class CustomModule2 implements Module {
    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        log.info("初始化拉...");
    }

    @Override
    public void onStart(AppContext appContext) throws Throwable {
        log.info("启动啦...");
    }

    @Override
    public void onStop(AppContext appContext) throws Throwable {
        log.info("停止啦...");
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new CustomModule2());
    }
}
