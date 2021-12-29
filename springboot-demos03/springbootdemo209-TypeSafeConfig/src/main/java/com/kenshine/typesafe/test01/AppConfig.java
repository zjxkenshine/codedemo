package com.kenshine.typesafe.test01;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 9:29
 * @description：配置实体类
 * @modified By：
 * @version: $
 */
@Data
public class AppConfig {
    //允许配置为null
    //@Optional()
    private Demo demo;
}
