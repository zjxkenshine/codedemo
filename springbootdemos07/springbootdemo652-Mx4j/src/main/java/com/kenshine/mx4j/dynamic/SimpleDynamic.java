package com.kenshine.mx4j.dynamic;

import mx4j.AbstractDynamicMBean;

import javax.management.MBeanAttributeInfo;

/**
 * 简单动态Bean实现
 * @author kenshine
 */
public class SimpleDynamic extends AbstractDynamicMBean {
    // 属性描述
    @Override
    protected MBeanAttributeInfo[] createMBeanAttributeInfo() {
        return new MBeanAttributeInfo[]{
            new MBeanAttributeInfo("Name", String.class.getName(), "The name", true, true, false)
        };
    }

    // 描述
    @Override
    protected String getMBeanDescription()
    {
        return "A simple DynamicMBean";
    }

    public String getName() {return "simple"; }

    public void setName(String name) {}
}