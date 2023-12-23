package com.kenshine.fluentvalidator.validator;

import com.baidu.unbiz.fluentvalidator.Validator;
import com.baidu.unbiz.fluentvalidator.ValidatorContext;
import com.baidu.unbiz.fluentvalidator.ValidatorHandler;

/**
 * @author by kenshine
 * @Classname CarSeatCountValidator
 * @Description 座位数量校验
 * @Date 2023-12-23 9:37
 * @modified By：
 * @version: 1.0$
 */
public class CarSeatCountValidator extends ValidatorHandler<Integer> implements Validator<Integer> {

    @Override
    public boolean validate(ValidatorContext context, Integer integer) {
        if (integer < 2) {
            context.addErrorMsg(String.format("Seat count is not valid, invalid value=%s", integer));
            return false;
        }
        return true;
    }
}
