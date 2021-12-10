package com.kenshine.fastjson.pojo.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 11:04
 * @description：
 * @modified By：
 * @version: $
 */
@lombok.Data
public class Error implements Serializable {
    private static final long serialVersionUID = -432908543160176349L;

    private String code;
    private String message;
    private String success;
    private List<Data> data = new ArrayList<>();

}
