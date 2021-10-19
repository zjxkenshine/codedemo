package com.kenshine.binder.bind;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebBindingInitializer;

import java.util.Date;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 14:33
 * @description：全局web类型数据绑定
 * @modified By：
 * @version: $
 *
 * 在Spring MVC中使用WebBindingInitializer，为每个特殊的请求初始化相应的WebDataBinder，WebBindingInitializer是可以实现全局级别的实现方案，区别于@InitBinder只对单个Controller有效。
 */
public class CustomDateWebBindingInitializer implements WebBindingInitializer{

    @Override
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class, new MyCustomDateEditor());
    }

}
