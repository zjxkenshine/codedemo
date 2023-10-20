package com.kenshine.jxel;

import com.beust.jcommander.internal.Lists;
import com.google.common.base.Joiner;
import org.apache.commons.jexl2.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/21 0:58
 * @description：
 * @modified By：
 * @version: $
 */
public class FormulaConversionUtil {
    private static final Logger logger = LoggerFactory.getLogger(FormulaConversionUtil.class);
    private static final JexlEngine JEXL = new JexlEngine();

    static {
        JEXL.setCache(512);
        JEXL.setLenient(false);
        JEXL.setSilent(false);
    }

    public static void main(String[] args) {
        // 逻辑表达式
        String threshold = "(value==3) or (cpu>90 and mem <70)";
        Map<String,Object> map = new HashMap<>();
        map.put("value", 3);
        map.put("cpu", 12);
        map.put("mem", 100);
        boolean bol = expression(threshold,map);
        System.out.println(bol);

        // 反向解析表达式中的变量
        List<String> variables = getVariables(threshold);
        System.out.println(variables);

        // 计算表达式
        map = new HashMap<>();
        map.put("x", 3);
        map.put("y", 5);
        System.out.println("计算结果：" + calWithJexlEngine("if(1>2) 2*x+y*6 else 3+4",map));

        calWithScriptEngine();
    }

    public static void calWithScriptEngine(){
        //创建if执行语句
        String expStr1 = "if(a>b){c=a;}else{c=b;}";
        Script script1 = JEXL.createScript(expStr1);
        JexlContext context1 = new MapContext();
        context1.set("a", 1);
        context1.set("b", 2);
        context1.set("c", 0);
        Object obj1 = script1.execute(context1);
        System.out.println(obj1);

        //创建while执行语句
        String expStr2 = "while(a<b){a=a+b;}";
        Script script2  = JEXL.createScript(expStr2);
        JexlContext context2 = new MapContext();
        context2.set("a", 1);
        context2.set("b", 2);
        Object obj2 = script2.execute(context2);
        System.out.println(obj2);
    }
    /**
     * 通用逻辑表达式
     * @param expression  表达式
     * @param map         参数，允许为Null
     * @return
     */
    public static boolean expression(String expression,Map<String,Object> map) {
        try {
            Expression exp = JEXL.createExpression(expression);
            JexlContext jc = new MapContext();
            if(map != null){
                for (String key : map.keySet()){
                    jc.set(key, map.get(key));
                }
            }
            Object evaluate = exp.evaluate(jc);
            if (evaluate instanceof Boolean) {
                return (boolean) evaluate;
            } else {
                logger.error("表达式错误{}，不是boolean返回值:{}", exp, evaluate);
                return false;
            }
        } catch (Throwable t) {
            logger.error("表达式{}配置错误{}", expression, t.getMessage(), t);
            return false;
        }
    }
    /**
     * 公式计算表达式
     * @param exp  公式 . 如 (a+b-c)*d/f
     * @param map  参数集合
     * @return 返回结果默认String
     */
    public static String calWithJexlEngine(String exp,Map<String , Object> map){
        try {
            Expression expression = JEXL.createExpression(exp);
            JexlContext jc = new MapContext();
            if(map != null){
                map.keySet().forEach(k->{
                    //jexl计算结果类型根据入参决定:
                    //如果参数都是int/Integer类型 . 那么即便结果值应该是4.8 . 返回值也是4 .所以这里为保证计算精度 . 入参可全部以decimal类型处理下
                    //若参数中存在小数,则结果精度相对准确 . 出参为double类型
                    Object paramVal = map.get(k);
                    String paramValStr = paramVal != null ? String.valueOf(paramVal) : "0";
                    jc.set(k , new BigDecimal(paramValStr));
                });
            }
            Object result =expression.evaluate(jc);
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            return decimalFormat.format(result);
        } catch (Exception e) {
            logger.error("表达式{}配置错误{}", exp, e.getMessage(), e);
            return null;
        }
    }
    /**
     * 获取表达式中的变量参数
     * @param expression 表达式，如 ping.max>0 and ping.min>0 and pin.lost==0
     */
    public static List<String> getVariables(String expression) {
        Expression exp;
        try {
            exp = JEXL.createExpression(expression);
        } catch (Throwable t) {
            logger.error("表达式{}配置错误{}。", expression, t.getMessage(), t);
            return Collections.emptyList();
        }
        return getVariables(exp);
    }

    public static List<String> getVariables(Expression exp) {
        List<String> metricDefIds = Lists.newArrayList();
        Set<List<String>> variables = JEXL.getVariables((ExpressionImpl) exp);
        for (List<String> var : variables) {
            metricDefIds.add(Joiner.on(".").join(var));
        }
        return metricDefIds;
    }
}
