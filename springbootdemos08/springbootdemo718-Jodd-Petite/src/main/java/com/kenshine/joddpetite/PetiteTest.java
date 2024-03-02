package com.kenshine.joddpetite;

import com.kenshine.joddpetite.bean.Bar;
import com.kenshine.joddpetite.bean.Foo;
import jodd.petite.AutomagicPetiteConfigurator;
import jodd.petite.PetiteContainer;
import jodd.petite.scope.ProtoScope;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname PetiteTest
 * @Description Petite使用示例
 * @Date 2024-03-02 8:21
 * @modified By：
 * @version: 1.0$
 */
public class PetiteTest {

    /**
     * 注册bean
     */
    @Test
    public void test01(){
        PetiteContainer petite = new PetiteContainer();
        // bean "foo"
        petite.registerPetiteBean(Foo.class);

        // 获取bean
        Foo foo = petite.getBean("foo");
        System.out.println(foo);
        foo.foo();

        // 设置全类型名称
        petite.config().setUseFullTypeNames(true);
        // bean "com.kenshine.joddpetite.bean.Bar"
        petite.registerPetiteBean(Bar.class);
        Bar bar = petite.getBean("com.kenshine.joddpetite.bean.Bar");
        System.out.println(bar);
        bar.bar();
    }

    /**
     * 自动注册bean
     * 设置bean属性
     * @PetiteBean注解
     */
    @Test
    public void test02(){
        PetiteContainer petite = new PetiteContainer();
        new AutomagicPetiteConfigurator(petite).configure();
        Foo foo = petite.getBean("foo");
        System.out.println(foo);
        foo.foo();

        // 设置bean属性
        petite.setBeanProperty("foo.name", "kkk");
        System.out.println(petite.getBeanProperty("foo.name"));
        foo.foo();
    }

    /**
     * Scope
     */
    @Test
    public void test03(){
        PetiteContainer petite = new PetiteContainer();
        petite.registerPetiteBean(Foo.class, null, ProtoScope.class, null, false,null);
        petite.registerPetiteBean(Bar.class, null, null, null, false,null);
    }



}
