package com.kenshine.exiftool;

import com.thebuzzmedia.exiftool.ExifTool;
import com.thebuzzmedia.exiftool.ExifToolBuilder;
import com.thebuzzmedia.exiftool.Tag;
import com.thebuzzmedia.exiftool.core.StandardTag;
import com.thebuzzmedia.exiftool.exceptions.UnsupportedFeatureException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author by kenshine
 * @Classname ExiftoolTest
 * @Description 使用测试
 * @Date 2023-12-04 8:31
 * @modified By：
 * @version: 1.0$
 */
public class ExiftoolTest {


    /**
     * 获取tag
     */
    @Test
    public void test01() throws Exception {
        System.setProperty("exiftool.path","D:\\Program1\\exiftool.exe");
        System.out.println(parse(new File("img/test.jpg")));
    }

    /**
     * 持续打开 enableStayOpen
     */
    @Test
    public void test02() throws Exception {
        System.setProperty("exiftool.path","D:\\Program1\\exiftool.exe");
        try (ExifTool exifTool = detect()) {
            System.out.println(parse(new File("img/test.jpg")));
        }
    }

    /**
     *
     */
    @Test
    public void test03(){
        System.setProperty("exiftool.path","D:\\Program1\\exiftool.exe");
        ExecutorService executor = Executors.newFixedThreadPool(10);


        try (ExifTool exifTool = detect1()) {
            Arrays.asList("D:\\Github\\codedemo\\springbootdemos06\\springbootdemo529-Imgscalr\\src\\main\\resources\\img\\test01.jpg","D:\\Github\\codedemo\\springbootdemos06\\springbootdemo529-Imgscalr\\src\\main\\resources\\img\\test02.jpg").forEach(image-> {
                executor.submit(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            System.out.println("Tags: " + parse(image));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            });
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }






    /**
     * 持续打开
     */
    private ExifTool detect() {
        try {
            return new ExifToolBuilder().enableStayOpen().build();
        } catch (UnsupportedFeatureException ex) {
            return new ExifToolBuilder().build();
        }
    }

    /**
     * 多线程读取
     */
    private ExifTool detect1() {
        return new ExifToolBuilder()
                .withPoolSize(10)
                .enableStayOpen()
                .build();
    }

    /**
     * 解析图片tag
     */
    public Map<Tag, String> parse(File image) throws Exception {
        // 必须先通过system property设置exiftool.path地址
        // 可以使用withPath方法设置图片地址
        try (ExifTool exifTool = new ExifToolBuilder().build()) {
            return exifTool.getImageMeta(image, Arrays.asList(
                    StandardTag.ISO,
                    StandardTag.X_RESOLUTION,
                    StandardTag.Y_RESOLUTION
            ));
        }
    }

    private Map<Tag, String> parse(String image) throws Exception {
        return parse(new File(image));
    }
}
