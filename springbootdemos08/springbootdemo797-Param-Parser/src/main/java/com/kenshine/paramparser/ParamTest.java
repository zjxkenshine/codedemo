package com.kenshine.paramparser;

import idea.verlif.parser.ParamParser;
import idea.verlif.parser.ParamParserService;
import idea.verlif.parser.impl.DoubleParser;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname ParamTest
 * @Description String解析测试
 * @Date 2024-05-04 15:46
 * @modified By：
 * @version: 1.0$
 */
public class ParamTest {

    @Test
    public void test01(){
        // 获取解析服务对象
        ParamParserService pps = new ParamParserService();
        // 获取对应类型的解析器 可以通过反射类型动态获取解析器
        ParamParser<Double> doubleParser = pps.getParser(Double.class);
        // 使用解析器
        double d = doubleParser.parse("123");
        // 结果输出 123.0
        System.out.println(d);
        // 结果输出 null
        System.out.println(doubleParser.parse(null));
        //设定自定义空值处理
        doubleParser.setNullValueParser(new DoubleParser.AdvanceValueParser(2));
        // 结果输出 2.0
        System.out.println(doubleParser.parse(null));
        // 结果输出 2.0
        System.out.println(pps.parse(Double.class, null));
        // 添加自定义的解析器
        pps.addOrReplace(new BooleanParser());
    }
}
