package com.kenshine.echarts.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.abel533.echarts.Legend;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.data.PieData;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Pie;
import org.apache.http.client.ClientProtocolException;

import java.io.IOException;
import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 8:37
 * @description：Echarts工具類
 * @modified By：
 * @version: $
 */
public class EchartsUtils {
    private static final String SUCCESS_CODE = "1";

    public static String generateEchartsBase64(String phantomjsUrl, String option) throws IOException {
        String base64 = "";
        if (option == null) {
            return base64;
        }
        option = option.replaceAll("\\s+", "").replaceAll("\"", "'");

        // 将option字符串作为参数发送给echartsConvert服务器
        Map<String, String> params = new HashMap<>();
        params.put("opt", option);
        String response = HttpUtil.post(phantomjsUrl, params, "utf-8");

        // 解析echartsConvert响应
        JSONObject responseJson = JSON.parseObject(response);
        String code = responseJson.getString("code");

        // 如果echartsConvert正常返回
        if (SUCCESS_CODE.equals(code)) {
            base64 = responseJson.getString("data");
        }
        // 未正常返回
        else {
            String string = responseJson.getString("msg");
            throw new RuntimeException(string);
        }
        return base64;
    }



    public static String createPieByEcharts() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put("NAME", "张三" + i);
            map.put("TOTAL", new Random().nextInt(50));
            list.add(map);
        }
        //创建Option
        Option option = new GsonOption();
        option.title(new Title().text("测试饼图").x("middle"));
        option.tooltip(Trigger.item);
        option.legend(new Legend().orient(Orient.vertical).left("left"));
        //饼图数据
        Pie pie = new Pie("测试饼图");
        //循环数据
        for (Map<String, Object> objectMap : list) {
            //饼图数据
            pie.data(new PieData(objectMap.get("NAME").toString(), objectMap.get("TOTAL")));
        }
        //设置数据
        option.series(pie);
        return option.toString().replace(" ", "");
    }

}
