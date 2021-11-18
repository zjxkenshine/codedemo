package com.kenshine.poitl.demo02;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.PictureType;
import com.deepoove.poi.data.Pictures;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/18 17:25
 * @description：图片
 * @modified By：
 * @version: $
 */
public class test03 {

    public static void main(String[] args) throws IOException {

        XWPFTemplate template = XWPFTemplate.compile("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo02\\test03.docx").render(
                new HashMap<String, Object>(){{
                    // 指定图片路径
                    put("image", "D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\img\\1.jpg");

                    // 设置图片宽高
                    put("image1", Pictures.ofLocal("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\img\\1.jpg").size(120, 120).create());

                    // 图片流
                    put("streamImg", Pictures.ofStream(new FileInputStream("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\img\\1.jpg"), PictureType.JPEG)
                            .size(100, 120).create());

                    // 网络图片(注意网络耗时对系统可能的性能影响)
                    put("urlImg", Pictures.ofUrl("http://deepoove.com/images/icecream.png")
                            .size(100, 100).create());

                    // svg图片
                    put("svg", "https://img.shields.io/badge/jdk-1.6%2B-orange.svg");

//                    // java图片
//                    put("buffered", Pictures.ofBufferedImage(bufferImage, PictureType.PNG)
//                            .size(100, 100).create());
                }});
        template.writeAndClose(new FileOutputStream("D:\\IdeaWorkSpace\\codedemo\\springboot-demos02\\springbootdemo100-Poi-tl\\src\\main\\resources\\temp\\demo02\\test03out.docx"));

    }

}
