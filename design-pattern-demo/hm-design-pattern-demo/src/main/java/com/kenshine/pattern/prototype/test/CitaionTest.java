package com.kenshine.pattern.prototype.test;

/**
 * @version v1.0
 * @ClassName: CitaionTest
 * @Description: 浅克隆测试
 * @Author: 黑马程序员
 */
public class CitaionTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //1，创建原型对象
        Citation citation = new Citation();
        //创建张三学生对象
        Student stu = new Student();
        stu.setName("张三");
        citation.setStu(stu);

        //2,克隆奖状对象
        Citation citation1 = citation.clone();

        //浅克隆，修改stu1属性值也会修改stu的值
        Student stu1 = citation1.getStu();
        stu1.setName("李四");

        /*citation.setName("张三");
        citation1.setName("李四");*/

        //3,调用show方法展示
        citation.show();
        citation1.show();
    }
}
