package com.kenshine.justsimmand;

import idea.verlif.justsimmand.anno.SmdClass;
import idea.verlif.justsimmand.anno.SmdOption;
import idea.verlif.justsimmand.anno.SmdParam;

/**
 * @author kenshine
 * 高级用法
 *
 * SmdClass 用于说明指令对象信息
 * SmdOption 给予指令别名与描述信息
 * SmdParam 指定参数别名、默认值、是否必填与参数描述
 */
@SmdClass(value = "math", description = "简单的测试指令")
public class Math {

    @SmdOption(value = {"plus", "+"}, description = "两数之和")
    public int plus(
            @SmdParam(value = "a", force = false, description = "相加的第一个数字，可以为空") int a,
            @SmdParam(value = "b", description = "相加的第二个数字，默认值是3", defaultVal = "3") int b) {
        return a + b;
    }

    @SmdOption(value = {"square", "^"}, description = "做平方")
    public int square(int a) {
        return a * a;
    }

}