package com.kenshine.binder.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 13:49
 * @description：绑定测试接口
 * @modified By：
 * @version: $
 */
@Slf4j
@RestController
public class BindController {

    @GetMapping(value = "/bind")
    public Map<String, Object> getFormatData(Date date) throws ParseException {
        log.warn("date={}", date);
        Map<String, Object> map = new HashMap<>();
        map.put("name", "kenshine");
        map.put("age", 25);
        map.put("date", date);
        return map;
    }


    /**
     * @InitBinder标注的方法,只针对当前Controller有效!
     * 如果没有该方法,则会产生400状态码!
     * MethodArgumentTypeMismatchException: Failed to convert value of type 'java.lang.String' to required type 'java.util.Date!
     * 将字符串转换为Date
     *
     * WebDataBinder的作用是从web request中把web请求里的parameters绑定到对应的JavaBean上
     */
    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        //前端传入的时间格式必须是"yyyy-MM-dd"效果!
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor dateEditor = new CustomDateEditor(df, true);
        binder.registerCustomEditor(Date.class, dateEditor);
    }



}
