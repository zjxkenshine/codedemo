package com.kenshine.fluentvalidator.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @author by kenshine
 * @Classname CarManufacturerValidator
 * @Description 品牌校验
 * @Date 2023-12-23 9:39
 * @modified By：
 * @version: 1.0$
 */
public class CarManufacturerValidator extends ValidatorHandler<String> implements Validator<String> {
    @Override
    public boolean validate(ValidatorContext context, String s) {
        return !"kenshine".equals(s);
    }
}
