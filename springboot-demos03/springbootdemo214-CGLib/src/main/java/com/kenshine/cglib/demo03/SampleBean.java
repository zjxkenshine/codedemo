package com.kenshine.cglib.demo03;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 22:26
 * @description：
 * @modified By：
 * @version: $
 */
public class SampleBean {
    private String value;

    public SampleBean() {
    }

    public SampleBean(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
