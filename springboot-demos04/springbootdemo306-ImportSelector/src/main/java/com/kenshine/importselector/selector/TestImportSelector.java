package com.kenshine.importselector.selector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 22:26
 * @description：ImportSelector Demo类实例化之前处理
 * @modified By：
 * @version: $
 */
public class TestImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //导入TestC
        return new String[]{TestC1.class.getName()};
    }
}
