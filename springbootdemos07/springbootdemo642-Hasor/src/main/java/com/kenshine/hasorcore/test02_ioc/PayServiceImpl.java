package com.kenshine.hasorcore.test02_ioc;

import net.hasor.core.AppContext;
import net.hasor.core.Hasor;

/**
 * @author by kenshine
 * @Classname PayServiceImpl
 * @Description 接口注入实现
 * @Date 2023-12-30 10:12
 * @modified By：
 * @version: 1.0$
 */
public class PayServiceImpl implements PayService{
    @Override
    public void pay() {
        System.out.println("PayServiceImpl");
    }

    public static void main(String[] args) {
        // 代码方式声明实现类
        AppContext appContext = Hasor.create().build(apiBinder -> {
            apiBinder.bindType(PayService.class).to(PayServiceImpl.class);
        });
    }
}
