package com.kenshine.jaxbri.test01;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

import java.io.File;
import java.util.HashMap;

/**
 * @author by kenshine
 * @Classname Foo
 * @Description jaxb绑定类
 * @Date 2024-02-23 10:10
 * @modified By：
 * @version: 1.0$
 */
@XmlRootElement
public class Foo {
    public HashMap<String,Integer> map;

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Foo.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        // 解析XML
        Foo foo=(Foo)unmarshaller.unmarshal(new File("springbootdemo704-Jaxb-Ri\\src\\main\\resources\\xml\\test01.xml"));
        foo.map.forEach((k,v)->{
            System.out.println(k+":"+v);
        });
    }
}
