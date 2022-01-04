package com.kenshine.metadata.demo03;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 11:08
 * @description：利用PostProcessor装载策略
 * @modified By：
 * @version: $
 */
@Component
public class HandleTypeAnnotationBeanPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        ClassScanner classScanner = new ClassScanner();
        Set<Class<?>> classSet = classScanner.scan(new String[]{"com.kenshine.metadata.demo03"}, HandleType.class);

        Map<String, Class> handleMap = new HashMap<>();
        for (Class clazz : classSet) {
            HandleType handleType = (HandleType) clazz.getAnnotation(HandleType.class);
            handleMap.put(handleType.value(), clazz);
        }
        HandlerContext handlerContext = new HandlerContext(handleMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), handlerContext);
    }
}
