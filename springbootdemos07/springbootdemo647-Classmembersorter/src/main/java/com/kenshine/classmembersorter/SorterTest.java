package com.kenshine.classmembersorter;

import com.kenshine.classmembersorter.model.User;
import net.orfjackal.tools.classmembersorter.AsmLineNumberStrategy;
import net.orfjackal.tools.classmembersorter.ClassMemberSorter;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname SorterTest
 * @Description 排序测试
 * @Date 2024-01-03 9:21
 * @modified By：
 * @version: 1.0$
 */
public class SorterTest {

    /**
     * 获取类方法，按照定义的顺序
     */
    @Test
    public void test01(){
        ClassMemberSorter.setStrategy(new AsmLineNumberStrategy());
        Method[] methods=ClassMemberSorter.getDeclaredMethods(User.class);
        Arrays.stream(methods).forEach(System.out::println);
    }
}
