package com.kenshine.thumb.web;

import com.kenshine.thumb.service.ThumbnailsService;
import com.kenshine.thumb.util.FileUtils;
import net.coobird.thumbnailator.geometry.Positions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 21:02
 * @description：测试
 * @modified By：
 * @version: $
 */
@RestController
public class ThumbnailsController {
    @Resource
    private ThumbnailsService thumbnailsService;

    /**
     * 指定大小缩放
     * @param file
     * @param width
     * @param height
     * @return
     * localhost:8080/changeSize?width=640&height=360
     */
    @GetMapping("/changeSize")
    public String changeSize(MultipartFile file, int width, int height) {
        String toFile="F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo40-Thumbnailator\\src\\main\\resources\\img\\changeSize";
        thumbnailsService.changeSize2(file, width, height,toFile);
        return "success";
    }

    /**
     * 指定比例缩放
     * @param file
     * @param scale
     * @return
     *
     */
    @GetMapping("/changeScale")
    public String changeScale(MultipartFile file, double scale) {
        String toFile="F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo40-Thumbnailator\\src\\main\\resources\\img\\changeScale";
        thumbnailsService.changeScale2(file, scale,toFile);
        return "success";
    }


    /**
     * 添加水印 watermark(位置,水印,透明度)
     * @param file 源文件
     * @param opacity  水印透明度 0~1 f
     * @return
     * localhost:8080/watermark?opacity=0.3
     */
    @GetMapping("/watermark")
    public String watermark(MultipartFile file, float opacity) {
        //水印图片地址
        String shuiyin = "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo40-Thumbnailator\\src\\main\\resources\\shuiyin\\shuiyin.jpeg";
        //图片输出地址及名称
        String toFile="F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo40-Thumbnailator\\src\\main\\resources\\img\\watermark";
        thumbnailsService.watermark2(file, Positions.CENTER, shuiyin, opacity,toFile);
        return "success";
    }


    /**
     * 图片旋转 rotate(度数),顺时针旋转
     * @param file
     * @param rotate
     * @return
     *
     * localhost:8080/rotate?rotate=90
     */
    @GetMapping("/rotate")
    public String rotate(MultipartFile file, double rotate) {
        String toFile="F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo40-Thumbnailator\\src\\main\\resources\\img\\rotate";
        thumbnailsService.rotate2(file, rotate,toFile);
        return "success";
    }



    /**
     * 图片裁剪
     * @param width
     * @param height
     * @return
     *
     *
     */
    @GetMapping("/region")
    public String region(MultipartFile file, int width, int height) {
        String toFile="F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo40-Thumbnailator\\src\\main\\resources\\img\\region";
        thumbnailsService.region2(file, Positions.CENTER, width, height,toFile);
        return "success";
    }



}
