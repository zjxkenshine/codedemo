package com.kenshine.argumentresolver.resolvers;

import com.kenshine.argumentresolver.annotation.Phone;
import com.kenshine.argumentresolver.utils.PhoneUtils;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/5 13:41
 * @description：手机号码解析
 * @modified By：
 * @version: $
 */
@Component
public class PhoneNumberResolver implements HandlerMethodArgumentResolver {
    /**
     * 用于判定是否需要处理该参数分解，返回true为需要，并会去调用下面的方法resolveArgument
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        //有phone注解则继续操作
        return methodParameter.hasParameterAnnotation(Phone.class);
    }

    /**
     * resolveArgument：真正用于处理参数分解的方法，返回的Object就是controller方法上的形参对象
     * @param methodParameter 方法参数
     * @param modelAndViewContainer
     * 上下文容器，它主要是承担着整个请求过程中数据的传递工作，处理保存Model和View
     * @param nativeWebRequest 可获取请求
     * HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
     * @param webDataBinderFactory 数据绑定工厂
     * @return Object 对应参数对象
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        //获取请求
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
        String phone = request.getParameter(methodParameter.getParameter().getName());
        if(!PhoneUtils.isPhoneLegal(phone)){
            //需要抛出校验异常，这里只是打印
            System.out.println("手机号不正确");
        }
        return phone;
    }
}
