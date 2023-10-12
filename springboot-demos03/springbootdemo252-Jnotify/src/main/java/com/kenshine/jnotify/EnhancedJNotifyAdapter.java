package com.kenshine.jnotify;

import net.contentobjects.jnotify.JNotify;
import net.contentobjects.jnotify.JNotifyAdapter;
import net.contentobjects.jnotify.JNotifyException;

/**
 * @author by kenshine
 * @Classname EnhancedJNotifyAdapter
 * @Description Jnotify适配器
 * @Date 2023-10-12 8:22
 * @modified By：
 * @version: 1.0$
 */

public class EnhancedJNotifyAdapter extends JNotifyAdapter {
    private static final String REQUEST_BASE_PATH = "E://test";
    /** 被监视的目录 */
    String path = REQUEST_BASE_PATH;
    /** 关注目录的事件 */
    int mask = JNotify.FILE_CREATED | JNotify.FILE_DELETED | JNotify.FILE_MODIFIED | JNotify.FILE_RENAMED;
    /** 是否监视子目录，即级联监视 */
    boolean watchSubtree = true;
    /** 监听程序Id */
    public int watchID;

    public static void main(String[] args) {
        new EnhancedJNotifyAdapter().beginWatch();
    }

    /**
     * 容器启动时启动监视程序
     *
     * @return
     */
    public void beginWatch() {
        /** 添加到监视队列中 */
        try {
            this.watchID = JNotify.addWatch(path, mask, watchSubtree, this);
            System.err.println("jnotify -----------启动成功-----------");
        } catch (JNotifyException e) {
            e.printStackTrace();
        }
        // 死循环，线程一直执行，休眠一分钟后继续执行，主要是为了让主线程一直执行
        // 休眠时间和监测文件发生的效率无关（就是说不是监视目录文件改变一分钟后才监测到，监测几乎是实时的，调用本地系统库）
        while (true) {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {// ignore it
            }
        }
    }

    /**
     * 当监听目录下一旦有新的文件被创建，则即触发该事件
     *
     * @param wd
     *            监听线程id
     * @param rootPath
     *            监听目录
     * @param name
     *            文件名称
     */
    public void fileCreated(int wd, String rootPath, String name) {
        System.err.println("文件被创建, 创建位置为： " + rootPath + "/" + name);
    }

    public void fileRenamed(int wd, String rootPath, String oldName, String newName) {
        System.err.println("文件被重命名, 原文件名为：" + rootPath + "/" + oldName
                + ", 现文件名为：" + rootPath + "/" + newName);
    }

    public void fileModified(int wd, String rootPath, String name) {
        System.err.println("文件内容被修改, 文件名为：" + rootPath + "/" + name);
    }

    public void fileDeleted(int wd, String rootPath, String name) {
        System.err.println("文件被删除, 被删除的文件名为：" + rootPath + name);
    }
}