package com.kenshine.pattern3.template;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description:  模板方法模式测试类
 * @Author: kenshine
 *
 * 类行为模式
 *
 * 适用：
 * 算法的整体步骤很固定，但其中个别部分易变时，这时候可以使用模板方法模式，将容易变的部分抽象出来，供子类实现。
 * 需要通过子类来决定父类算法中某个步骤是否执行，实现子类对父类的反向控制。
 *
 * 缺点：
 * 对每个不同的实现都需要定义一个子类，这会导致类的个数增加，系统更加庞大，设计也更加抽象。
 * 父类中的抽象方法由子类实现，子类执行的结果会影响父类的结果，这导致一种反向的控制结构，它提高了代码阅读的难度
 *
 */
public class Client {
    public static void main(String[] args) {
        //炒包菜
        //创建对象
        ConcreteClass_BaoCai baoCai = new ConcreteClass_BaoCai();
        //调用炒菜的功能
        baoCai.cookProcess();
    }
}
