package com.kenshine.annotation;

import com.kenshine.validator.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 15:03
 * @description：自定义校验注解
 * @modified By：
 * @version: $
 */
@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Password {

    String message() default "无效密码";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}