package com.kenshine.beanio.model;

import lombok.Data;

/**
 * @author kenshine
 * 嵌套bean
 */
@Data
public class Address {
    String street;
    String city;
    String state;
    String zip;
}