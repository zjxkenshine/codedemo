package com.kenshine.springshell.converter;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 20:40
 * @description：
 * @modified By：
 * @version: $
 */
public class Food {
    private String value = null;
    public Food(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append("Food{").append("value='").append(value).append("'}")
                .toString();
    }
}
