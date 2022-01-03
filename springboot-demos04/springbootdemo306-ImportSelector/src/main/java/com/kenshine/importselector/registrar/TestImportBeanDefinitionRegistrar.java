package com.kenshine.importselector.registrar;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 22:23
 * @description：
 * @modified By：
 * @version: $
 */
public class TestImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition rootBeanDefinition = new RootBeanDefinition(TestD.class);
        //自定义注册bean
        registry.registerBeanDefinition("testDCustom",rootBeanDefinition);
    }
}
