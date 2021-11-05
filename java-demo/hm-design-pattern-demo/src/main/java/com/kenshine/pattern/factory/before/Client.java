package com.kenshine.pattern.factory.before;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 测试类
 * @Author: 黑马程序员
 */
public class Client {
    public static void main(String[] args) {
        //1,创建咖啡店类
        CoffeeStore store = new CoffeeStore();
        //2,点咖啡
        Coffee coffee = store.orderCoffee("american");

        System.out.println(coffee.getName());
    }
}
