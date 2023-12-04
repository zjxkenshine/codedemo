package com.kenshine.mediautil;

import mediautil.gen.directio.SplitInputStream;
import mediautil.image.jpeg.LLJTran;
import mediautil.image.jpeg.LLJTranException;
import org.junit.Test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;

/**
 * @author by kenshine
 * @Classname MediaUtilTest
 * @Description MediaUtil使用测试
 * @Date 2023-12-04 9:49
 * @modified By：
 * @version: 1.0$
 */
public class MediaUtilTest {

    /**
     * 为图片添加文字水印
     * 未使用MediaUtil
     */
    @Test
    public void test01(){
        createMark("img/test01.jpg", "img/test01new.jpg", "014312406036",
                Color.BLACK, 1.0F, "Times New Roman", 30);
    }

    /**
     * MediaUtil复制图片信息
     */
    @Test
    public void test02(){
        //旧文件的流
        InputStream inOld = null;
        SplitInputStream sipOld = null;
        InputStream subIpOld = null;
        LLJTran lljOld = null;
        InputStream inNew = null;
        OutputStream outNew = null;
        try {
            //从旧文件中获取图片信息
            inOld = new BufferedInputStream(new FileInputStream("img/test01.jpg"));
            sipOld = new SplitInputStream(inOld);
            subIpOld = sipOld.createSubStream();
            lljOld = new LLJTran(subIpOld);
            lljOld.initRead(LLJTran.READ_HEADER, true, true);
            sipOld.attachSubReader(lljOld, subIpOld);
            sipOld.wrapup();
            inNew = new BufferedInputStream(new FileInputStream("img/test01.jpg"));
            outNew = new BufferedOutputStream(new FileOutputStream("img/test02.jpg"));
            lljOld.xferInfo(inNew, outNew, LLJTran.REPLACE, LLJTran.REPLACE);

            } catch (LLJTranException | IOException e) {
                e.printStackTrace();
            }
    }

    /**
     * MediaUtil复制图片信息
     */
    @Test
    public void test03(){
        //旧文件的流
        InputStream inOld = null;
        SplitInputStream sipOld = null;
        InputStream subIpOld = null;
        LLJTran lljOld = null;
        //新文件的流
        InputStream inNew = null;
        SplitInputStream sipNew = null;
        InputStream subIpNew = null;
        LLJTran lljNew = null;

        OutputStream out = null;
        try {
            //从旧文件中获取图片信息
            inOld = new BufferedInputStream(new FileInputStream("img/test01.jpg"));
            sipOld = new SplitInputStream(inOld);
            subIpOld = sipOld.createSubStream();
            lljOld = new LLJTran(subIpOld);
            lljOld.initRead(LLJTran.READ_HEADER, true, true);
            sipOld.attachSubReader(lljOld, subIpOld);
            sipOld.wrapup();

            out = new BufferedOutputStream(new FileOutputStream("img/test03.jpg"));
            // 输出并修改图片信息
            lljOld.xferInfo(inOld, out, LLJTran.REPLACE, LLJTran.REPLACE);

            //新图片信息
            inNew = new BufferedInputStream(new FileInputStream("img/test03.jpg"));
            sipNew = new SplitInputStream(inNew);
            subIpNew = sipOld.createSubStream();
            lljNew = new LLJTran(subIpNew);
            lljNew.initRead(LLJTran.READ_HEADER, true, true);
            sipNew.attachSubReader(lljNew, subIpNew);
            sipNew.wrapup();
        } catch (IOException | LLJTranException e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加水印
     */
    public static boolean createMark(String filePath, String filePath1,
                                     String markContent, Color markContentColor, float qualNum,
                                     String fontType, int fontSize) {
        ImageIcon imgIcon = new ImageIcon(filePath);
        Image theImg = imgIcon.getImage();
        // Image可以获得 输入图片的信息
        int width = theImg.getWidth(null);
        System.out.println(width);
        int height = theImg.getHeight(null);
        System.out.println(height);
        Object pro = theImg.getProperty("", null);
        System.out.println(pro);
        // 800 800 为画出图片的大小
        BufferedImage bimage = new BufferedImage(width, height,
                BufferedImage.TYPE_INT_RGB);
        // 2d 画笔
        Graphics2D g = bimage.createGraphics();
        g.setColor(markContentColor);
        g.setBackground(Color.white);

        // 画出图片-----------------------------------
        g.drawImage(theImg, 0, 0, null);
        // 画出图片-----------------------------------

        // --------对要显示的文字进行处理--------------
        AttributedString ats = new AttributedString(markContent);
        Font f = new Font(fontType, Font.ITALIC, fontSize);
        ats.addAttribute(TextAttribute.FONT, f, 0, markContent.length());
        AttributedCharacterIterator iter = ats.getIterator();
        // ----------------------
        g.drawString(iter, 80, height - 20);
        // 添加水印的文字和设置水印文字出现的内容 ----位置
        g.dispose();// 画笔结束
        try {
            // 输出 文件 到指定的路径
            FileOutputStream out = new FileOutputStream(filePath1);
//            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//
//            JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bimage);
//            param.setDensityUnit(JPEGEncodeParam.DENSITY_UNIT_DOTS_INCH);
//            param.setXDensity(150);
//            param.setYDensity(150);
//            param.setQuality(qualNum, true);
//            encoder.encode(bimage, param);
            /**
             * 输出一个文件 JPEGImageEncoderjava8之后不支持
             */
            ImageIO.write(bimage, "jpg", out);
            out.close();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
