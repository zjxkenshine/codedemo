package com.kenshine.clipboard;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname ClipboardTest
 * @Description 剪切板操作
 * @Date 2024-04-23 9:22
 * @modified By：
 * @version: 1.0$
 */
public class ClipboardTest {
    /**
     * 数据写入剪切板
     * Hello, Clipboard!
     */
    @Test
    public void test01(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        String text = "Hello, Clipboard!";
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, null);
    }

    /**
     * 从剪切板粘贴数据
     */
    @Test
    public void test02(){
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        Transferable contents = clipboard.getContents(null);
        DataFlavor flavor = DataFlavor.stringFlavor;
        if (contents.isDataFlavorSupported(flavor)) {
            try {
                String text = (String) contents.getTransferData(flavor);
                System.out.println("Pasted text: " + text);
            } catch (UnsupportedFlavorException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 监听剪切板内容变化
     * 更详细案例参考SystemClipboardMonitor
     */
    @Test
    public void test03() throws InterruptedException {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        ClipboardOwner owner = new ClipboardOwner() {
            @Override
            public void lostOwnership(Clipboard clipboard, Transferable contents) {
                System.out.println("Clipboard content changed");
            }
        };
        String text = "Hello, Clipboard!";
        StringSelection selection = new StringSelection(text);
        clipboard.setContents(selection, owner);
        Thread.sleep(10000);
    }

    /**
     * 图片复制
     */
    @Test
    public void test04() throws IOException {
        Image image= ImageIO.read(new File("img/test.jpg"));
        ImageSelection imgSel = new ImageSelection(image);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(imgSel, null);
    }

    /**
     * 获取并粘贴图片
     */
    @Test
    public void test05() throws IOException {
        Image image=ImageSelection.getImageClipboard();
        if (image != null) {
            System.out.println("Image width: " + image.getWidth(null));
            System.out.println("Image height: " + image.getHeight(null));
            ImageIO.write((RenderedImage) image, "jpg", new File("img/test_copy.jpg"));
        }
    }

    /**
     * 复制粘贴 自定义java类
     */
    @Test
    public void test06() throws IOException, UnsupportedFlavorException {
        //创建自定义剪切板对象 不使用系统默认剪切板
        Clipboard clipboard = new Clipboard("clipboardName");
        RangeDataModel data = new RangeDataModel();
        data.setName("kenshine");
        //构建数据对象 data为数据类型java类的对象
        TestSelection content = new TestSelection(data);
        clipboard.setContents(content, null);
        //Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);

        // 获取并粘贴
        if (content.isDataFlavorSupported(TestSelection.rangeFlavor)) {
            RangeDataModel data1 = (RangeDataModel) content.getTransferData(TestSelection.rangeFlavor);
            System.out.println(data1);
        }
    }

}
