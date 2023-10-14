package com.kenshine.oshi.model;

import lombok.Data;

/**
 * @author by kenshine
 * @Classname OSInfo
 * @Description 系统信息
 * @Date 2023-10-14 17:07
 * @modified By：
 * @version: 1.0$
 */
@Data
public class OSInfo {
    /**
     * 系统
     */
    private String os;

    /**
     * 系统架构
     */
    private String osArch;

    /**
     * java版本
     */
    private String javaVersion;

    /**
     * 工作目录
     */
    private String userDir;

    /**
     * cpu核心数
     */
    private int cpuCount;

    /**
     * 主机host
     */
    private String host;

    /**
     * 主机名称
     */
    private String hostName;

    /**
     * 系统启动时间
     */
    private String bootTime;
}
