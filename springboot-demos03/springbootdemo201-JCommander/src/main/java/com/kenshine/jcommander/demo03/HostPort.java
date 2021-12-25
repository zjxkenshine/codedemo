package com.kenshine.jcommander.demo03;

import lombok.ToString;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 22:43
 * @description：
 * @modified By：
 * @version: $
 */
@ToString
public class HostPort {
    final String host;
    final Integer port;

    public HostPort(String host, Integer port) {
        this.host = host;
        this.port = port;
    }

}
