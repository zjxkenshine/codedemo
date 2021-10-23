package com.kenshine.pattern3.iterator;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 迭代器模式测试
 * @Author: kenshine
 *
 *  提供一个对象来顺序访问聚合对象中的一系列数据，而不暴露聚合对象的内部表示
 *
 *  优点：
 *  它支持以不同的方式遍历一个聚合对象，在同一个聚合对象上可以定义多种遍历方式。
 *  迭代器简化了聚合类。
 *  在迭代器模式中，由于引入了抽象层，增加新的聚合类和迭代器类都很方便，无须修改原有代码，满足 “开闭原则” 的要求。
 *
 *  缺点：增加了类个数
 *
 *  使用场景：
 * * 当需要为聚合对象提供多种遍历方式时。
 * * 当需要为遍历不同的聚合结构提供一个统一的接口时。
 * * 当访问一个聚合对象的内容而无须暴露其内部细节的表示时。
 *
 */
public class Client {
    public static void main(String[] args) {
        //创建聚合对象
        StudentAggregateImpl aggregate = new StudentAggregateImpl();
        //添加元素
        aggregate.addStudent(new Student("张三","001"));
        aggregate.addStudent(new Student("李四","002"));
        aggregate.addStudent(new Student("王五","003"));
        aggregate.addStudent(new Student("赵六","004"));

        //遍历聚合对象

        //1,获取迭代器对象
        StudentIterator iterator = aggregate.getStudentIterator();
        //2,遍历
        while(iterator.hasNext()) {
            //3,获取元素
            Student student = iterator.next();
            System.out.println(student.toString());
        }
    }
}
