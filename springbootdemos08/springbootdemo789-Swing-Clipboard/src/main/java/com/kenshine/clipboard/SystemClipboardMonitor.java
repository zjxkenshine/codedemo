package com.kenshine.clipboard;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.*;
import java.io.IOException;

/**
 *  @author kenshine
 * 剪贴板监控器
 * 负责对剪贴板文本的监控和操作
 * 由于监控需要一个对象作为ClipboardOwner，故不能用静态类
 */
public class SystemClipboardMonitor implements ClipboardOwner {
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    public SystemClipboardMonitor() {
        //如果剪贴板中有文本，则将它的ClipboardOwner设为自己
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            clipboard.setContents(clipboard.getContents(null), this);
        }
    }

    /*
     * 测试代码
     */
    public static void main(String[] args) {
        SystemClipboardMonitor temp = new SystemClipboardMonitor();
        // 软件窗口
        new JFrame().setVisible(true);
    }

    /*
     * 如果剪贴板的内容改变，则系统自动调用此方法
     * 粘贴的文字变为 复制内容+ test
     */
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        // 如果不暂停一下，经常会抛出IllegalStateException
        // 猜测是操作系统正在使用系统剪切板，故暂时无法访问
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // 取出文本并进行一次文本处理
        String text = null;
        if (clipboard.isDataFlavorAvailable(DataFlavor.stringFlavor)) {
            try {
                text = (String) clipboard.getData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException | IOException e) {
                e.printStackTrace();
            }
        }
        // 自定义的处理方法
        String clearedText = text+" test";
        // 存入剪贴板，并注册自己为所有者
        StringSelection tmp = new StringSelection(clearedText);
        // 用以监控下一次剪贴板内容变化
        clipboard.setContents(tmp, this);
    }
}