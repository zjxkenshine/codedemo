package com.kenshine.opencv.utils;

import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @Classname MatUtil
 * @Description TODO
 * @Date 23/2/19 8:32
 * @author by kenshine
 * @modified By：
 * @version: 1.0$
 */
public class MatUtil {
    /**
     * Base64 编码转换为 BufferedImage
     *
     * @param base64 图片Base64
     * @return BufferedImage
     */
    public static BufferedImage base64ToBufferedImage(String base64) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] buffer = decoder.decodeBuffer(base64);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
            return ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Mat 转换成 byte[]
     *
     * @param mat Mat对象
     * @return byte[]
     */
    public static byte[] toByteArray(Mat mat) {
        MatOfByte mob = new MatOfByte();
        Imgcodecs.imencode(".jpg", mat, mob);
        return mob.toArray();
    }

    /**
     * byte[] 转 图片Base64
     *
     * @param bytes byte[]
     * @return Base64
     */
    public static String byteArray2Base64(byte[] bytes) {
        return DatatypeConverter.printBase64Binary(bytes);
    }

    /**
     * Mat 转 图片Base64
     *
     * @param mat Mat
     * @return 图片Base64
     */
    public static String mat2Base64(Mat mat) {
        return byteArray2Base64(toByteArray(mat));
    }

    /**
     * Mat 转换成 BufferedImage
     *
     * @param mat Mat
     * @return BufferedImage
     */
    public static BufferedImage toBufferedImage(Mat mat) throws IOException {
        byte[] buffer = toByteArray(mat);
        ByteArrayInputStream inputStream = new ByteArrayInputStream(buffer);
        return ImageIO.read(inputStream);
    }

    /**
     * Base64 转换成 Mat
     *
     * @param base64 图片Base64
     * @return Mat
     */
    public static Mat base642Mat(String base64) {
        return bufImg2Mat(base64ToBufferedImage(base64), BufferedImage.TYPE_3BYTE_BGR, CvType.CV_8UC3);
    }

    /**
     * BufferedImage 转换成 Mat
     *
     * @param original 要转换的BufferedImage
     * @param imgType  bufferedImage的类型 如 BufferedImage.TYPE_3BYTE_BGR
     * @param matType  转换成mat的type 如 CvType.CV_8UC3
     *                 https://wenku.baidu.com/view/3cd5e54b5bfafab069dc5022aaea998fcc2240a1.html
     */
    public static Mat bufImg2Mat(BufferedImage original, int imgType, int matType) {
        if (original == null) {
            throw new IllegalArgumentException("original == null");
        }
        // Don't convert if it already has correct type
        if (original.getType() != imgType) {
            // Create a buffered image
            BufferedImage image = new BufferedImage(original.getWidth(), original.getHeight(), imgType);
            // Draw the image onto the new buffer
            Graphics2D g = image.createGraphics();
            try {
                g.setComposite(AlphaComposite.Src);
                g.drawImage(original, 0, 0, null);
                original = image;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                g.dispose();
            }
        }
        byte[] pixels = ((DataBufferByte) original.getRaster().getDataBuffer()).getData();
        Mat mat = Mat.eye(original.getHeight(), original.getWidth(), matType);
        mat.put(0, 0, pixels);
        return mat;
    }

}
