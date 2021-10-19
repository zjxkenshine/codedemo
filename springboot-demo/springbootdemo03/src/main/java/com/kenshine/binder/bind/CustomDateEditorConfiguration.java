package com.kenshine.binder.bind;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 14:34
 * @description：绑定配置/注册
 * @modified By：
 * @version: $
 *
 * 注释掉@Configuration 测试SpringBoot ConfigurableWebBindingInitializer配置
 * 不注释使用的是SpringMVC的 WebBindingInitializer
 */
//@Configuration
public class CustomDateEditorConfiguration {

    @Autowired
    public void setWebBindingInitializer(RequestMappingHandlerAdapter requestMappingHandlerAdapter) {
        //将自定义的CustomDateWebBindingInitializer属性编辑器绑定到RequestMappingHandlerAdapter里面.
        requestMappingHandlerAdapter.setWebBindingInitializer(new CustomDateWebBindingInitializer());
    }

}
