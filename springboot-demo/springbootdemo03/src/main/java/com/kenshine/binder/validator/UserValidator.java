package com.kenshine.binder.validator;

import com.kenshine.binder.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 13:56
 * @description：用户校验
 * @modified By：
 * @version: $
 */
@Component
public class UserValidator implements Validator {


    /**
     * 检验参数是否验证成功的实例类
     */
    @Override
    public boolean supports(Class<?> clazz) {
        //isAssignableFrom()方法是判断是否为某个类的父类，instanceof关键字是判断是否某个类的子类。
        return User.class.isAssignableFrom(clazz);
    }

    /**
     * 如果 supports() 方法返回真, target object 合法. Errors.rejectValue() 方法会用一个字段名注册错误信息;
     */
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        //配置字段验证信息
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "","Username is empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "Password is empty");
        //用户名长度不能小于5个字符
        if (user.getName().length()<5) {
            errors.rejectValue("name","", "Username length is less than 5");
        }
    }


}
