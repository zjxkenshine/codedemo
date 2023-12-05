package com.kenshine.festreflect;
import static org.fest.reflect.core.Reflection.*;

import com.kenshine.festreflect.model.User;
import com.kenshine.festreflect.model.UserBase;
import org.fest.reflect.reference.TypeRef;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname ReflectTest
 * @Description fest-reflect使用测试
 * @Date 2023-12-05 16:14
 * @modified By：
 * @version: 1.0$
 */
public class ReflectTest {

    @Test
    public void test(){
        // 加载class
        Class<?> user1 = type("com.kenshine.festreflect.model.User").load();

        /**
         * User extends UserBase
         */
        Class<UserBase> userBase = (Class<UserBase>) type("com.kenshine.festreflect.model.User").loadAs(UserBase.class);

        // 自定义classLoader
        Class<?> jediType = type("com.kenshine.festreflect.model.User").withClassLoader(this.getClass().getClassLoader()).load();

        // 内部类，无效
        //Class<?> masterClass = innerClass("Master").in(Jedi.class).get();

        // 调用构造方法
        User user2 = constructor().in(User.class).newInstance();
        user2.setId(1);
        user2.setName("kenshine");
        System.out.println(user2);

        // 调用指定构造方法
        User user3 = constructor().withParameterTypes(String.class).in(User.class).newInstance("kenshine");
        System.out.println(user3);

        // 获取name属性值
        String name = field("name").ofType(String.class).in(user3).get();
        System.out.println(name);

        // 设置id属性值
        field("id").ofType(Integer.class).in(user3).set(1);
        System.out.println(user3);

        user3.setPowers(Arrays.asList("a","b","c"));
        // 获取List<String>
        List<String> powers = field("powers").ofType(new TypeRef<List<String>>() {}).in(user3).get();
        System.out.println(powers);

        // 调用方法
        method("setName").withParameterTypes(String.class)
                .in(user3)
                .invoke("kenshine1");
        System.out.println(user3);

        // 调用get方法 返回List
        List<String> powers1 = method("getPowers").withReturnType(new TypeRef<List<String>>() {})
                .in(user3)
                .invoke();
        System.out.println(powers1);

        // 获取static静态属性值
        int count = field("count").ofType(int.class).in(User.class).get();
        System.out.println(count);

        // 设置静态属性值
        field("count").ofType(int.class).in(User.class).set(3);
        System.out.println(User.count);

        /**
         * 静态List属性
         */
        List<String> commmonPowers = field("commonPowers").ofType(new TypeRef<List<String>>() {}).in(User.class).get();
        System.out.println(commmonPowers);

        // 调用无参方法
        method("concentrate").in(user3).invoke();

        // 调用getName方法
        String name2 = method("getName").withReturnType(String.class)
                .in(user3)
                .invoke();
        System.out.println(name2);

        // 调用静态方法 setCommonPower
        method("setCommonPower").withParameterTypes(String.class)
                .in(User.class)
                .invoke("static3");
        System.out.println(User.commonPowers);

        /**
         * 调用静态方法 addPadawan
         */
        method("addPadawan").in(User.class).invoke();

        /**
         * 调用静态方法commonPowerCount
         */
        String name1 = method("commonPowerCount").withReturnType(String.class)
                .in(User.class)
                .invoke();
        System.out.println(name1);

        // 调用getCommonPowers静态方法
        List<String> powers2 = method("getCommonPowers").withReturnType(new TypeRef<List<String>>() {})
                .in(User.class)
                .invoke();
        System.out.println(powers2);

        // name属性
        String name3 = property("name").ofType(String.class).in(user3).get();
        System.out.println(name3);
        // 设置name属性
        property("name").ofType(String.class).in(user3).set("kenshine2");
        System.out.println(user3);
    }
}
