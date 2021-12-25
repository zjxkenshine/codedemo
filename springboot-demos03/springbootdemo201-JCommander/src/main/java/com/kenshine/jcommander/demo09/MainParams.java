package com.kenshine.jcommander.demo09;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParametersDelegate;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:38
 * @description：
 * @modified By：
 * @version: $
 */
@ToString
public class MainParams {
    @Parameter(names = "-v")
    private boolean verbose;

    @ParametersDelegate
    private Delegate delegate = new Delegate();
}
