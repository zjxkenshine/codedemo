package com.kenshine.validator;

import com.github.houbb.validator.api.api.result.IResult;
import com.github.houbb.validator.core.api.constraint.Constraints;
import com.github.houbb.validator.core.util.ValidHelper;
import com.kenshine.validator.model.User;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ValidatorTest
 * @Description 校验测试
 * @Date 2023-11-29 8:20
 * @modified By：
 * @version: 1.0$
 */
public class ValidatorTest {

    /**
     * validHelper校验
     */
    @Test
    public void testValidHelper(){
        // 对象定义
        User user = new User();
        user.setSex("dog").setPassword("old").setPassword2("new");
        // 快速校验
        IResult result = ValidHelper.failFast(user);
        System.out.println(result);
        // 全校验
        IResult result2 = ValidHelper.failOver(user);
        System.out.println(result2);
    }

    /**
     * 过程式校验
     */
    @Test
    public void test02(){
        IResult result = ValidHelper.failFast("", Constraints.notEmpty());
        System.out.println(result);
    }



}
