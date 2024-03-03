package com.kenshine.joddvtor;

import com.kenshine.joddvtor.model.Boo;
import com.kenshine.joddvtor.model.Foo;
import jodd.vtor.Check;
import jodd.vtor.ValidationContext;
import jodd.vtor.Violation;
import jodd.vtor.Vtor;
import jodd.vtor.constraint.MinLengthConstraint;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname VtorTest
 * @Description vtor使用示例
 * @Date 2024-03-03 8:27
 * @modified By：
 * @version: 1.0$
 */
public class VtorTest {

    /**
     * 简单校验过程
     */
    @Test
    public void test01(){
        ValidationContext vctx = new ValidationContext();
        // boo属性最小长度为2
        // 定义校验规则
        vctx.add(new Check("boo", new MinLengthConstraint(2)));
        Boo boo = new Boo();
        boo.setBoo("1");
        Vtor vtor = new Vtor();
        // 使用校验规则
        vtor.validate(vctx, boo);
        // 获取校验结果 验证成功，返回list是null
        List<Violation> vlist = vtor.getViolations();
        System.out.println(vlist);
    }

    /**
     * 注解校验
     */
    @Test
    public void test02(){
        Foo foo = new Foo();
        foo.setBoo("aabbbb");
        Vtor vtor = new Vtor();
        vtor.validate(foo);
        System.out.println(vtor.hasViolations());
    }

    /**
     * profile
     */
    @Test
    public void test03(){
        Foo foo = new Foo();
        foo.setBoo("aabbbb");
        Vtor vtor = new Vtor();
        vtor.useProfiles("p1", "p2");
        vtor.validate("aabbbb");
    }

    /**
     * 自定义校验
     */
    @Test
    public void test04(){
        Foo foo = new Foo();
        Vtor vtor = new Vtor();
        vtor.addViolation(new Violation("number", foo, null));
    }

    /**
     * 直接执行校验
     */
    @Test
    public void test05(){
        boolean valid = MinLengthConstraint.validate("value", 3);
        System.out.println(valid);
    }
}
