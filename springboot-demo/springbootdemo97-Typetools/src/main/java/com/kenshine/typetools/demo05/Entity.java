package com.kenshine.typetools.demo05;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 9:08
 * @description：
 * @modified By：
 * @version: $
 */
public class Entity<T extends Serializable> {
    T  id;
    void setId(T id) {}
}
