package com.kenshine.jcommander.demo09;

import com.beust.jcommander.Parameter;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:38
 * @description：
 * @modified By：
 * @version: $
 */
@ToString
public class Delegate {
    @Parameter(names = "-port")
    private int port;
}
