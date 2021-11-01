package com.kenshine.tess4j.main;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/1 22:26
 * @description：测试
 * @modified By：
 * @version: $
 */
public class OCRTest {

    public static void main(String[] args) {
        // 识别图片的路径（修改为自己的图片路径）
        String path = "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo41-Tess4J\\src\\main\\resources\\img\\1.png";

        // 语言库位置（修改为跟自己语言库文件夹的路径）
        String lagnguagePath = "F:\\IDEAworkespace\\codedemo\\springboot-demo\\springbootdemo41-Tess4J\\src\\main\\resources\\tessdata";

        File file = new File(path);
        ITesseract instance = new Tesseract();

        //设置训练库的位置
        instance.setDatapath(lagnguagePath);

        //chi_sim ：简体中文， eng    根据需求选择语言库
        //instance.setLanguage("eng");
        instance.setLanguage("chi_sim");
        String result = null;
        try {
            long startTime = System.currentTimeMillis();
            result =  instance.doOCR(file);
            long endTime = System.currentTimeMillis();
            System.out.println("Time is：" + (endTime - startTime) + " 毫秒");
        } catch (TesseractException e) {
            e.printStackTrace();
        }

        //解决报错
        instance.setTessVariable("user_defined_dpi", "300");

        System.out.println("result: ");
        System.out.println(result);
    }
}
