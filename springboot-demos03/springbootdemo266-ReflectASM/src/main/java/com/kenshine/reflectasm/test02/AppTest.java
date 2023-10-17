package com.kenshine.reflectasm.test02;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.FieldAccess;
import com.esotericsoftware.reflectasm.MethodAccess;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * @author by kenshine
 * @Classname AppTest
 * @Description 使用测试
 * @Date 2023-10-17 10:36
 * @modified By：
 * @version: 1.0$
 */
public class AppTest {
    public static void main(String[] args) throws Exception{
        AppTest test = new AppTest();
        test.testJdkReflect();
        test.testReflectAsm4Name();
        test.testReflectAsm4Index();
    }

    /**
     * JDK反射调用方法
     * @throws Exception
     */
    @Test
    public void testJdkReflect() throws Exception {
        UserService target = new UserService();
        long start = System.currentTimeMillis();
        Method method = target.getClass().getMethod("update", int.class, String.class);
        for (int i = 0; i < 100000000; i++) {
            method.invoke(target, 1, "kenshine");
        }
        long end = System.currentTimeMillis();
        System.out.println("timeout=" + (end - start));//809 753 880 875 816
    }

    /**
     * ReflectAsm反射调用方法
     * 用名称定位反射方法
     */
    @Test
    public void testReflectAsm4Name() {
        UserService target = new UserService();
        MethodAccess access = MethodAccess.get(UserService.class);//生成字节码的方式创建UserServiceMethodAccess
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            access.invoke(target, "update", 1, "kenshine");
        }
        long end = System.currentTimeMillis();
        System.out.println("timeout=" + (end - start));//523 382 415 489 482
    }

    /**
     * ReflectAsm反射调用方法
     * 用方法和字段的索引定位反射方法，性能高
     */
    @Test
    public void testReflectAsm4Index() {
        UserService target = new UserService();
        MethodAccess access = MethodAccess.get(UserService.class);
        int index = access.getIndex("update", int.class, String.class);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            access.invoke(target, index, 1, "kenshine");
        }
        long end = System.currentTimeMillis();
        System.out.println("timeout=" + (end - start));//12 15 23 14 24
    }

    /**
     * ReflectAsm反射来set/get字段值
     */
    @Test
    public void testFieldAccess() {
        UserService target = new UserService();
        FieldAccess fieldAccess = FieldAccess.get(target.getClass());
        fieldAccess.set(target, "state", 1);
        int state = (Integer)fieldAccess.get(target, "state");
        System.out.println(state);

    }

    /**
     * ReflectAsm反射来调用构造方法
     */
    @Test
    public void testConstructorAccess() {
        ConstructorAccess<UserService> constructorAccess = ConstructorAccess.get(UserService.class);
        UserService userService = constructorAccess.newInstance();
        System.out.println(userService);
    }

    /**
     * 查找方法的索引
     */
    @Test
    public void testIndex() {
        UserService target = new UserService();
        MethodAccess methodAccess = MethodAccess.get(target.getClass());
        int index = methodAccess.getIndex("update", int.class, String.class);
        System.out.println(index);
    }

}
