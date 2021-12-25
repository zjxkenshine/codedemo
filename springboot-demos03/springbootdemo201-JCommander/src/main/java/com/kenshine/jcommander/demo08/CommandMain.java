package com.kenshine.jcommander.demo08;

import com.beust.jcommander.Parameter;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:23
 * @description：
 * @modified By：
 * @version: $
 */
@ToString
public class CommandMain {
    @Parameter(names = "-v")
    private boolean verbose;
}
