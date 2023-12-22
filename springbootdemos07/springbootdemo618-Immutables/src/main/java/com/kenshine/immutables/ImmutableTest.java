package com.kenshine.immutables;

import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ImmutableTest
 * @Description 使用
 * @Date 2023-12-22 13:51
 * @modified By：
 * @version: 1.0$
 */
public class ImmutableTest {

    /**
     * 编译后会自动生成ImmutableValueObject类
     */
    public static void main(String[] args) {
        ValueObject valueObject = ImmutableValueObject.builder()
                .name("My value")
                .addCounts(1)
                .addCounts(2)
                .build();
        System.out.println(valueObject);
    }

    /**
     * 抽象类生成不可变类
     */
    @Test
    public void test02(){
        AbstractItem namelessItem = ImmutableItem.builder()
                .name("Nameless")
                .addTags("important", "relevant")
                .description("Description provided")
                .build();
        System.out.println(namelessItem.getName());
        System.out.println(namelessItem.getDescription());
    }

}
