package com.kenshine.jaxbri.test03;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
class Lion implements Animal {
    @Override
    public void sleep() {
        System.out.println("Lion sleep");
    }

    @Override
    public void eat() {
        System.out.println("Lion eat");
    }
}