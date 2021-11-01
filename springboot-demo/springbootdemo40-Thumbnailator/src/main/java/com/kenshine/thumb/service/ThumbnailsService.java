package com.kenshine.thumb.service;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 21:05
 * @description：实现
 * @modified By：
 * @version: $
 */
@Service
public class ThumbnailsService {

    /**
     * 指定大小缩放
     *
     * 指定大小缩放 若图片横比width小，高比height小，放大
     * 若图片横比width小，高比height大，高缩小到height，图片比例不变
     * 若图片横比width大，高比height小，横缩小到width，图片比例不变
     * 若图片横比width大，高比height大，图片按比例缩小，横为width或高为height
     *
     * @param resource  源文件路径
     * @param width     宽
     * @param height    高
     * @param tofile    生成文件路径
     */
    public void changeSize(String resource, int width, int height, String tofile) {
        try {
            Thumbnails.of(resource).size(width, height).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 参数为文件
     * @param file
     * @param width
     * @param height
     * @param tofile
     */
    public void changeSize2(MultipartFile file, int width, int height, String tofile) {
        try {
            Thumbnails.of(file.getInputStream()).size(width, height).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 指定比例缩放 scale(),参数小于1,缩小;大于1,放大
     *
     * @param resource   源文件路径
     * @param scale      指定比例
     * @param tofile     生成文件路径
     */
    public void changeScale(String resource, double scale, String tofile) {
        try {
            Thumbnails.of(resource).scale(scale).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 指定比例缩放 scale(),参数小于1,缩小;大于1,放大
     *
     * @param scale      指定比例
     * @param tofile     生成文件路径
     */
    public void changeScale2(MultipartFile file, double scale, String tofile) {
        try {
            Thumbnails.of(file.getInputStream()).scale(scale).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 添加水印 watermark(位置,水印,透明度)
     *
     * @param resource  源文件路径
     * @param p         水印位置
     * @param shuiyin   水印文件路径
     * @param opacity   水印透明度
     * @param tofile    生成文件路径
     */
    public void watermark(String resource, Positions p, String shuiyin, float opacity, String tofile) {
        try {
            Thumbnails.of(resource).scale(1).watermark(p, ImageIO.read(new File(shuiyin)), opacity).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加水印 watermark(位置,水印,透明度)
     *
     * @param file  源文件路径
     * @param p         水印位置
     * @param shuiyin   水印文件路径
     * @param opacity   水印透明度 0.0f~1.0f
     * @param tofile    生成文件路径
     */
    public void watermark2(MultipartFile file, Positions p, String shuiyin, float opacity, String tofile) {
        try {
            Thumbnails.of(file.getInputStream()).scale(1).watermark(p, ImageIO.read(new File(shuiyin)), opacity).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 图片旋转 rotate(度数),顺时针旋转
     *
     * @param resource  源文件路径
     * @param rotate    旋转度数
     * @param tofile    生成文件路径
     */
    public static void rotate(String resource, double rotate, String tofile) {
        try {
            Thumbnails.of(resource).scale(1).rotate(rotate).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * 图片旋转 rotate(度数),顺时针旋转
     *
     * @param file  源文件
     * @param rotate    旋转度数
     * @param tofile    生成文件路径
     */
    public  void rotate2(MultipartFile file, double rotate, String tofile) {
        try {
            Thumbnails.of(file.getInputStream()).scale(1).rotate(rotate).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 图片裁剪 sourceRegion()有多种构造方法，示例使用的是sourceRegion(裁剪位置,宽,高)
     *
     * @param resource  源文件路径
     * @param p         裁剪位置
     * @param width     裁剪区域宽
     * @param height    裁剪区域高
     * @param tofile    生成文件路径
     */
    public static void region(String resource, Positions p, int width, int height, String tofile) {
        try {
            Thumbnails.of(resource).scale(1).sourceRegion(p, width, height).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片裁剪 sourceRegion()有多种构造方法，示例使用的是sourceRegion(裁剪位置,宽,高)
     *
     * @param file  源文件路径
     * @param p         裁剪位置
     * @param width     裁剪区域宽
     * @param height    裁剪区域高
     * @param tofile    生成文件路径
     */
    public void region2(MultipartFile file, Positions p, int width, int height, String tofile) {
        try {
            Thumbnails.of(file.getInputStream()).scale(1).sourceRegion(p, width, height).toFile(tofile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
