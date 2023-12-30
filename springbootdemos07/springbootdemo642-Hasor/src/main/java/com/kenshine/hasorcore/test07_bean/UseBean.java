package com.kenshine.hasorcore.test07_bean;

import net.hasor.core.Inject;
import net.hasor.core.Type;

/**
 *
 * @author kenshine
 */
public class UseBean {
    /**
     * id
     */
    @Inject(value = "beanA" , byType = Type.ByID)
    private InfoBean pojoA;
    @Inject(value = "beanB" , byType = Type.ByID)
    private InfoBean pojoB;
    /**
     *  name
     */
    @Inject("user")
    private InfoBean pojoC;
    @Inject("data")
    private InfoBean pojoD;
}