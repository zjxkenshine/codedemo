package com.kenshine.postprocessor.custom;

import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 11:40
 * @description： 处理ben合并
 * @modified By：
 * @version: $
 */
@Component
public class TestMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {

    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        System.out.println("bean 合并");
    }

    /**
     * 重置给定 bean 的所有 bean 定义缓存，包括从它派生的 bean 的缓存。
     * 在替换或删除现有 bean 定义后调用
     * @param beanName
     */
    @Override
    public void resetBeanDefinition(String beanName) {
        //定义已重置的通知
        System.out.println("重置 bean定义");
    }
}
