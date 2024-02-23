package com.kenshine.jaxbri.test01;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import javax.xml.namespace.QName;
import java.util.HashMap;

/**
 * @author by kenshine
 * @Classname Test01
 * @Description bean转xml
 * @Date 2024-02-23 11:08
 * @modified By：
 * @version: 1.0$
 */
public class Test01 {

    public static void main(String[] args) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Foo.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        HashMap<String,Integer> m = new HashMap<>();
        m.put("abc",1);
        Foo foo = new Foo();
        foo.map=m;
        marshaller.marshal(new JAXBElement<>(new QName("root"),Foo.class,foo),System.out);
    }
}
