package com.kenshine.soot;

import org.junit.Test;
import soot.*;
import soot.jimple.JasminClass;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.StringConstant;
import soot.options.Options;
import soot.util.Chain;
import soot.util.JasminOutputStream;

import java.io.*;
import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname Test01_Create
 * @Description soot从头创建一个类
 * @Date 2023-11-20 14:41
 * @modified By：
 * @version: 1.0$
 */
public class Test01_Create {

    @Test
    public void testCreateHelloWorld() throws IOException {
        // 加载关联类
        Scene.v().loadClassAndSupport("java.lang.Object");
        Scene.v().loadClassAndSupport("java.lang.System");

        // 创建Helloworld类
        SootClass sClass = new SootClass("HelloWorld", Modifier.PUBLIC);
        // 设置父类
        sClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
        // 将sClass添加到scene
        Scene.v().addClass(sClass);

        // 创建Main方法
        SootMethod method = new SootMethod("main",
                Arrays.asList(new Type[] {ArrayType.v(RefType.v("java.lang.String"), 1)}),
                VoidType.v(), Modifier.PUBLIC | Modifier.STATIC);
        sClass.addMethod(method);

        // 创建方法体
        {
            // 在Soot中，我们将Body附加到SootMethod上，添加方法内容
            JimpleBody body = Jimple.v().newBody(method);
            method.setActiveBody(body);

            Chain units = body.getUnits();
            Local arg, tmpRef;

            // 添加属性 String l0
            arg = Jimple.v().newLocal("l0", ArrayType.v(RefType.v("java.lang.String"), 1));
            body.getLocals().add(arg);

            // 添加属性 printStream tmpRef
            tmpRef = Jimple.v().newLocal("tmpRef", RefType.v("java.io.PrintStream"));
            body.getLocals().add(tmpRef);

            // add "l0 = @parameter0"
            units.add(Jimple.v().newIdentityStmt(arg,
                    Jimple.v().newParameterRef(ArrayType.v(RefType.v("java.lang.String"), 1), 0)));

            // add "tmpRef = java.lang.System.out"
            units.add(Jimple.v().newAssignStmt(tmpRef, Jimple.v().newStaticFieldRef(
                    Scene.v().getField("<java.lang.System: java.io.PrintStream out>").makeRef())));

            // 添加 tmpRef.println("Hello world!")"
            {
                SootMethod toCall = Scene.v().getMethod("<java.io.PrintStream: void println(java.lang.String)>");
                units.add(Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr(tmpRef, toCall.makeRef(), StringConstant.v("Hello world!"))));
            }

            // insert "return"
            units.add(Jimple.v().newReturnVoidStmt());
        }

        // 输出方式一：Jasmin
        String fileName = SourceLocator.v().getFileNameFor(sClass, Options.output_format_class);
        OutputStream streamOut = new JasminOutputStream(
                new FileOutputStream(fileName));
        PrintWriter writerOut = new PrintWriter(
                new OutputStreamWriter(streamOut));
        JasminClass jasminClass = new soot.jimple.JasminClass(sClass);
        jasminClass.print(writerOut);
        writerOut.flush();
        streamOut.close();

        // 输出方式二：使用ASM写入到.class文件
//        int java_version = Options.v().java_version();
//        String fileName = SourceLocator.v().getFileNameFor(sClass, Options.output_format_class);
//        OutputStream streamOut = new FileOutputStream(fileName);
//        BafASMBackend backend = new BafASMBackend(sClass, java_version);
//        backend.generateClassFile(streamOut);
//        streamOut.close();


        /**
         * 输出一个简单的源代码，而不是.class文件
         */
        PrintWriter writerOut1 = new PrintWriter(System.out);
        Printer.v().printTo(sClass, writerOut1);
    }
}
