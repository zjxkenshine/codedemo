package com.kenshine.pattern3.strategy;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 策略模式测试
 * @Author: kenshine
 *
 * 策略模式优点：
 * 策略类之间可以自由切换，
 * 易于扩展
 * 避免使用多重条件选择语句（if else），充分体现面向对象设计思想。
 *
 * 缺点：
 * 客户端必须知道所有的策略类，并自行决定使用哪一个策略类。
 * 策略模式将造成产生很多策略类，可以通过使用享元模式在一定程度上减少对象的数量。
 *
 */
public class Client {
    public static void main(String[] args) {
        //春节来了，使用春节促销活动
        SalesMan salesMan = new SalesMan(new StrategyA());
        //展示促销活动
        salesMan.salesManShow();

        System.out.println("==============");
        //中秋节到了，使用中秋节的促销活动
        salesMan.setStrategy(new StrategyB());
        //展示促销活动
        salesMan.salesManShow();

        System.out.println("==============");
        //圣诞节到了，使用圣诞节的促销活动
        salesMan.setStrategy(new StrategyC());
        //展示促销活动
        salesMan.salesManShow();
    }
}
