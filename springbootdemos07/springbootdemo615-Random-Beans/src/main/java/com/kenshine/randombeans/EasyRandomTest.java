package com.kenshine.randombeans;

import com.kenshine.randombeans.model.Person;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;

import static org.jeasy.random.FieldPredicates.*;

/**
 * @author by kenshine
 * @Classname EasyRandomTest
 * @Description EasyRandom使用测试
 * @Date 2023-12-22 8:38
 * @modified By：
 * @version: 1.0$
 */
public class EasyRandomTest {

    /**
     * 随机bean生成
     */
    @Test
    public void test01(){
        EasyRandom easyRandom = new EasyRandom();
        Person person = easyRandom.nextObject(Person.class);
        System.out.println(person);
    }

    /**
     * 7个随机方法
     * nextInt()，nextLong()，nextDouble()，nextFloat()，nextBytes()，nextBoolean()和nextGaussian()
     */
    @Test
    public void test02(){
        EasyRandom easyRandom = new EasyRandom();
        System.out.println("nextBoolean:"+easyRandom.nextBoolean());
        byte[] bytes = new byte[10];
        easyRandom.nextBytes(bytes);
        System.out.println("nextBytes:"+ Arrays.toString(bytes));
        System.out.println("nextInt:"+easyRandom.nextInt());
        System.out.println("nextLong:"+easyRandom.nextLong());
        System.out.println("nextDouble:"+easyRandom.nextDouble());
        System.out.println("nextFloat:"+easyRandom.nextFloat());
        System.out.println("nextGaussian:"+easyRandom.nextGaussian());
    }


    /**
     *  EasyRandomParameters 随机配置
     */
    @Test
    public void test03(){
        EasyRandomParameters parameters = new EasyRandomParameters()
                .seed(123L)
                .objectPoolSize(100)
                .randomizationDepth(3)
                .charset(StandardCharsets.UTF_8)
                //.timeRange(LocalTime.MIN, LocalTime.MAX)
                //.dateRange(LocalDate.MIN, LocalDate.now().plusDays(1L))
                .stringLengthRange(5, 7)
                .collectionSizeRange(1, 10)
                .scanClasspathForConcreteTypes(true)
                .overrideDefaultInitialization(false)
                .ignoreRandomizationErrors(true);
        EasyRandom easyRandom = new EasyRandom(parameters);
        String s = easyRandom.nextObject(String.class);
        System.out.println(s);
    }


    /**
     * Randomizer接口生成随机数据
     */
    @Test
    public void test04(){
        EasyRandomParameters parameters = new EasyRandomParameters()
                // Randomizer接口生成随机数据
                .randomize(String.class, () -> "foo")
                .excludeField(named("age").and(ofType(Integer.class)).and(inClass(Person.class)));
        EasyRandom easyRandom = new EasyRandom(parameters);
        Person person = easyRandom.nextObject(Person.class);
        System.out.println(person);
    }

}
