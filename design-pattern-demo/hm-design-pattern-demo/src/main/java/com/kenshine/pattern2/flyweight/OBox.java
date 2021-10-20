package com.kenshine.pattern2.flyweight;

/**
 * @version v1.0
 * @ClassName: IBox
 * @Description: O图形类(具体享元角色)
 * @Author: kenshine
 */
public class OBox extends AbstractBox {

    @Override
    public String getShape() {
        return "O";
    }
}
