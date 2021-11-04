package com.kenshine.pattern2.facade;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 外观模式测试
 * @Author: kenshine
 *
 * 外观模式不符合开闭原则
 * 为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式
 *
 * 类似Service调用dao
 *
 * 使用场景：
 * * 对分层结构系统构建时，使用外观模式定义子系统中每层的入口点可以简化子系统之间的依赖关系。
 * * 当一个复杂系统的子系统很多时，外观模式可以为系统设计一个简单的接口供外界访问。
 * * 当客户端与多个子系统之间存在很大的联系时，引入外观模式可将它们分离，从而提高子系统的独立性和可移植性
 */
public class Client {
    public static void main(String[] args) {
        //创建智能音箱对象
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        //控制家电
        facade.say("打开家电");

        System.out.println("==================");

        facade.say("关闭家电");
    }
}
