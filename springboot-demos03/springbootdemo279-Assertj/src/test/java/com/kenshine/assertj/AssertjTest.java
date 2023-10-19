package com.kenshine.assertj;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

import static org.assertj.core.api.Assertions.*;

/**
 * @author by kenshine
 * @Classname AssertjTest
 * @Description 断言测试
 * @Date 2023-10-19 8:24
 * @modified By：
 * @version: 1.0$
 */
public class AssertjTest {

    /**
     * 1.对象断言
     */
    @Test
    public void test01(){
        Dog fido = new Dog("Fido", 5.25F);
        Dog fidosClone = new Dog("Fido", 5.25F);

        // 引用比较
        assertThat(fido).isEqualTo(fidosClone);
        // 属性比较
        assertThat(fido).isEqualToComparingFieldByField(fidosClone);
    }

    /**
     * 2.布尔断言
     */
    @Test
    public void test02(){
        Boolean a=true;
        assertThat(a).isTrue();
        // org.opentest4j.AssertionFailedError
        assertThat(a).isFalse();
    }

    /**
     * 3.数值类型断言
     * 数值类型包括Double/Float/Integer及其他类型。断言主要比较数值在一定偏移量之内或之外
     * withPrecision 生成偏移量
     */
    @Test
    public void test03(){
        assertThat(5.1).isEqualTo(5, withPrecision(1d));
        assertThat(6.0).isEqualTo(5, withPrecision(1d));
        // java.lang.AssertionError
        assertThat(6.1).isEqualTo(5, withPrecision(1d));
    }

    /**
     * 4. InputStream断言
     * 流断言只有一个方法：hasSameContentAs(InputStream expected)
     */
    @Test
    public void test04() throws FileNotFoundException {
        // 相同
        InputStream inputStream1= new FileInputStream("E:\\test\\666.txt");
        InputStream inputStream2= new FileInputStream("E:\\test\\777.txt");
        // 不同
        InputStream inputStream3= new FileInputStream("E:\\test\\888.txt");

        assertThat(inputStream1).hasSameContentAs(inputStream2);
        // java.lang.AssertionError: InputStreams do not have same content
        assertThat(inputStream2).hasSameContentAs(inputStream3);
    }


    /**
     *  5.Iterable/Array断言
     */
    @Test
    public void test05(){
        List<String> list = Arrays.asList("1", "2", "3");
        assertThat(list).contains("1");
        assertThat(list).isNotEmpty();
        // 开头元素
        assertThat(list).startsWith("1");
        // 链式断言
        assertThat(list)
                .isNotEmpty()
                .contains("1")
                .doesNotContainNull()
                .containsSequence("2", "3");
    }


    /**
     * 6.字符断言
     */
    @Test
    public void test06(){
        Character character = 'a';
        char a='b';
        // 通过 与包装类无关
        assertThat(a)
                .isNotEqualTo('a')
                .inUnicode()
                .isGreaterThanOrEqualTo('b')
                .isLowerCase();

        // java.lang.AssertionError
        assertThat(character)
                .isNotEqualTo('a')
                .inUnicode()
                .isGreaterThanOrEqualTo('b')
                .isLowerCase();
    }

    /**
     * 7.类断言
     * 类断言一般检查其字段和类的类型，注解是否存在、是否为final类
     */
    @Test
    public void test07(){
        assertThat(Runnable.class).isInterface();
        // 判断一个类是否从另一个类赋值
        assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
    }

    /**
     * 8. 文件断言
     */
    @Test
    public void test08(){
        assertThat(new File("E:\\test\\666.txt"))
                .exists()
                .isFile()
                .canRead()
                .canWrite();
    }

    /**
     * 9.Map断言
     */
    @Test
    public void test09(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"s");
        map.put(2,"a");
        map.put(3,"b");
        map.put(4,"c");
        assertThat(map)
                .isNotEmpty()
                .containsKey(2)
                .doesNotContainKeys(10)
                .contains(entry(2, "a"));
    }

    /**
     * 10.Throwable断言
     * Throwable断言主要检查异常消息，栈跟踪，原因(cause)检查或验证
     */
    @Test
    public void test10(){
        Exception ex=new Exception("ccc");
        assertThat(ex).hasNoCause().hasMessageEndingWith("c");
    }

    /**
     * 11.断言描述
     * 为了更好描述断言，可以在断言中动态生成自定义描述，使用as方法
     */
    @Test
    public void test11(){
        Dog dog = new Dog("Fido", 5.25F);
        // org.opentest4j.AssertionFailedError: [Fido's name should be equal to Fido1]
        assertThat(dog.getName())
                .as("%s's name should be equal to Fido1", dog.getName())
                .isEqualTo("Fido1");
    }


}
