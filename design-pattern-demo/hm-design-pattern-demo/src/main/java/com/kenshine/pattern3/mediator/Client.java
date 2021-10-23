package com.kenshine.pattern3.mediator;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 中介者模式 测试类
 * @Author: kenshine
 *
 * 优点：
 * 松散耦合，集中控制交互，一对多关联转变为一对一的关联
 *
 * 缺点：
 * 当同事类太多时，中介者的职责将很大，它会变得复杂而庞大，以至于系统难以维护
 *
 * 使用场景：
 * 系统中对象之间存在复杂的引用关系，系统结构混乱且难以理解
 * 当想创建一个运行于多个类之间的对象，又不想生成新的子类时
 *
 */
public class Client {
    public static void main(String[] args) {
        //创建中介者对象
        MediatorStructure mediator = new MediatorStructure();

        //创建租房者对象
        Tenant tenant = new Tenant("李四",mediator);
        //创建房主对象
        HouseOwner houseOwner = new HouseOwner("张三",mediator);

        //中介者要知道具体的房主和租房者
        mediator.setTenant(tenant);
        mediator.setHouseOwner(houseOwner);

        tenant.constact("我要租三室的房子！！！");
        houseOwner.constact("我这里有三室的房子，你要租吗？");
    }
}
