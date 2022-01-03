package com.kenshine.importselector.registrar;

import com.kenshine.importselector.registrar.annotation.Manager;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/3 21:37
 * @description：测试@Manager注解
 * @modified By：
 * @version: $
 */
@Manager
public class TestManager {
    public TestManager(){
        System.out.println("TestManager 被自定义注解 @Manager 导入了(ImportBeanDefinitionRegistrar)");
    }
}
