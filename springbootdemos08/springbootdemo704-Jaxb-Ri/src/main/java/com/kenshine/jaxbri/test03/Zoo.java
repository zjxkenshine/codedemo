package com.kenshine.jaxbri.test03;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import java.util.List;

/**
 * @author kenshine
 */
@XmlRootElement
public class Zoo {
  @XmlAnyElement
  public List<Animal> animals;

  public static void main(String[] args) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Zoo.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    // 解析XML
    Zoo zoo=(Zoo) unmarshaller.unmarshal(new File("springbootdemo704-Jaxb-Ri\\src\\main\\resources\\xml\\test02.xml"));
    System.out.println(zoo);
  }
}