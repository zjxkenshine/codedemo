package com.kenshine.echarts.test;

import com.alibaba.fastjson.JSON;
import com.kenshine.echarts.utils.EchartsUtils;
import com.kenshine.echarts.utils.FreemarkerUtils;
import com.kenshine.echarts.utils.ImageUtils;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 8:39
 * @description：測試
 * @modified By：
 * @version: $
 */
public class EchartsTest01 {
    private static String url = "http://localhost:7777";

    public static void main(String[] args) throws IOException, TemplateException {
        // 变量
        String title = "销量";
        String[] categories = new String[] { "2019", "2020", "2021" };
        int[] values = new int[] { 100, 105, 200 };

        // 模板参数
        HashMap<String, Object> datas = new HashMap<>();
        datas.put("categories", JSON.toJSONString(categories));
        datas.put("values", JSON.toJSONString(values));
        datas.put("title", title);

        // 生成option字符串
//        String option = FreemarkerUtils.generateString("option.ftl", "D:\IdeaWorkSpace\codedemo\springboot-demos02\springbootdemo115-EChartsConvert\src\main\resources\img", datas);
        String option = FreemarkerUtils.generateString("opt.ftl", "classpath:ftl", datas);

        // 根据option参数
        String base64 = EchartsUtils.generateEchartsBase64(url, option);
        System.out.println("BASE64:" + base64);

        File test = File.createTempFile("test", ".png");
        test.deleteOnExit();
        try (OutputStream os = new FileOutputStream(test)) {
            ImageUtils.convertBase64ToImage(base64, os);
        }
        System.out.println("测试完成");
    }
}
