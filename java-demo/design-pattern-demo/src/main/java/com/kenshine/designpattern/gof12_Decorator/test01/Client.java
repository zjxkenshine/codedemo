package com.kenshine.designpattern.gof12_Decorator.test01;

import com.kenshine.designpattern.gof12_Decorator.test01.house.BigHouse;
import com.kenshine.designpattern.gof12_Decorator.test01.house.House;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/12 21:05
 * @description：装饰器模式测试
 * @modified By：
 * @version: $
 */
public class Client {
    public static void main(String[] args) {
        House bigHouse = new BigHouse();
        House decorator = new Decorator(bigHouse);
        decorator.output();
    }
}
