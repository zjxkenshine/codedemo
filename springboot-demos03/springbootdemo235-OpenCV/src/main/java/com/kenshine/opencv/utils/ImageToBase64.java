package com.kenshine.opencv.utils;

import org.apache.tomcat.util.codec.binary.Base64;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author by kenshine
 * @Classname ImageToBase64
 * @Description TODO
 * @Date 23/2/19 10:24
 * @modified By：
 * @version: 1.0$
 */
public class ImageToBase64 {
    //图片转化成base64字符串
    public static String GetImageStr(String path,int width,int height) throws IOException
    {//将图片文件转化为字节数组字符串，并对其进行Base64编码处理
        File srcFile = new File(path);//文件上服务器上面的地址
        if (!srcFile.exists())
            return "";
        Image srcImg = ImageIO.read(srcFile);
        // 生成指定大小图片
        BufferedImage buffImg = null;
        int oldWidth = srcImg.getWidth(null);
        int oldHeight = srcImg.getHeight(null);
        // 计算原图等比缩放长宽
        if (oldWidth * height > width * oldHeight) {
            oldHeight = width * oldHeight / oldWidth;
            oldWidth = width;
        } else {
            oldWidth = height * oldWidth / oldHeight;
            oldHeight = height;
        }
        // 生成新图
        buffImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // 填白
        buffImg.getGraphics().fillRect(0, 0, width, height);
        // 填入原图
        buffImg.getGraphics().drawImage(srcImg.getScaledInstance(oldWidth, oldHeight, Image.SCALE_SMOOTH),
                (width - oldWidth) / 2, (height - oldHeight) / 2, null);

        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        ImageOutputStream imOut = ImageIO.createImageOutputStream(bs);
        ImageIO.write(buffImg, "jpg", imOut);

        InputStream in = new ByteArrayInputStream(bs.toByteArray());
        byte[] data = null;
        //读取图片字节数组
        try
        {
            data = new byte[in.available()];
            in.read(data);
            in.close();
        }
        catch (IOException e)
        {
            return "";
        }
        //String fileName=srcFile.getName();
        //String prefix="data:image/jpg"+fileName.substring(fileName.lastIndexOf(".")+1)+";base64,";
        String prefix="data:image/jpg;base64,";
        //返回Base64编码过的字节数组字符串
        return prefix+ Base64.encodeBase64String(data);
    }
}
