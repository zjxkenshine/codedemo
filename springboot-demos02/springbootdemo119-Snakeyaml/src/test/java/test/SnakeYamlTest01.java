package test;

import com.kenshine.snakeyml.domain.Contact;
import com.kenshine.snakeyml.domain.Customer;
import com.kenshine.snakeyml.domain.Customer2;
import org.junit.Test;
import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import java.io.InputStream;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 17:32
 * @description：
 * @modified By：
 * @version: $
 * https://www.cnblogs.com/xiaoqi/p/SnakeYAML.html
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = SnakeYmlApp.class)
public class SnakeYamlTest01 {
    /**
     * 基本用法
     */
    @Test
    public void test01(){
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                //从classpath中读取
                .getResourceAsStream("yml/customer.yaml");
        Map<String, Object> obj = (Map<String, Object>) yaml.load(inputStream);
        System.out.println(obj);
    }

    /**
     * 自定义类型解析
     */
    @Test
    public void test02(){
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yml/customer.yaml");
        Customer customer = yaml.loadAs(inputStream,Customer.class);
        System.out.println(customer);
    }

    /**
     * 隐式类型转换
     */
    @Test
    public void test03(){
        Yaml yaml = new Yaml();
        Map<Object, Object> document = (Map<Object, Object>) yaml.load("3.0: 2018-07-22");
        System.out.println(document);
    }

    /**
     * 嵌套对象
     */
    @Test
    public void test04(){
        Yaml yaml = new Yaml(new Constructor(Customer2.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yml/customer02.yaml");
        Customer2 customer2 = yaml.loadAs(inputStream, Customer2.class);
        System.out.println(customer2);
    }

    /**
     * 类型安全的集合
     * 当给定Java类的一个或多个属性是泛型集合类时，需要通过TypeDescription来指定泛型类型，以以便可以正确解析
     */
    @Test
    public void test05(){
        Constructor constructor = new Constructor(Customer2.class);
        TypeDescription customTypeDescription = new TypeDescription(Customer2.class);
        //指定contact列表
        customTypeDescription.putListPropertyType("contactDetails", Contact.class);
        constructor.addTypeDescription(customTypeDescription);
        Yaml yaml = new Yaml(constructor);
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yml/customer03.yaml");
        Customer2 customer2 = yaml.loadAs(inputStream, Customer2.class);
        System.out.println(customer2);
    }

    /**
     * 载入多个文件
     * 在某些情况下，单个文件中可能有多个YAML文档，而我们想解析所有文档。所述YAML类提供了一个LOADALL（）方法来完成这种类型的解析
     */
    @Test
    public void test06(){
        Yaml yaml = new Yaml(new Constructor(Customer.class));
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("yml/customer_multi.yaml");

        int count = 0;
        for (Object object : yaml.loadAll(inputStream)) {
            count++;
            System.out.println(object);
        }
        System.out.println(count);
    }



}
