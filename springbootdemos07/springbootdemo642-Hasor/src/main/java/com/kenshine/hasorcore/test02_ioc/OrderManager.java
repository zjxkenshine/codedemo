package com.kenshine.hasorcore.test02_ioc;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;
import net.hasor.core.spi.InjectMembers;

/**
 * InjectMembers自动注入
 * @author kenshine
 */
public class OrderManager implements InjectMembers {
    public FunBean funBean;

    @Override
    public void doInject(AppContext appContext) throws Throwable {
        System.out.println("自动注入");
        funBean.call();
    }

    public static void main(String[] args) throws Throwable {
        AppContext appContext = Hasor.create().build();
        InjectMembers myBean = appContext.getInstance(OrderManager.class);
        myBean.doInject(appContext);
    }
}