package com.kenshine.jacksonxml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by kenshine
 * @Classname Person2
 * @Description 作用与整个文档的根元素 设置命名空间
 * @Date 2024-03-24 10:22
 * @modified By：
 * @version: 1.0$
 */
@AllArgsConstructor
@Data
@JacksonXmlRootElement(namespace = "urn.stackify.jacksonxml", localName = "PersonData")
public class Person2 {
    private String id;
    private String name;
    private String note;
}
