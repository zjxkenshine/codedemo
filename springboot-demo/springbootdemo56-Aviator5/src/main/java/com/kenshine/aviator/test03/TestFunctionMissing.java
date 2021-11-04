package com.kenshine.aviator.test03;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.FunctionMissing;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.util.Arrays;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 17:28
 * @description：测试FunctionMissing
 * @modified By：
 * @version: $
 */
public class TestFunctionMissing implements FunctionMissing {

    @Override
    public AviatorObject onFunctionMissing(final String name, final Map<String, Object> env,
                                           final AviatorObject... args) {
        // Returns the function name.
        System.out.println(
                "Function not found, name=" + name + ", env=" + env + ", args=" + Arrays.toString(args));
        return FunctionUtils.wrapReturn(name);
    }


    public static void main(String[] args) {
        // Set function missing handler.
        AviatorEvaluator.setFunctionMissing(new TestFunctionMissing());

        System.out.println(AviatorEvaluator.execute("test(1,2,3)"));
        System.out.println(AviatorEvaluator.execute("not_found(1,2,3)"));
    }
}

