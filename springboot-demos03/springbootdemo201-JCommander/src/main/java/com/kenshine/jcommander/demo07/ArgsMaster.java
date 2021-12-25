package com.kenshine.jcommander.demo07;

import com.beust.jcommander.Parameter;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:09
 * @description：
 * @modified By：
 * @version: $
 */
@ToString
public class ArgsMaster {
    @Parameter(names = "-master")
    private String master;
}
