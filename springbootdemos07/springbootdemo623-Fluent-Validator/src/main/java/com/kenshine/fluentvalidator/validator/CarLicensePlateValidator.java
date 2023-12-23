package com.kenshine.fluentvalidator.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @author by kenshine
 * @Classname CarLicensePlateValidator
 * @Description 车牌校验
 * @Date 2023-12-23 9:39
 * @modified By：
 * @version: 1.0$
 */
public class CarLicensePlateValidator extends ValidatorHandler<String> implements Validator<String> {
    @Override
    public boolean validate(ValidatorContext context, String s) {
        return s.length() <= 9 && s.length() >= 5;
    }
}
