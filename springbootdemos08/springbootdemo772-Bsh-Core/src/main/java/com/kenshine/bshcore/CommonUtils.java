package com.kenshine.bshcore;

import bsh.EvalError;
import bsh.Interpreter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kenshine
 * 工具类
 */
public class CommonUtils {
    public static Object executeJavaCode(String javaCode, Map<String,Object> params,String outParam) throws EvalError {
        Interpreter interpreter = new Interpreter();
        // 设置公式的变量值
        for (Map.Entry<String, Object> stringObjectEntry : params.entrySet()) {
            interpreter.set(stringObjectEntry.getKey(),stringObjectEntry.getValue());
        }
		// 计算
        interpreter.eval(javaCode);
		// 获取结果
        Object o = interpreter.get(outParam);
        return o;
    }

    public static void main(String[] args) throws EvalError {
        String javaCode = "int ss = (a*b-c*d)/e*100;";
        Map<String, Object> map = new HashMap<>();
        map.put("a",25);
        map.put("b",4);
        map.put("c",3);
        map.put("d",10);
        map.put("e",14);
        System.out.println(CommonUtils.executeJavaCode(javaCode, map, "ss"));
    }
}