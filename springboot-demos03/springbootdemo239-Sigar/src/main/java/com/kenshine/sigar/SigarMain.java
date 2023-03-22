package com.kenshine.sigar;

import org.hyperic.sigar.SigarException;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname SigarMain
 * @Description 测试主方法
 * @Date 2023/3/22 9:17
 * @modified By：
 * @version: 1.0$
 */
public class SigarMain {
    public static void main(String[] args) {
        // Sigar信息集合
        List<SigarInfoEntity> sigarInfos = new ArrayList<>();
        try {
            // 1.获取系统信息和jvm虚拟机信息
            sigarInfos.addAll(SigarUtils.getJvmInfos());
            // 2.获取cpu信息
            sigarInfos.addAll(SigarUtils.getCpuInfos());
            // 3.获取内存信息
            sigarInfos.addAll(SigarUtils.getMemoryInfos());
            // 4.获取操作系统信息
            sigarInfos.addAll(SigarUtils.getOsInfos());
            // 5.获取文件信息
            sigarInfos.addAll(SigarUtils.getFileInfos());
            // 6.获取网络信息
            sigarInfos.addAll(SigarUtils.getNetInfos());
            StringBuilder sigarStringBuffer = new StringBuilder();
            for (SigarInfoEntity sigarInfo : sigarInfos) {
                sigarStringBuffer.append(sigarInfo.getName()).append(":").append(sigarInfo.getValue()).append("\r\n");
            }
            System.out.println(sigarStringBuffer.toString());
        } catch (SigarException | UnknownHostException se) {
            se.printStackTrace();
        }

    }
}
