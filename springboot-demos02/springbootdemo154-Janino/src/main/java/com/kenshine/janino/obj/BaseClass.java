package com.kenshine.janino.obj;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 9:15
 * @description：基类
 * @modified By：
 * @version: $
 */
public class BaseClass {
    private String baseId;

    public BaseClass(String baseId) {
        super();
        this.baseId = baseId;
    }

    @Override
    public String toString() {
        return "BaseClass [baseId=" + baseId + "]";
    }

}
