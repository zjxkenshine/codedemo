package com.kenshine.osmxbean;

import com.kenshine.osmxbean.bean.MonitorInfoBean;
import com.kenshine.osmxbean.service.MonitorServiceImpl;

/**
 * @author by kenshine
 * @Classname OsmxBeanTest
 * @Description OperatingSystemMXBean 监控测试
 * @Date 2023-10-17 10:08
 * @modified By：
 * @version: 1.0$
 */
public class OsmxBeanTest {

    public static void main(String[] args) throws Exception {
        MonitorInfoBean monitorInfo = new MonitorServiceImpl().getMonitorInfoBean();
        System.out.println(monitorInfo.getProcessDetail());
        System.out.println("cpu占有率=" + monitorInfo.getCpuRatio());
        System.out.println("总的物理内存=" + monitorInfo.getTotalMemorySize() + "MB");
        System.out.println("已使用的物理内存=" + monitorInfo.getUsedMemory() + "MB");
        System.out.println("进程总数=" + monitorInfo.getTotalProcess());
    }
}
