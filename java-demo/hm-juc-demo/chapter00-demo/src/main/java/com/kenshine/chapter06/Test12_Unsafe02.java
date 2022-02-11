package com.kenshine.chapter06;

import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/11 22:15
 * @description：Unsafe模拟实现cas操作
 * @modified By：
 * @version: $
 *
 */
public class Test12_Unsafe02 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        // 创建 unsafe 对象
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe)theUnsafe.get(null);

        // 拿到偏移量
        long idOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("id"));
        long nameOffset = unsafe.objectFieldOffset(Teacher.class.getDeclaredField("name"));

        // 进行cas操作
        Teacher teacher = new Teacher();
        // cas更新long
        unsafe.compareAndSwapLong(teacher, idOffset, 0, 100);
        // cas更新对象
        unsafe.compareAndSwapObject(teacher, nameOffset, null, "lisi");

        System.out.println(teacher);
    }

}

@Data
class Teacher {

    private volatile int id;
    private volatile String name;

}
