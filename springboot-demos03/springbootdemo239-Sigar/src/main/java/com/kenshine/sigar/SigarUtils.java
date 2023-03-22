package com.kenshine.sigar;

import org.hyperic.sigar.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author by kenshine
 * @Classname SigarUtils
 * @Description sigar工具类
 * @Date 2023/3/22 9:03
 * @modified By：
 * @version: 1.0$
 */
public class SigarUtils {
    private static Sigar sigar;
    /**
     * 获取sigar实体
     * @return
     */
    public static Sigar getInstance() {
        if (null == sigar) {
            sigar = new Sigar();
        }
        return sigar;
    }
    /**
     * 1.获取系统信息和jvm虚拟机信息
     *
     * @return
     * @throws UnknownHostException
     */
    public static List<SigarInfoEntity> getJvmInfos()
            throws UnknownHostException {
        List<SigarInfoEntity> jvmInfoList = new ArrayList<SigarInfoEntity>();
        Runtime r = Runtime.getRuntime();
        // 系统配置属性
        Properties sysProps = System.getProperties();
        // java对ip封装的对象
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        Map<String, String> envInfoMap = System.getenv();
        String userName = envInfoMap.get("USERNAME");// 获取用户名
        String computerName = envInfoMap.get("COMPUTERNAME");// 获取计算机名
        String userDomain = envInfoMap.get("USERDOMAIN");// 获取计算机域名
        jvmInfoList.add(new SigarInfoEntity(userName, "获取用户名"));
        jvmInfoList.add(new SigarInfoEntity(computerName, "获取计算机名"));
        jvmInfoList.add(new SigarInfoEntity(userDomain, "获取计算机域名"));
        jvmInfoList.add(new SigarInfoEntity(addr.getHostAddress(), "获取Ip"));
        jvmInfoList.add(new SigarInfoEntity(addr.getHostName(), "获取主机名称"));
        jvmInfoList.add(new SigarInfoEntity(String.valueOf(r.totalMemory()),
                "JVM总内存"));
        jvmInfoList.add(new SigarInfoEntity(String.valueOf(r.freeMemory()),
                "JVM剩余内存"));
        jvmInfoList.add(new SigarInfoEntity(String.valueOf(r
                .availableProcessors()), "jvm处理器个数"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.version"), "Java的运行环境版本"));
        jvmInfoList.add(new SigarInfoEntity(
                sysProps.getProperty("java.vendor"), "Java的运行环境供应商"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.vendor.url"), "Java供应商的URL"));
        jvmInfoList.add(new SigarInfoEntity(sysProps.getProperty("java.home"),
                "Java的安装路径"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.vm.specification.version"), "Java的虚拟机规范版本"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.vm.specification.vendor"), "Java的虚拟机规范供应商"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.vm.specification.name"), "Java的虚拟机规范名称"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.vm.version"), "Java的虚拟机实现版本"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.vm.vendor"), "Java的虚拟机实现供应商"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.vm.name"), "Java的虚拟机实现名称"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.specification.version"), "Java运行时环境规范版本"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.specification.vendor"), "Java运行时环境规范供应商"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.specification.name"), "Java的虚拟机规范名称"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.class.version"), "Java的类格式版本号"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.class.path"), "Java的类路径"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.library.path"), "加载库时搜索的路径列表"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.io.tmpdir"), "默认的临时文件路径"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("java.ext.dirs"), "一个或多个扩展目录的路径"));
        jvmInfoList.add(new SigarInfoEntity(sysProps.getProperty("os.name"),
                "操作系统的名称"));
        jvmInfoList.add(new SigarInfoEntity(sysProps.getProperty("os.arch"),
                "操作系统的构架"));
        jvmInfoList.add(new SigarInfoEntity(sysProps.getProperty("os.version"),
                "操作系统的版本"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("file.separator"), "文件分隔符"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("path.separator"), "路径分隔符"));
        jvmInfoList.add(new SigarInfoEntity(sysProps
                .getProperty("line.separator"), "行分隔符"));
        jvmInfoList.add(new SigarInfoEntity(sysProps.getProperty("user.name"),
                "用户的账户名称"));
        jvmInfoList.add(new SigarInfoEntity(sysProps.getProperty("user.home"),
                "用户的主目录"));
        jvmInfoList.add(new SigarInfoEntity(sysProps.getProperty("user.dir"),
                "用户的当前工作目录"));
        return jvmInfoList;
    }
    /**
     * 2.获取cpu信息
     *
     * @return
     * @throws SigarException
     */
    public static List<SigarInfoEntity> getCpuInfos() throws SigarException {
        List<SigarInfoEntity> cpuInfoList = new ArrayList<SigarInfoEntity>();
        CpuInfo[] cpuInfos = getInstance().getCpuInfoList();
        CpuPerc[] cpuPercs = getInstance().getCpuPercList();
        for (int i = 0; i < cpuInfos.length; i++) {
            CpuInfo cpuInfo = cpuInfos[i];
            cpuInfoList.add(new SigarInfoEntity(String.valueOf(i), "第" + i
                    + "个CPU信息"));
            cpuInfoList.add(new SigarInfoEntity(
                    String.valueOf(cpuInfo.getMhz()), "CPU的总量MHz" + i));
            cpuInfoList.add(new SigarInfoEntity(cpuInfo.getVendor(),
                    "获得CPU的供应商" + i));
            cpuInfoList.add(new SigarInfoEntity(cpuInfo.getModel(), "获得CPU的类别"
                    + i));
            cpuInfoList.add(new SigarInfoEntity(String.valueOf(cpuInfo
                    .getCacheSize()), "缓冲存储器数量" + i));
        }
        for (int i = 0; i < cpuPercs.length; i++) {
            CpuPerc cpuPerc = cpuPercs[i];
            cpuInfoList.add(new SigarInfoEntity(String.valueOf(i), "第" + i
                    + "个CPU片段"));
            cpuInfoList.add(new SigarInfoEntity(String.valueOf(cpuPerc
                    .getUser()), "CPU用户使用率" + i));
            cpuInfoList.add(new SigarInfoEntity(
                    String.valueOf(cpuPerc.getSys()), "CPU系统使用率" + i));
            cpuInfoList.add(new SigarInfoEntity(String.valueOf(cpuPerc
                    .getWait()), "CPU当前等待率" + i));
            cpuInfoList.add(new SigarInfoEntity(String.valueOf(cpuPerc
                    .getNice()), "CPU当前错误率" + i));
            cpuInfoList.add(new SigarInfoEntity(String.valueOf(cpuPerc
                    .getIdle()), "CPU当前空闲率" + i));
            cpuInfoList.add(new SigarInfoEntity(String.valueOf(cpuPerc
                    .getCombined()), "CPU总的使用率" + i));
        }
        return cpuInfoList;
    }
    /**
     * 3.获取内存信息
     *
     * @return
     * @throws SigarException
     */
    public static List<SigarInfoEntity> getMemoryInfos() throws SigarException {
        List<SigarInfoEntity> memoryInfoList = new ArrayList<SigarInfoEntity>();
        Mem mem = getInstance().getMem();
        memoryInfoList.add(new SigarInfoEntity(mem.getTotal() / 1024L + "K av",
                "内存总量"));
        memoryInfoList.add(new SigarInfoEntity(
                mem.getUsed() / 1024L + "K used", "当前内存使用量"));
        memoryInfoList.add(new SigarInfoEntity(
                mem.getFree() / 1024L + "K free", "当前内存剩余量"));
        Swap swap = getInstance().getSwap();
        memoryInfoList.add(new SigarInfoEntity(
                swap.getTotal() / 1024L + "K av", "交换区总量"));
        memoryInfoList.add(new SigarInfoEntity(swap.getUsed() / 1024L
                + "K used", "当前交换区使用量"));
        memoryInfoList.add(new SigarInfoEntity(swap.getFree() / 1024L
                + "K free", "当前交换区剩余量"));
        return memoryInfoList;
    }
    /**
     * 4.获取操作系统信息
     *
     * @return
     */
    public static List<SigarInfoEntity> getOsInfos() {
        List<SigarInfoEntity> osInfoList = new ArrayList<SigarInfoEntity>();
        OperatingSystem os = OperatingSystem.getInstance();
        osInfoList.add(new SigarInfoEntity(os.getArch(), "操作系统"));
        osInfoList
                .add(new SigarInfoEntity(os.getCpuEndian(), "操作系统CpuEndian()"));
        osInfoList
                .add(new SigarInfoEntity(os.getDataModel(), "操作系统DataModel()"));
        osInfoList.add(new SigarInfoEntity(os.getDescription(), "操作系统的描述"));
        osInfoList.add(new SigarInfoEntity(os.getVendor(), "操作系统的供应商"));
        osInfoList
                .add(new SigarInfoEntity(os.getVendorCodeName(), "操作系统的供应商编号"));
        osInfoList.add(new SigarInfoEntity(os.getVendorName(), "操作系统的供应商名称"));
        osInfoList.add(new SigarInfoEntity(os.getVendorVersion(), "操作系统供应商类型"));
        osInfoList.add(new SigarInfoEntity(os.getVersion(), "操作系统的版本号"));
        return osInfoList;
    }
    /**
     * 5.获取文件信息
     *
     * @return
     * @throws SigarException
     */
    public static List<SigarInfoEntity> getFileInfos() throws SigarException {
        List<SigarInfoEntity> fileInfoList = new ArrayList<SigarInfoEntity>();
        FileSystem fslist[] = getInstance().getFileSystemList();
        for (int i = 0; i < fslist.length; i++) {
            FileSystem fs = fslist[i];
            fileInfoList.add(new SigarInfoEntity(i + "", "分区的盘符号" + i));
            fileInfoList.add(new SigarInfoEntity(fs.getDevName(), "盘符名称" + i));
            fileInfoList.add(new SigarInfoEntity(fs.getDirName(), "盘符路径" + i));
            fileInfoList
                    .add(new SigarInfoEntity(fs.getFlags() + "", "盘符标志" + i));
            fileInfoList.add(new SigarInfoEntity(fs.getSysTypeName(),
                    "盘符类型(FAT32,NTFS)" + i));
            fileInfoList
                    .add(new SigarInfoEntity(fs.getTypeName(), "盘符类型名" + i));
            fileInfoList.add(new SigarInfoEntity(fs.getType() + "", "盘符文件系统类型"
                    + i));
            FileSystemUsage usage = null;
            usage = getInstance().getFileSystemUsage(fs.getDirName());
            switch (fs.getType()) {
                case 0: // TYPE_UNKNOWN ：未知
                    break;
                case 1: // TYPE_NONE
                    break;
                case 2: // TYPE_LOCAL_DISK : 本地硬盘
                    fileInfoList.add(new SigarInfoEntity(usage.getTotal() + "KB",
                            "文件系统总大小" + fs.getDevName()));
                    fileInfoList.add(new SigarInfoEntity(usage.getFree() + "KB",
                            "文件系统剩余大小" + fs.getDevName()));
                    fileInfoList.add(new SigarInfoEntity(usage.getAvail() + "KB",
                            "文件系统可用大小" + fs.getDevName()));
                    fileInfoList.add(new SigarInfoEntity(usage.getUsed() + "KB",
                            "文件系统已经使用量" + fs.getDevName()));
                    fileInfoList.add(new SigarInfoEntity(usage.getUsePercent()
                            * 100D + "%", "文件系统资源的利用率" + fs.getDevName()));
                    break;
                case 3:// TYPE_NETWORK ：网络
                    break;
                case 4:// TYPE_RAM_DISK ：闪存
                    break;
                case 5:// TYPE_CDROM ：光驱
                    break;
                case 6:// TYPE_SWAP ：页面交换
                    break;
            }
            fileInfoList.add(new SigarInfoEntity(usage.getDiskReads() + "", fs
                    .getDevName() + "读出"));
            fileInfoList.add(new SigarInfoEntity(usage.getDiskWrites() + "", fs
                    .getDevName() + "写入"));
        }
        return fileInfoList;
    }
    /**
     * 6.获取网络信息
     *
     * @return
     * @throws SigarException
     */
    public static List<SigarInfoEntity> getNetInfos() throws SigarException {
        List<SigarInfoEntity> netInfoList = new ArrayList<SigarInfoEntity>();
        String nIfNames[] = getInstance().getNetInterfaceList();
        for (int i = 0; i < nIfNames.length; i++) {
            String name = nIfNames[i];
            NetInterfaceConfig nIfConfig = getInstance().getNetInterfaceConfig(
                    name);
            netInfoList.add(new SigarInfoEntity(name, "网络设备名" + i));
            netInfoList.add(new SigarInfoEntity(nIfConfig.getAddress(), "IP地址"
                    + i));
            netInfoList.add(new SigarInfoEntity(nIfConfig.getNetmask(), "子网掩码"
                    + i));
            if ((nIfConfig.getFlags() & 1L) <= 0L) {
                System.out.println("getNetInterfaceStat not exist");
                continue;
            }
            NetInterfaceStat nIfStat = getInstance().getNetInterfaceStat(name);
            netInfoList.add(new SigarInfoEntity(nIfStat.getRxPackets() + "",
                    "接收的总包裹数" + i));
            netInfoList.add(new SigarInfoEntity(nIfStat.getTxPackets() + "",
                    "发送的总包裹数" + i));
            netInfoList.add(new SigarInfoEntity(nIfStat.getRxBytes() + "",
                    "接收到的总字节数" + i));
            netInfoList.add(new SigarInfoEntity(nIfStat.getTxBytes() + "",
                    "发送的总字节数" + i));
            netInfoList.add(new SigarInfoEntity(nIfStat.getRxErrors() + "",
                    "接收到的错误包数" + i));
            netInfoList.add(new SigarInfoEntity(nIfStat.getTxErrors() + "",
                    "发送数据包时的错误数" + i));
            netInfoList.add(new SigarInfoEntity(nIfStat.getRxDropped() + "",
                    "接收时丢弃的包数" + i));
            netInfoList.add(new SigarInfoEntity(nIfStat.getTxDropped() + "",
                    "发送时丢弃的包数" + i));
        }
        return netInfoList;
    }
}
