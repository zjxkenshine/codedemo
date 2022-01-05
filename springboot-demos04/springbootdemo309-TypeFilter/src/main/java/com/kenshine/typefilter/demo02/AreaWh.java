package com.kenshine.typefilter.demo02;

import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 9:18
 * @description：
 * @modified By：
 * @version: $
 */
@Areaed("wh")
@Component("area")
public class AreaWh implements IArea{

    public AreaWh() {
        System.out.println("AreaWh被注册了");
    }

    @Override
    public void say() {
        System.out.println("武汉");
    }
}
