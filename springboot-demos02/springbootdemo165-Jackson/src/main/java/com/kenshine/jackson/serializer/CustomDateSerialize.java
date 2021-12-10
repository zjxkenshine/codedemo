package com.kenshine.jackson.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 9:33
 * @description：自定义序列化
 * @modified By：
 * @version: $
 */
public class CustomDateSerialize extends JsonSerializer<LocalDateTime> {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH-mm-ss");

    @Override
    public void serialize(LocalDateTime localDateTime, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeString(dateTimeFormatter.format(localDateTime));
    }

}
