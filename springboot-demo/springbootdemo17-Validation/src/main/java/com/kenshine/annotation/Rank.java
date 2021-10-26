package com.kenshine.annotation;

import com.kenshine.validator.RankValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 15:06
 * @description：Rank校验
 * @modified By：
 * @version: $
 */
@Documented
@Constraint(validatedBy = RankValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Rank {
    String message() default "rank值无效";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
