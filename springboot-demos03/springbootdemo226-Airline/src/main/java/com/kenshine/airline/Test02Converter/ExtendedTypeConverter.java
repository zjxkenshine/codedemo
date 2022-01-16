package com.kenshine.airline.Test02Converter;

import com.github.rvesse.airline.types.ConvertResult;
import com.github.rvesse.airline.types.DefaultTypeConverter;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 14:38
 * @description：
 * @modified By：
 * @version: $
 */
public class ExtendedTypeConverter extends DefaultTypeConverter {

    @Override
    public Object convert(String name, Class<?> type, String value) {
        checkArguments(name, type, value);

        // 转换方法
        ConvertResult result = this.tryConvertStringMethod(name,type, value, "parse");
        //结果处理
        if (result.wasSuccessfull()) {
            return result.getConvertedValue();
        }

        // 返回默认转换结果
        return super.convert(name, type, value);
    }
}
