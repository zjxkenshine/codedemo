package com.kenshine.designpattern.gof13_Facade.test01.Genetator;

/**
 * @author ：kenshine
 * @date ：Created in 2022/2/13 20:52
 * @description：定义生成代码的外观层
 * @modified By：
 * @version: $
 */
public class GeneratorFacade {
    /**
     * 私有构造器
     * 外观层一般只是对子系统各个模块的一个封装和组合，通常可以实现成单例，或者直接将方法定义为静态方法
     */
    private GeneratorFacade() {
    }

    /**
     * 生成需要的代码文件（对子系统各模块功能的包装）
     */
    public static void genetator(){
        // 生成Controller层代码文件
        new ControllerGenerator().generator();
        // 生成Service层代码文件
        new ServiceGenerator().generator();
        // 生成Dao层代码文件
        new DaoGenerator().generator();
    }

}
