package com.kenshine.oval.annotations;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/6 10:10
 * @description：大写检查
 * @modified By：
 * @version: $
 */
public class UpperCaseCheck extends AbstractAnnotationCheck<UpperCase> {

    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context, Validator validator) {
        if (valueToValidate == null) return true;
        String val = valueToValidate.toString();
        return val.equals(val.toUpperCase());
    }

}
