package com.kenshine.validator;

import com.kenshine.annotation.Password;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 15:04
 * @description：自定义密码校验器
 * @modified By：
 * @version: $
 */
public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        // 密码必须以大写英文字母开头，只包含英文字母、数字、下划线，长度在6到20之间
        return value.matches("^[A-Z][A-Za-z0-9_]{5,19}$");
    }

}
