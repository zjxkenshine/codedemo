package com.kenshine.csv.converter;

import com.github.houbb.csv.api.IWriteConverter;
import com.github.houbb.csv.support.context.SingleWriteContext;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author Kenshine
 */
public class WriteDateConvert implements IWriteConverter{

    @Override
    public String convert(SingleWriteContext singleWriteContext) {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        return dateFormat.format(singleWriteContext.value());
    }
}