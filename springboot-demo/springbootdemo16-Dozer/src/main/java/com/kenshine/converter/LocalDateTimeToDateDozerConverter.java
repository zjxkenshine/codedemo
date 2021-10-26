package com.kenshine.converter;

import com.github.dozermapper.core.DozerConverter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 10:23
 * @description：自定义LocalDateTime到Date转换器
 * @modified By：
 * @version: $
 */
public class LocalDateTimeToDateDozerConverter extends DozerConverter<LocalDateTime, Date> {

    public LocalDateTimeToDateDozerConverter() {
        super(LocalDateTime.class, Date.class);
    }

    /**
     * Date 到 LocalDateTime
     * @param source
     * @param destination
     * @return
     */
    @Override
    public LocalDateTime convertFrom(Date source, LocalDateTime destination) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(source.toInstant(), ZoneId.systemDefault());
        return dateTime;
    }

    /**
     * LocalDateTime 到 Date
     * @param source
     * @param destination
     * @return
     */
    @Override
    public Date convertTo(LocalDateTime source, Date destination) {
        Date convertToDate = Date.from(source.atZone(ZoneId.systemDefault()).toInstant());
        return convertToDate;
    }
}
