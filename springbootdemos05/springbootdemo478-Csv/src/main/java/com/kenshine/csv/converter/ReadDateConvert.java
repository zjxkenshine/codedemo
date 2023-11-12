package com.kenshine.csv.converter;

import com.github.houbb.csv.api.IReadConverter;
import com.github.houbb.csv.support.context.SingleReadContext;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Kenshine
 */
public class ReadDateConvert implements IReadConverter {

    @Override
    public Object convert(SingleReadContext singleReadContext) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
            return dateFormat.parse(singleReadContext.value());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}