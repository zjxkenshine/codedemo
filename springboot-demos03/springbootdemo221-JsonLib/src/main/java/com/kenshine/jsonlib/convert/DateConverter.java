package com.kenshine.jsonlib.convert;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/15 9:16
 * @description： 日期格式化转换器
 * @modified By：
 * @version: $
 */
public class DateConverter {
    public static String convert2Json2(Object object) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonValueProcessor(java.util.Date.class,
                new JsonValueProcessor() {
                    private final String format = "yyyy-MM-dd hh:mm:ss";

                    @Override
                    public Object processArrayValue(Object object, JsonConfig jsonConfig){
                        return null;
                    }

                    @Override
                    public Object processObjectValue(String string, Object object, JsonConfig jsonConfig) {
                        if (null == object) {
                            return "";
                        } else {
                            if (object instanceof java.util.Date) {
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
                                String dateStr = simpleDateFormat.format(object);
                                return dateStr;
                            }
                        }
                        return object.toString();
                    }
                });
        if (object instanceof String) {
            return object.toString();
        }if ((object instanceof Object[]) || (object instanceof List)) {
            JSONArray jsonObject = JSONArray.fromObject(object, jsonConfig);
            return jsonObject.toString() + '\n';
        } else {
            JSONObject jsonObject = JSONObject.fromObject(object, jsonConfig);
            return jsonObject.toString() + '\n';
        }
    }
}
