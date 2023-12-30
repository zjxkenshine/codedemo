package com.kenshine.hasorcore.test06_life;

import lombok.extern.slf4j.Slf4j;
import net.hasor.core.ApiBinder;
import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.Module;
import net.hasor.core.spi.ContextInitializeListener;
import net.hasor.core.spi.ContextShutdownListener;
import net.hasor.core.spi.ContextStartListener;

/**
 * @author by kenshine
 * @Classname CustomModule
 * @Description module生命周期 SPI机制 更多节点
 * @Date 2023-12-30 13:57
 * @modified By：
 * @version: 1.0$
 */
@Slf4j
public class CustomModule implements Module {

    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {

        apiBinder.bindSpiListener(ContextInitializeListener.class, new ContextInitializeListener() {
            @Override
            public void doInitializeCompleted(AppContext templateAppContext) {
                log.info("初始化完成啦...");
            }
        });

        apiBinder.bindSpiListener(ContextStartListener.class, new ContextStartListener() {
            @Override
            public void doStart(AppContext appContext) {
                log.info("开始启动啦...");
            }
            @Override
            public void doStartCompleted(AppContext appContext) {
                log.info("启动完成啦...");
            }
        });

        apiBinder.bindSpiListener(ContextShutdownListener.class, new ContextShutdownListener() {
            @Override
            public void doShutdown(AppContext appContext) {
                log.info("开始停止啦...");
            }
            @Override
            public void doShutdownCompleted(AppContext appContext) {
                log.info("停止完成啦...");
            }
        });
    }

    public static void main(String[] args) {
        AppContext appContext = Hasor.create().build(new CustomModule());
    }
}
