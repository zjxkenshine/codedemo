package com.kenshine.postprocessor.custom;

import com.kenshine.postprocessor.web.TestUserController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 11:34
 * @description：
 * @modified By：
 * @version: $
 */
@Component
public class TestDestructionAwareBeanPostProcessor implements DestructionAwareBeanPostProcessor {
    @Override
    public void postProcessBeforeDestruction(Object bean, String beanName) throws BeansException {
        if(bean instanceof TestUserController) {
            System.out.println(beanName + " 即将销毁了");
        }
    }

    //确定给定的 bean 实例是否需要此后处理器销毁
    @Override
    public boolean requiresDestruction(Object bean) {
        if(bean instanceof TestUserController) {
            System.out.println(bean + "是否被该后处理器销毁");
        }
        return true;
    }
}
