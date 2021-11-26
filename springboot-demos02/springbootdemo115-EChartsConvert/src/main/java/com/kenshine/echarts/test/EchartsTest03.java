package com.kenshine.echarts.test;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Pie;
import com.kenshine.echarts.utils.EchartsUtils;
import com.kenshine.echarts.utils.ImageUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 9:14
 * @description：Echarts工具生成饼图
 * @modified By：
 * @version: $
 */
public class EchartsTest03 {
    private static String url = "http://localhost:7777";

    public static void main(String[] args) throws IOException {
        String option = EchartsUtils.createPieByEcharts();

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
