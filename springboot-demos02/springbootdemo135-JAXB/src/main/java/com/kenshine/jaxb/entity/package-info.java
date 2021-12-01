/**
 * @author ：kenshine
 * @date ：Created in 2021/12/1 9:45
 * @description：定义命名空间
 * @modified By：
 * @version: $
 */
/**
 * 设置命名空间对应的前缀
 */
@XmlSchema(xmlns = {@XmlNs(prefix = "school", namespaceURI = "http://www.w3.org/TR/html4/school/")})
package com.kenshine.jaxb.entity;

import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlSchema;