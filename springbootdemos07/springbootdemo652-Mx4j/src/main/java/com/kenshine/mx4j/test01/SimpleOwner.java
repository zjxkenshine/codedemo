package com.kenshine.mx4j.test01;

public class SimpleOwner implements SimpleOwnerMBean {
    private String m_name = null;

    public SimpleOwner(String name) {
        this.m_name = name;
    }

    @Override
    public void setOwnerName(String name) {
        this.m_name = name;
    }

    @Override
    public String getOwnerName() {
        return this.m_name;
    }
}