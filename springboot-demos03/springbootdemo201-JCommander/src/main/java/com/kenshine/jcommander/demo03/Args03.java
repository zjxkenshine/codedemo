package com.kenshine.jcommander.demo03;

import com.beust.jcommander.Parameter;
import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:46
 * @description：
 * @modified By：
 * @version: $
 */
@ToString
public class Args03 {
    @Parameter(names = "-hostport")
    private HostPort hostPort;
}
