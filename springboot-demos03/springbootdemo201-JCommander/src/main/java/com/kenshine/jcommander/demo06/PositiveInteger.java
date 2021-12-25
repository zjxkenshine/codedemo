package com.kenshine.jcommander.demo06;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:02
 * @description： 自定义验证器
 * @modified By：
 * @version: $
 */
public class PositiveInteger implements IParameterValidator {
    @Override
    public void validate(String name, String value)
            throws ParameterException {
        int n = Integer.parseInt(value);
        if (n < 0) {
            throw new ParameterException("Parameter " + name + " should be positive (found " + value +")");
        }
    }
}
