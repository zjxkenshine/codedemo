package com.kenshine.importselector.registrar;

import com.kenshine.importselector.registrar.annotation.Manager;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 21:45
 * @description：自定义扫描器
 * @modified By：
 * @version: $
 */
public class ManagerBeanScanner extends ClassPathBeanDefinitionScanner {

    public ManagerBeanScanner(BeanDefinitionRegistry registry,boolean useDefaultFilters) {
        super(registry,useDefaultFilters);
    }

    protected void registerFilters() {
        addIncludeFilter(new AnnotationTypeFilter(Manager.class));
    }

    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        return super.doScan(basePackages);
    }
}

