package com.kenshine.framework.beans;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 23:22
 * @description：封装bean信息
 * @modified By：
 * @version: $
 *
 * BeanDefinition类用来封装bean信息的，主要包含id（即bean对象的名称）、class（需要交由spring管理的类的全类名）及子标签property数据
 */
public class BeanDefinition {

    private String id;
    private String className;
    /**
     * 字标签数据
     */
    private MutablePropertyValues propertyValues;

    public BeanDefinition() {
        propertyValues = new MutablePropertyValues();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setPropertyValues(MutablePropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }

    public MutablePropertyValues getPropertyValues() {
        return propertyValues;
    }

}
