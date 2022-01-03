package com.kenshine.importselector.selector;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 22:28
 * @description：DeferredImportSelector Demo类实例化之后处理
 * @modified By：
 * @version: $
 */
public class TestDeferredImportSelector implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{TestC2.class.getName()};
    }
}
