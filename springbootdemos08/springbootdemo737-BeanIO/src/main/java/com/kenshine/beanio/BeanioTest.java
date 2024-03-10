package com.kenshine.beanio;

import com.kenshine.beanio.model.*;
import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.FieldBuilder;
import org.beanio.builder.RecordBuilder;
import org.beanio.builder.StreamBuilder;
import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * @author by kenshine
 * @Classname BeanioTest
 * @Description beanio使用测试
 * @Date 2024-03-10 8:28
 * @modified By：
 * @version: 1.0$
 */
public class BeanioTest {

    /**
     * 从CSV中读取
     */
    @Test
    public void test01(){
        StreamFactory factory = StreamFactory.newInstance();
        factory.load("src/main/resources/config/employee1.xml");
        try (BeanReader in = factory.createReader("employeeFile", new File("src/main/resources/csv/employee.csv"))) {
            Employee employee;
            while ((employee = (Employee) in.read()) != null) {
                System.out.println(employee);
            }
        }
    }

    /**
     * 写入CSV
     */
    @Test
    public void test02(){
        StreamFactory factory = StreamFactory.newInstance();
        // 加载mapping文件
        factory.load("src/main/resources/config/employee1.xml");

        Employee employee = new Employee();
        employee.setFirstName("Jennifer");
        employee.setLastName("Jones");
        employee.setTitle("Marketing");
        employee.setSalary(60000);
        employee.setHireDate(new Date());

        // 创建BeanWriter
        try (BeanWriter out = factory.createWriter("employeeFile", new File("src/main/resources/csv/employee1.csv"))) {
            // 写入employee到BeanWriter
            out.write(employee);
            out.flush();
        }
    }

    /**
     * 写入嵌套bean
     */
    @Test
    public void test03(){
        StreamFactory factory = StreamFactory.newInstance();
        // 加载mapping文件
        factory.load("src/main/resources/config/employee2.xml");
        Address address=new Address();
        address.setCity("hangzhou");
        address.setState("1");
        address.setStreet("2");
        address.setZip("3");

        Employee2 employee = new Employee2();
        employee.setFirstName("kenshine");
        employee.setLastName("k");
        employee.setTitle("1234");
        employee.setSalary(60000);
        employee.setMailingAddress(address);
        employee.setHireDate(new Date());

        // 创建BeanWriter
        try (BeanWriter out = factory.createWriter("employeeFile", new File("src/main/resources/csv/employee2.csv"))) {
            // 写入employee到BeanWriter
            out.write(employee);
            out.flush();
        }
    }

    /**
     * 读取嵌套bean
     */
    @Test
    public void test04(){
        StreamFactory factory = StreamFactory.newInstance();
        factory.load("src/main/resources/config/employee2.xml");
        try (BeanReader in = factory.createReader("employeeFile", new File("src/main/resources/csv/employee2.csv"))) {
            Employee2 employee;
            while ((employee = (Employee2) in.read()) != null) {
                System.out.println(employee);
            }
        }
    }

    /**
     * 读取xml
     */
    @Test
    public void test05(){
        StreamFactory factory = StreamFactory.newInstance();
        factory.load("src/main/resources/config/employee.xml");
        try (BeanReader in = factory.createReader("employeeFile", new File("src/main/resources/xml/employee.xml"))) {
            Employee employee;
            while ((employee = (Employee) in.read()) != null) {
                System.out.println(employee);
            }
        }
    }

    /**
     * StreamBuilder 构建stream对象
     */
    @Test
    public void test06(){
        StreamFactory factory = StreamFactory.newInstance();

        // Streambuilder
        StreamBuilder builder = new StreamBuilder("employeeFile")
                .format("delimited")
                .parser(new DelimitedParserBuilder(','))
                .addRecord(new RecordBuilder("employee")
                        .type(Employee.class)
                        .minOccurs(1)
                        //.addField(new FieldBuilder("type").rid().literal("EMP").ignore())
                        //.addField(new FieldBuilder("recordType").rid().literal("firstName"))
                                .addField(new FieldBuilder("firstName"))
                                .addField(new FieldBuilder("lastName"))
                                .addField(new FieldBuilder("title"))
                                .addField(new FieldBuilder("salary"))
                                .addField(new FieldBuilder("hireDate").format("MMddyyyy")));

        factory.define(builder);

        try (BeanReader in = factory.createReader("employeeFile", new File("src/main/resources/csv/employee.csv"))) {
            Employee employee;
            while ((employee = (Employee) in.read()) != null) {
                System.out.println(employee);
            }
        }
    }

    /**
     * 注解，StreamBuilder方式
     */
    @Test
    public void test07(){
        StreamFactory factory = StreamFactory.newInstance();

        StreamBuilder builder = new StreamBuilder("employeeFile")
                .format("delimited")
                .parser(new DelimitedParserBuilder(','))
                .addRecord(Employee3.class);
        factory.define(builder);
        try (BeanReader in = factory.createReader("employeeFile", new File("src/main/resources/csv/employee3.csv"))) {
            Employee3 employee;
            while ((employee = (Employee3) in.read()) != null) {
                System.out.println(employee);
            }
        }
    }

    /**
     * 注解，xml方式
     */
    @Test
    public void test08(){
        StreamFactory factory = StreamFactory.newInstance();
        factory.load("src/main/resources/config/employee3.xml");
        try (BeanReader in = factory.createReader("employeeFile", new File("src/main/resources/csv/employee3.csv"))) {
            Employee3 employee;
            while ((employee = (Employee3) in.read()) != null) {
                System.out.println(employee);
            }
        }
    }


    /**
     * 表头表尾
     */
    @Test
    public void test09(){
        StreamFactory factory = StreamFactory.newInstance();
        factory.load("src/main/resources/config/employee4.xml");
        try (BeanReader in = factory.createReader("employeeFile", new File("src/main/resources/csv/employee4.csv"))) {
            Object obj;
            Employee4 employee;
            Header header;
            Trailer trailer;
            while ((obj = in.read()) != null) {
                if (obj instanceof Header) {
                    header = (Header) obj;
                    System.out.println(header);
                } else if (obj instanceof Employee4) {
                    employee = (Employee4) obj;
                    System.out.println(employee);
                } else if (obj instanceof Trailer) {
                    trailer = (Trailer) obj;
                    System.out.println(trailer);
                }
            }
        }
    }
}
