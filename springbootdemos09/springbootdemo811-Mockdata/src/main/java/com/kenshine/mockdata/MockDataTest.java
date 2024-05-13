package com.kenshine.mockdata;

import idea.verlif.mock.data.MockDataCreator;
import idea.verlif.mock.data.config.DataPool;
import idea.verlif.mock.data.config.FieldDataPool;
import idea.verlif.mock.data.creator.data.DictDataCreator;
import idea.verlif.mock.data.creator.data.DoubleRandomCreator;
import org.junit.Test;
import org.springframework.boot.configurationprocessor.json.JSONObject;

import java.io.IOException;
import java.util.Date;

/**
 * @author by kenshine
 * @Classname MockDataTest
 * @Description 测试数据生成
 * @Date 2024-05-13 11:24
 * @modified By：
 * @version: 1.0$
 */
public class MockDataTest {

    /**
     * 简单用法
     */
    @Test
    public void test01(){
        MockDataCreator creator = new MockDataCreator();
        // 就像new Random.next一样，随机基础类型的数据
        int i = creator.mock(int.class);
        // 随机包装类型
        int inte = creator.mock(Integer.class);
        // 随机数组
        int[] ints = creator.mock(int[].class);
        // 指定数组大小
        int[][] intsArray = creator.mock(new int[2][3]);
        // 随机日期
        Date date = creator.mock(Date.class);
    }

    /**
     * 基础用法
     */
    @Test
    public void test02(){
        // 创建数据构造器
        MockDataCreator creator = new MockDataCreator();
        // 通过类来实例化对象
        Person person = creator.mock(Person.class);
        // 或是手动实例化对象，然后填充数据
        Person thisPerson = new Person();
        creator.mock(thisPerson);
        System.out.println(person);
        // 如果你只要其中的某个属性也可以
        Pet pet = creator.mock(Person::getPet);
        System.out.println(pet);
    }

    /**
     * person.weight 的范围在3-200之间，person.height 的范围在10-260之间
     */
    @Test
    public void test03(){
        MockDataCreator creator = new MockDataCreator();
        creator.getConfig()
                // 设定weight的范围
                .fieldValue(Person::getWeight, new DoubleRandomCreator(3D, 200D))
                // 设定height的范围
                .fieldValue(Person::getHeight, new DoubleRandomCreator(10D, 260D))
                // 如果需要，也可以设定其他double类型的默认范围
                .fieldValue(double.class, new DoubleRandomCreator(0D, 1000D));
        // 开始构建
        Person person = creator.mock(Person.class);
        System.out.println(person);
    }

    /**
     * 对 address 属性填充地址，对 name 填充名称
     */
    @Test
    public void test04(){
        MockDataCreator creator = new MockDataCreator();
        // 使用属性池的方式
        DataPool dataPool = new FieldDataPool()
                // 只对所有的名为name的String属性填充["小明", "小红", "小刚", "小丽"]
                .typeName(String.class, "name", "小明", "小红", "小刚", "小丽")
                .next()
                // 只对所有的名称中带有address的String属性填充["这里", "那里"]
                .likeName(String.class, "address", "这里", "那里")
                .next();
        // 设置属性数据池
        creator.dataPool(dataPool);
        // 与下面的方式类似，但数据池方式更灵活
        creator.fieldValue(Person::getName, new DictDataCreator<>(new String[]{"小明", "小红", "小刚", "小丽"}))
                .fieldValue(Person::getAddress, new DictDataCreator<>(new String[]{"这里", "那里"}));
        // 开始构建
        Person person = creator.mock(Person.class);
        System.out.println(person);
    }

    /**
     * 数据池用法
     */
    @Test
    public void test05() throws IOException {
        // 新建PropertiesDataPool对象
        PropertiesDataPool dataPool = new PropertiesDataPool();
        // 加载配置文件
        dataPool.load("src/main/resources/test.properties");
        // 新建MockDataCreator
        MockDataCreator creator = new MockDataCreator();
        // 进行基础设定并加载属性数据池
        creator.getConfig().dataPool(dataPool);
        // 开始mock
        System.out.println(creator.mock(Person.class));
    }

}
