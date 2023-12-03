package com.kenshine.imgscalr;

import org.imgscalr.Scalr;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/3 15:18
 * @description：以图搜图
 * @modified By：
 * @version: $
 */
public class SearchTest {

    public static void main(String[] args) {
        // 选择一个图像作为查询图像
        File queryImageFile = new File("springbootdemo529-Imgscalr\\src\\main\\resources\\img\\test.jpg");

        // 读取查询图像
        BufferedImage queryImage = null;
        try {
            queryImage = ImageIO.read(queryImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 缩放查询图像到指定大小
        BufferedImage scaledImage = Scalr.resize(queryImage, 100);

        // 计算查询图像的特征向量
        int[] featureVector = new int[scaledImage.getWidth() * scaledImage.getHeight()];
        int index = 0;
        for (int y = 0; y < scaledImage.getHeight(); y++) {
            for (int x = 0; x < scaledImage.getWidth(); x++) {
                featureVector[index++] = scaledImage.getRGB(x, y);
            }
        }

        // 执行图像搜索
        performImageSearch(featureVector);
    }

    private static void performImageSearch(int[] featureVector) {
        // 在这里执行图像搜索的逻辑
        // 比较数据库中的图像特征值
        System.out.println(featureVector.length);
    }
}
