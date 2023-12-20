package com.kenshine.jevaluator;

import org.junit.Test;
import org.stummi.evaluator.EvaluationContext;
import org.stummi.evaluator.Evaluator;
import org.stummi.evaluator.SimpleEvaluator;
import org.stummi.evaluator.asm.ASMClassLoader;
import org.stummi.evaluator.asm.ASMEvaluator;
import org.stummi.evaluator.exception.EvaluatorException;
import org.stummi.evaluator.expression.Expression;
import org.stummi.evaluator.expression.SingleVarExpression;
import org.stummi.evaluator.expression.StaticExpression;
import org.stummi.evaluator.instruction.*;

import java.util.Collections;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname JevaluatorTest
 * @Description Jevaluator使用示例
 * @Date 2023-12-20 13:28
 * @modified By：
 * @version: 1.0$
 */
public class JevaluatorTest {

    /**
     * 解析带参数学表达式
     */
    @Test
    public void test01() throws EvaluatorException {
        Evaluator evaluator = new SimpleEvaluator();
        Map<String, Double> variables = Collections.singletonMap("x", 42D);
        Double result = evaluator.evaluate("23 + x", variables);
        System.out.println(result);
    }

    /**
     * 使用方式二，预设置公式
     */
    @Test
    public void test02() throws EvaluatorException {
        Evaluator evaluator = new SimpleEvaluator();
        Expression expr = evaluator.parseExpression("23 + x");
        Map<String, Double> variables = Collections.singletonMap("x", 42D);
        Double result = expr.run(variables);
        System.out.println(result);
    }

    /**
     * ASMEvaluator ASM解释器
     * 指令处理
     */
    @Test
    public void test03() throws IllegalAccessException, InstantiationException {
        InstructionList list = getList();
        // ASMClassLoader创建类
        ASMClassLoader asmLoader = new ASMClassLoader();
        Class<? extends Expression> exprClass = asmLoader.createExpressionClass(list);
        Expression e = exprClass.newInstance();
        Map<String, Double> variables = Collections.singletonMap("x", 3D);
        System.out.println(e.run(variables));
    }

    /**
     * EvaluationContext 执行指令
     */
    @Test
    public void test04(){
        InstructionList list = getList();
        Map<String, Double> variables = Collections.singletonMap("x", 3D);
        EvaluationContext context = new EvaluationContext(variables);
        list.run(context);
        Double result = context.getStack().pop();
        System.out.println(result);
    }

    /**
     * SingleVarExpression 单参数解析
     * StaticExpression 无参数解析
     */
    @Test
    public void test05() throws EvaluatorException {
        ASMEvaluator evaluator = new ASMEvaluator();
        Expression expr;
        // SingleVarExpression 单参数解析
        expr = evaluator.parseExpression("2*(x+5)");
        SingleVarExpression svarExpression = (SingleVarExpression)expr;
        System.out.println(svarExpression.run(3));
        // StaticExpression无参数解析
        expr = evaluator.parseExpression("2*(8+5)");
        StaticExpression staticExpression = (StaticExpression)expr;
        System.out.println(staticExpression.run());
    }

    /**
     * getRequiredVariables 元数据解析
     */
    @Test
    public void test06() throws EvaluatorException {
        Expression expr = new SimpleEvaluator().parseExpression("2*x + y + x");
        System.out.println(expr.getRequiredVariables());
    }

    /**
     * 指令列表
     * 2 * (x + 5) + 3;
     */
    public InstructionList getList(){
        // 指令列表
        InstructionList list = new InstructionList(
                // 2压栈
                new PushConstantInstruction(2),
                // 加载变量x并将其推送到堆栈
                new PushVariableInstruction("x"),
                // 5压栈
                new PushConstantInstruction(5),
                // 计算x+5
                new AddInstruction(),
                // 计算2*(x+5)
                new MulInstruction(),
                // 3压栈
                new PushConstantInstruction(3),
                // 计算和
                new AddInstruction()
        );
        return list;
    }
}
