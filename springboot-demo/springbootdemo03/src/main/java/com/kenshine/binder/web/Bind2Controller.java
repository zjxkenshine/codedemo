package com.kenshine.binder.web;

import com.kenshine.binder.domain.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/19 14:29
 * @description：绑定测试2WebBindingInitializer全局
 * @modified By：
 * @version: $
 *
 * 在Spring MVC中使用WebBindingInitializer，为每个特殊的请求初始化相应的WebDataBinder，WebBindingInitializer是可以实现全局级别的实现方案，区别于@InitBinder只对单个Controller有效。
 *
 * 而在SpringBoot中，则可以通过配置ConfigurableWebBindingInitializer这样的Bean来进行WebDataBinder的设置。 见WebDataBindConfig类
 */
@Slf4j
@RestController
public class Bind2Controller {

    @PostMapping(value = "/order")
    public String order(@Valid @RequestBody OrderForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage();
        }

        log.warn("order={}",form.toString());
        return "success";
    }
}
