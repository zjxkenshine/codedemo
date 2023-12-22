package com.kenshine.beanfillertrace;

import com.kenshine.beanfillertrace.model.Emoji;
import com.kenshine.beanfillertrace.model.User;
import io.github.beanfiller.annotation.annotations.Value;
import io.github.beanfiller.annotation.annotations.Var;
import io.github.beanfiller.annotation.creator.FunctionTestsCreator;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname BeanfillerTeat
 * @Description beanfiller-tcases使用测试
 * @Date 2023-12-22 9:45
 * @modified By：
 * @version: 1.0$
 */
public class BeanfillerTeat {


    /**
     * Emoji类生成
     */
    @Test
    public void test01(){
        int tupleSize = 2;
        List<Emoji> testCases = new FunctionTestsCreator<>(Emoji.class)
                .tupleGenerator(tupleSize)
                .createDefs();
        testCases.forEach(test -> System.out.println(test.getFace()));
        System.out.println("\n" + testCases.size() + "个face,由" + tupleSize + "元组属性生成");
    }

    /**
     * User生成
     * 会生成null值
     */
    @Test
    public void test02(){
        List<User> testCases = new FunctionTestsCreator<>(User.class)
                .createDefs();
        testCases.forEach(System.out::println);
    }
}
