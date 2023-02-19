package com.kenshine.opencv.utils;

import cn.hutool.core.codec.Base64;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author by kenshine
 * @Classname Base64
 * @Description TODO
 * @Date 23/2/19 10:29
 * @modified By：
 * @version: 1.0$
 */
public class Base64Utils {
//    private static final String separator = "/";
//    private final static ExecutorService executor = Executors.newCachedThreadPool();//启用多线程
//
//    //获取base64字符串
//    public static String encodeBase64(String fileName,boolean isSafe) {
//        if(StrUtil.isBlank(fileName)){
//            throw new NullPointerException();
//        }
//        InputStream in = null;
//        byte[] data = null;
//        String encodedText=null;
//        //读取图片字节数组
//        try {
//            in = new BufferedInputStream(new FileInputStream(fileName));
//            data = new byte[in.available()];
//            in.read(data);
//            in.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //对字节数组Base64编码
//
//        if(isSafe){
//            java.util.Base64.Encoder encoder = java.util.Base64.getUrlEncoder();
//            encodedText = encoder.encodeToString(data);
//        }else{
//            BASE64Encoder encoder = new BASE64Encoder();
//            encodedText=encoder.encode(data);
//            encodedText=encodedText.replaceAll("[\\s*\t\n\r]", "");
//        }
//        return encodedText;
//    }
//
//    //解析base64
//    public static String decodeBase64(String base64,String filePath,String suffix,boolean isSafe){
//        if(StrUtil.isBlank(base64)||StrUtil.isBlank(filePath)||StrUtil.isBlank(suffix)){
//            throw new NullPointerException();
//        }
//        OutputStream out=null;
//        String fileName=null;
//        try {
//            byte[] b=new byte[2048];
//            if(isSafe){
//                java.util.Base64.Decoder decoder = java.util.Base64.getUrlDecoder();
//                b = decoder.decode(base64);
//            }else{
//                BASE64Decoder decoder = new BASE64Decoder();
//                b = decoder.decodeBuffer(base64.substring(base64.indexOf(",") + 1));
//            }
//            for (int i = 0; i < b.length; ++i) {
//                if (b[i] < 0) {// 调整异常数据
//                    b[i] += 256;
//                }
//            }
//            File file=new File(filePath);
//            if(!file.exists()){
//                file.mkdirs();
//            }
//            fileName=filePath+System.currentTimeMillis()+"."+suffix;
//            out = new BufferedOutputStream(new FileOutputStream(fileName));
//            out.write(b);
//            out.flush();
//        }catch (Exception e) {
//
//        }finally {
//            if(out!=null){
//                try {
//                    out.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//
//            }
//        }
//
//        return fileName;
//    }
//
    /**
     * 文件BufferedImage类型转BASE64
     *
     * @param bufferedImage
     * @return
     */
    public static String imageToBase64(BufferedImage bufferedImage) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//io流
        try {
            ImageIO.write(bufferedImage, "png", baos);//写入流中
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = baos.toByteArray();//转换成字节
        BASE64Encoder encoder = new BASE64Encoder();
        String png_base64 = encoder.encodeBuffer(bytes).trim();//转换成base64串
        png_base64 = png_base64.replaceAll("\n", "").replaceAll("\r", "");//删除 \r\n
        return "data:image/png;base64," + png_base64;
    }

    /**
     * 文件File类型转BASE64
     *
     * @param file
     * @return
     */
    public static String fileToBase64(File file) {
        return "data:image/png;base64," + Base64.encode(fileToByte(file));
    }

    /**
     * 文件File类型转byte[]
     *
     * @param file
     * @return
     */
    private static byte[] fileToByte(File file) {
        byte[] fileBytes = null;
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fileBytes = new byte[(int) file.length()];
            fis.read(fileBytes);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileBytes;
    }

}
