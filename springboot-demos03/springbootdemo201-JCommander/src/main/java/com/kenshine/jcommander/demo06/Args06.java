package com.kenshine.jcommander.demo06;

import com.beust.jcommander.Parameter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:02
 * @description：
 * @modified By：
 * @version: $
 */
public class Args06 {
    @Parameter(names = "-age", validateWith = PositiveInteger.class)
    private Integer age;

    //可指定多个
    //@Parameter(names = "-count", validateWith = { PositiveInteger.class, CustomOddNumberValidator.class })
    private Integer value;
}
