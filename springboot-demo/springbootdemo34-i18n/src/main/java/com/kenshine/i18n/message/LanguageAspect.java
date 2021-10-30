package com.kenshine.i18n.message;

import com.kenshine.i18n.apireturn.ResultData;
import com.kenshine.i18n.util.I18nUtils;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/30 14:53
 * @description：aop方式拦截 controller接口返回的数据
 * @modified By：
 * @version: $
 *
 *
 *
 * //@ConditionalOnProperty 控制配置类是否生效
 * 	// value() 数组，获取对应property名称的值，与name不可同时使用
 * 	// prefix() 配置属性名称的前缀，比如spring.http.encoding
 * 	// name()   数组，配置属性完整名称或部分名称 可与prefix组合使用，组成完整的配置属性名称，与value不可同时使用
 * 	// havingValue() 可与name组合使用，比较获取到的属性值与havingValue给定的值是否相同，相同才加载配置
 * 	// matchIfMissing()    缺少该配置属性时是否可以加载。如果为true，没有该配置属性时也会正常加载；反之则不会生效
 */
@Aspect
@Component
@AllArgsConstructor
@ConditionalOnProperty(prefix = "lang", name = "open", havingValue = "true")
public class LanguageAspect {
    @Autowired
    I18nUtils i18nUtils;

    @Pointcut("execution(* com.kenshine.i18n.web.*.*(..)))")
    public void annotationLangCut() {
    }

    /**
     * 拦截controller层返回的结果，修改msg字段
     *
     * @param point
     * @param obj
     */
    @AfterReturning(pointcut = "annotationLangCut()", returning = "obj")
    public void around(JoinPoint point, Object obj) {
        Object resultObject = obj;
        try {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            //从获取RequestAttributes中获取HttpServletRequest的信息
            HttpServletRequest request = (HttpServletRequest) requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
            String langFlag = request.getHeader("lang");
            if (null != langFlag) {
                ResultData r = (ResultData) obj;
                String msg = r.getMessage().trim();
                if (StringUtils.isNotEmpty(msg)) {
                    if ("CN".equals(langFlag)) {
                        Locale locale = Locale.CHINA;
                        msg = i18nUtils.getKey(msg, locale);
                    } else if ("EN".equals(langFlag)) {
                        Locale locale = Locale.US;
                        msg = i18nUtils.getKey(msg, locale);
                    } else {
                        //其他语言配置，都不匹配使用默认的mess文件
                        msg = i18nUtils.getKey(msg);
                    }
                }
                r.setMessage(msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //返回原值
            obj = resultObject;
        }
    }

}
