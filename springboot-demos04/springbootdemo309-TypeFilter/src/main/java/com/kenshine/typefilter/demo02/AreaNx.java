package com.kenshine.typefilter.demo02;

import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 9:16
 * @description：
 * @modified By：
 * @version: $
 */
@Areaed("nx")
@Component("area")
public class AreaNx implements IArea{

    public AreaNx() {
        System.out.println("AreaNx被注册了");
    }

    @Override
    public void say() {
        System.out.println("宁夏");
    }
}
