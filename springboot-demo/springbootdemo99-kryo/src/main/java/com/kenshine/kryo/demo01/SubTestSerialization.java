package com.kenshine.kryo.demo01;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 15:05
 * @description：
 * @modified By：
 * @version: $
 */
@Data
public class SubTestSerialization implements Serializable {
    private static final long serialVersionUID = 3949250025120815199L;

    private String name;
}
