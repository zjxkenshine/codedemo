package com.kenshine.binder.validator;

import com.kenshine.binder.domain.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 13:58
 * @description：邮箱校验
 * @modified By：
 * @version: 1.0$
 */
@Component
public class EmailValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User)target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "","Email is empty");
        if (!user.getEmail().contains("@")) {
            errors.rejectValue("email","", "Email is not valid.");
        }
    }
}
