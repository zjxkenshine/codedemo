package com.kenshine.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Person1
 * @Description JacksonXmlProperty 属性别名
 * @Date 2024-03-24 10:19
 * @modified By：
 * @version: 1.0$
 */
@Data
@AllArgsConstructor
public class Person1 {
    @JacksonXmlProperty(
            isAttribute = true, namespace = "urn.stackify.jacksonxml", localName = "_id")
    private String id;

    @JacksonXmlProperty(namespace = "urn.stackify.jackson")
    private String name;

    private String note;
}
