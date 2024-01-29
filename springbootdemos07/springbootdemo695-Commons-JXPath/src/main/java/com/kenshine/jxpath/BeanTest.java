package com.kenshine.jxpath;

import com.kenshine.jxpath.model.Address;
import com.kenshine.jxpath.model.Employee;
import com.kenshine.jxpath.model.Formats;
import com.kenshine.jxpath.model.Integers;
import org.apache.commons.jxpath.ClassFunctions;
import org.apache.commons.jxpath.JXPathContext;
import org.junit.Test;

import java.awt.print.Book;
import java.util.Date;
import java.util.Iterator;

/**
 * @author by kenshine
 * @Classname JxpathTest
 * @Description jxpath使用示例 javabean访问
 * @Date 2024-01-29 8:47
 * @modified By：
 * @version: 1.0$
 */
public class BeanTest {

    /**
     * JXPath使用JavaBeans内省来枚举和访问JavaBeans属性
     */
    @Test
    public void test01(){
        Employee emp = new Employee();
        emp.setFirstName("kenshine");
        JXPathContext context = JXPathContext.newContext(emp);
        // 宽松模式，无属性返回null，而不抛异常
        context.setLenient(true);
        String fName = (String)context.getValue("firstName");
        System.out.println(fName);
    }

    /**
     * 获取嵌套对象
     */
    @Test
    public void test02(){
        Employee emp = new Employee();
        emp.setFirstName("kenshine");
        JXPathContext context = JXPathContext.newContext(emp);
        Address address=new Address();
        address.setStreetNumber("12234455");
        emp.setHomeAddress(address);
        // 获取嵌套对象
        String sNumber = (String)context.getValue("homeAddress/streetNumber");
        System.out.println(sNumber);
    }

    /**
     * 从数组和集合中提取元素
     */
    @Test
    public void test03(){
        Integers integers = new Integers(new int[]{1,2,3,4,5});
        JXPathContext context = JXPathContext.newContext(integers);
        Integer thirdInt = (Integer)context.getValue("numbers[3]");
        System.out.println(thirdInt);
    }

    /**
     * 多个结果
     */
    @Test
    public void test04(){
        Integers integers = new Integers(new int[]{1,2,3,4,5});
        JXPathContext context = JXPathContext.newContext(integers);
        // 前3个
        Iterator<Integer> number = context.iterate("numbers[position() < 4]");
        for (Iterator<Integer> it = number; it.hasNext(); ) {
            Integer i = it.next();
            System.out.println(i);
        }
    }

    /**
     * Map访问
     */
    @Test
    public void test05(){
        Employee emp = new Employee();
        JXPathContext context = JXPathContext.newContext(emp);
        // 方式1
        String streetNumber = (String)context.getValue("addresses/home/streetNumber");
        System.out.println(streetNumber);
        // 方式2
        String streetNumber1 = (String)context.getValue("addresses[@name='home']/streetNumber");
        System.out.println(streetNumber1);
    }

    /**
     * 在路径中使用变量
     */
    @Test
    public void test06(){
        Integers integers = new Integers(new int[]{1,2,3,4,5});
        JXPathContext context = JXPathContext.newContext(integers);
        context.getVariables().declareVariable("index", 2);
        Integer num = (Integer) context.getValue("numbers[$index]");
        System.out.println(num);
    }


    /**
     * 标准扩展函数
     * 创建新对象
     */
    @Test
    public void test07(){
        JXPathContext context =JXPathContext.newContext(null);
        Address address = (Address) context.getValue("com.kenshine.jxpath.model.Address.new('aaaa')");
        System.out.println(address.getStreetNumber());
    }

    /**
     * 自定义方法
     */
    @Test
    public void test08(){
        JXPathContext context =JXPathContext.newContext(null);
        context.setFunctions(new ClassFunctions(Formats.class, "format"));
        context.getVariables().declareVariable("today", new Date());
        String today = (String)context.getValue("format:date($today, 'MM/dd/yyyy')");
        System.out.println(today);
    }

}
