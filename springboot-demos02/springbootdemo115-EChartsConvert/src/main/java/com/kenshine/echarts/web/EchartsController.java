package com.kenshine.echarts.web;

import com.alibaba.fastjson.JSON;
import com.kenshine.echarts.utils.EchartsUtils;
import com.kenshine.echarts.utils.FreemarkerUtils;
import com.kenshine.echarts.utils.ImageUtils;
import freemarker.template.TemplateException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 8:56
 * @description：Echarts转换测试
 * @modified By：
 * @version: $
 */
@RestController
public class EchartsController {
    private static String url = "http://localhost:7777";

    /**
     * FreeMark生成柱状图
     * @param response
     * @throws IOException
     * @throws TemplateException
     */
    @GetMapping("/test01")
    public void getImage01(HttpServletResponse response) throws IOException, TemplateException {
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
        ImageUtils.convertBase64ToImage(base64, response.getOutputStream());
        response.setContentType("application/x-png");
    }

    /**
     * FreeMark生成折线图
     */
    @GetMapping("/test02")
    public void getImage02(HttpServletResponse response) throws IOException, TemplateException {
        // 标题
        String title = "资源增长情况";
        //legendData
        String[] legendData = new String[]{"ECS", "实例", "CPU", "MEM"};
        //xAxisData
        String[] xAxisData = new String[]{"2021-10-01", "2021-10-02", "2021-10-03", "2021-10-04", "2021-10-05"};
        //yAxis
        ArrayList<Map<String, Object>> yAxis = new ArrayList<Map<String, Object>>() {{
            add(new HashMap<String, Object>() {{
                put("type", "value");
                put("position", "left");
                put("name", "台");
            }});
            add(new HashMap<String, Object>() {{
                put("type", "value");
                put("position", "right");
                put("name", "使用量");
            }});
        }};

        //seriesData
        ArrayList<Map<String, Object>> series = new ArrayList<Map<String, Object>>() {{
            add(new HashMap<String, Object>() {{
                put("name", "ECS");
                put("type", "line");
                put("data", new int[]{100, 200, 210, 180, 260});
            }});
            add(new HashMap<String, Object>() {{
                put("name", "实例");
                put("type", "line");
                put("data", new int[]{320, 220, 268, 320, 330});
            }});
            add(new HashMap<String, Object>() {{
                put("name", "CPU");
                put("type", "line");
                put("data", new int[]{120, 110, 121, 110, 160});
            }});
            add(new HashMap<String, Object>() {{
                put("name", "MEM");
                put("type", "line");
                put("data", new int[]{320, 23, 65, 190, 285});
            }});
        }};

        // 模板参数
        HashMap<String, Object> datas = new HashMap<>();
        datas.put("xAxisData", JSON.toJSONString(xAxisData));
        datas.put("legendData", JSON.toJSONString(legendData));
        datas.put("title", title);
        datas.put("yAxis", JSON.toJSONString(yAxis));
        datas.put("data", JSON.toJSONString(series));


        // 生成option字符串
        String option = FreemarkerUtils.generateString("line.ftl", "classpath:ftl", datas);

        // 根据option参数
//        option = "{\"title\":{\"text\":\"资源增长情况\",\"x\":\"left\"},\"toolbox\":{\"feature\":{\"saveAsImage\":{\"show\":true,\"title\":\"保存为图片\",\"type\":\"png\",\"lang\":[\"点击保存\"]}},\"show\":true},\"tooltip\":{\"trigger\":\"axis\"},\"legend\":{\"data\":[\"ECS\",\"实例\",\"CPU\",\"MEM\"]},\"xAxis\":[{\"boundaryGap\":false,\"type\":\"category\",\"data\":[\"2019-03-09\",\"2019-03-02\",\"2019-03-16\"]}],\"yAxis\":[{\"type\":\"value\",\"position\":\"left\",\"name\":\"ECS台\",\"axisLine\":{\"lineStyle\":{\"color\":\"#1E90FF\"}}},{\"type\":\"value\",\"position\":\"left\",\"name\":\"容器实例台\",\"axisLine\":{\"lineStyle\":{\"color\":\"#8A2BE2\"}}}],\"series\":[{\"name\":\"ECS\",\"type\":\"line\",\"stack\":\"总量\",\"data\":[120,132,101,134,90,230,210]},{\"name\":\"实例\",\"type\":\"line\",\"stack\":\"总量\",\"data\":[220,182,191,234,290,330,310]},{\"name\":\"CPU\",\"type\":\"line\",\"stack\":\"总量\",\"data\":[150,232,201,154,190,330,410]},{\"name\":\"MEM\",\"type\":\"line\",\"stack\":\"总量\",\"data\":[150,232,201,154,190,330,410]}]}" ;
        String base64 = EchartsUtils.generateEchartsBase64(url, option);

        System.out.println("BASE64:" + base64);
        ImageUtils.convertBase64ToImage(base64, response.getOutputStream());
        response.setContentType("application/x-png");
    }


    /**
     * Echarts工具生成饼图
     * @return
     */
    @GetMapping("/test03")
    public String getImage03() throws IOException {
        String option = EchartsUtils.createPieByEcharts();

        String base64 = EchartsUtils.generateEchartsBase64(url, option);
        return "data:image/png;base64," + base64;
    }
}
