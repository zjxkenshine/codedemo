package com.kenshine.importselector.registrar;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 21:40
 * @description：实现ImportBeanDefinitionRegistrar可以同时实现Aware接口，以获得spring的一些数据
 * @modified By：
 * @version: $
 */
public class ManagerBeanRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware,BeanFactoryAware {
    private BeanFactory beanFactory;

    private ResourceLoader resourceLoader;

    //注册bean
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        ManagerBeanScanner scanner = new ManagerBeanScanner(registry, false);
        scanner.setResourceLoader(resourceLoader);
        scanner.registerFilters();
        //设置扫描包执行扫描
        scanner.doScan("com.kenshine.importselector");
    }

    //BeanFactoryAware 的接口
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}
