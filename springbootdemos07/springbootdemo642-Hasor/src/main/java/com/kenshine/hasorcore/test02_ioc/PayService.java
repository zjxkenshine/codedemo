package com.kenshine.hasorcore.test02_ioc;

import net.hasor.core.ImplBy;

/**
 * @author by kenshine
 * @Classname PayService
 * @Description 接口注入
 * @Date 2023-12-30 10:11
 * @modified By：
 * @version: 1.0$
 */
@ImplBy(PayServiceImpl.class)
public interface PayService {
    void pay();
}
