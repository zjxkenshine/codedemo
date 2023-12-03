package com.kenshine.imgscalr;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/3 15:12
 * @description：缩放
 * @modified By：
 * @version: $
 */
public class ResizeTest {

    /**
     * 图片缩放
     */
    public static void resizeImage(String sourcePath, String targetPath, int targetWidth, int targetHeight) throws IOException {
        BufferedImage sourceImage = ImageIO.read(new File(sourcePath));
        BufferedImage targetImage = Scalr.resize(sourceImage, Scalr.Method.ULTRA_QUALITY, targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
        ImageIO.write(targetImage, "jpg", new File(targetPath));
    }

    /**
     * 图片剪裁
     */
    public static void cropImage(String sourcePath, String targetPath, int targetWidth, int targetHeight) throws IOException {
        BufferedImage sourceImage = ImageIO.read(new File(sourcePath));
        BufferedImage targetImage = Scalr.crop(sourceImage, sourceImage.getWidth() / 2 - targetWidth / 2, sourceImage.getHeight() / 2 - targetHeight / 2, targetWidth, targetHeight, Scalr.OP_ANTIALIAS);
        ImageIO.write(targetImage, "jpg", new File(targetPath));
    }

    /**
     * 测试
     */
    public static void main(String[] args) throws IOException {
        resizeImage("springbootdemo529-Imgscalr\\src\\main\\resources\\img\\test.jpg","springbootdemo529-Imgscalr\\src\\main\\resources\\img\\test01.jpg",400,266);
        cropImage("springbootdemo529-Imgscalr\\src\\main\\resources\\img\\test.jpg","springbootdemo529-Imgscalr\\src\\main\\resources\\img\\test02.jpg",400,266);
    }
}
