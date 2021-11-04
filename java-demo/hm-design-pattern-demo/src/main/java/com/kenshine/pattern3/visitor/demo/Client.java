package com.kenshine.pattern3.visitor.demo;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 访问者模式  不同的人喂食猫狗
 * @Author: kenshine
 *
 * 优点：
 *  扩展性好，复用性好，分离无关行为
 *
 *  缺点：
 *  对象结构变化很困难，违反了依赖倒置原则
 *
 *  使用场景
 *  对象结构相对稳定，但其操作算法经常变化的程序
 *  对象结构中的对象需要提供多种不同且不相关的操作，而且要避免让这些操作的变化影响对象的结构
 *
 */
public class Client {
    public static void main(String[] args) {
        //创建Home对象
        Home home = new Home();
        //添加元素到Home对象中
        home.add(new Dog());
        home.add(new Cat());

        //创建主人对象
        Owner owner = new Owner();
        //让主人喂食所有的宠物
        home.action(owner);
    }
}
