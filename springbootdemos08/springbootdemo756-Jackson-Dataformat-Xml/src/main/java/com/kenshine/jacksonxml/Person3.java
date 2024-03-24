package com.kenshine.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Person3
 * @Description JacksonXmlText 文本/JacksonXmlCData内容不被xml解析
 * @Date 2024-03-24 10:24
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
public class Person3 {
    private String id;

    @JacksonXmlCData
    private String name;

    @JacksonXmlText
    @JacksonXmlCData
    private String note;
}
