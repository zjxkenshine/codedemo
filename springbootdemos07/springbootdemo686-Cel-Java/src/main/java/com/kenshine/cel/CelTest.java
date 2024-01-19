package com.kenshine.cel;

import com.google.common.collect.ImmutableMap;
import com.google.rpc.ResourceInfo;
import com.sun.org.apache.bcel.internal.generic.NEW;
import dev.cel.bundle.Cel;
import dev.cel.bundle.CelFactory;
import dev.cel.common.CelAbstractSyntaxTree;
import dev.cel.common.CelValidationException;
import dev.cel.common.CelValidationResult;
import dev.cel.common.types.SimpleType;
import dev.cel.common.types.StructTypeReference;
import dev.cel.compiler.CelCompiler;
import dev.cel.compiler.CelCompilerFactory;
import dev.cel.expr.Type;
import dev.cel.parser.CelStandardMacro;
import dev.cel.runtime.CelEvaluationException;
import dev.cel.runtime.CelRuntime;
import dev.cel.runtime.CelRuntimeFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname CelTest
 * @Description Cel使用测试
 * @Date 2024-01-19 9:13
 * @modified By：
 * @version: 1.0$
 */
public class CelTest {
    private static final CelCompiler CEL_COMPILER =
            CelCompilerFactory.standardCelCompilerBuilder().addVar("my_var", SimpleType.STRING).build();
    private static final CelRuntime CEL_RUNTIME =
            CelRuntimeFactory.standardCelRuntimeBuilder().build();

    /**
     * 基本使用
     */
    @Test
    public void test01() throws CelEvaluationException, CelValidationException {
            // 将表达式编译到抽象语法树中
            CelAbstractSyntaxTree ast = CEL_COMPILER.compile("my_var + ' kenshine!'").getAst();

            // 构建可执行程序program
            CelRuntime.Program program = CEL_RUNTIME.createProgram(ast);

            // 根据传入的参数计算表达式
            Map<String,String> stringMap = new HashMap<>();
            stringMap.put("my_var", "Hello World");
            String result = (String) program.eval(stringMap);
            System.out.println(result);
    }

    /**
     * 使用过程
     */
    @Test
    public void test02(){
        // Cel堆栈设置两种方式
        Cel cel1 = CelFactory.standardCelBuilder().build();
        CelCompiler cel2 = CelCompilerFactory.standardCelCompilerBuilder()
                .setStandardMacros(CelStandardMacro.HAS)
                .setContainer("google.rpc.context.AttributeContext")
                .addMessageTypes()
                .addVar("resource", Type.getDefaultInstance())
                .addVar("group", SimpleType.STRING)
                .build();


        try {
            // 解析
            CelValidationResult parseResult =
                    cel2.parse("resource.name.startsWith('/groups/' + group)");
            // 校验
            CelValidationResult checkResult = cel2.check(parseResult.getAst());

            // 直接编译
            CelValidationResult compileResult =
                    cel2.compile("resource.name.startsWith('/groups/' + group)");
        } catch (CelValidationException e) {
           e.printStackTrace();
        }
    }

    /**
     * eval执行
     */
    @Test
    public void test03(){
        CelCompiler cel2 = CelCompilerFactory.standardCelCompilerBuilder()
                .setStandardMacros(CelStandardMacro.HAS)
                .setContainer("google.rpc.context.AttributeContext")
                .addMessageTypes()
                .addVar("resource", Type.getDefaultInstance())
                .addVar("group", SimpleType.STRING)
                .build();

        // 直接编译
        CelValidationResult compileResult =cel2.compile("resource.name.startsWith('/groups/' + group)");
        CelRuntime celRuntime = CelRuntimeFactory.standardCelRuntimeBuilder().build();
        try {
            CelRuntime.Program program = celRuntime.createProgram(compileResult.getAst());
            program.eval(
                    ImmutableMap.of(
                            "resource", null,
                            "group", "admin"
                    ));
        } catch (CelEvaluationException | CelValidationException e) {
          e.printStackTrace();
        }
    }




}
