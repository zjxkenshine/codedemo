package com.kenshine.jaxbri.test02;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;
import java.util.HashMap;

/**
 * @author by kenshine
 * @Classname Test02
 * @Description 适配HashMap,不同类型的Map操作
 * @Date 2024-02-23 11:12
 * @modified By：
 * @version: 1.0$
 */
public class Test02 {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(MyHashMapType.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        HashMap<String,Integer> m = new HashMap<>(16);
        m.put("abc",1);
        marshaller.marshal(new JAXBElement<>(new QName("root"),MyHashMapType.class,new MyHashMapType(m)),System.out);
    }
}
