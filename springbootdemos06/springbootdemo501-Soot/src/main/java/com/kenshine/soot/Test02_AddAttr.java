package com.kenshine.soot;

import org.junit.Test;
import soot.*;
import soot.baf.Baf;
import soot.jimple.JasminClass;
import soot.jimple.Jimple;
import soot.jimple.JimpleBody;
import soot.jimple.StringConstant;
import soot.options.Options;
import soot.tagkit.GenericAttribute;
import soot.tagkit.Tag;
import soot.tagkit.TagAggregator;
import soot.util.Chain;
import soot.util.JasminOutputStream;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author by kenshine
 * @Classname Test02_AddAttr
 * @Description 向class文件添加属性
 * @Date 2023-11-21 11:54
 * @modified By：
 * @version: 1.0$
 */
public class Test02_AddAttr {

    /**
     * 创建类
     */
    @Test
    public void test01() throws IOException {
        SootClass sClass;
        SootMethod method;

        // Resolve dependencies
        Scene.v().loadClassAndSupport("java.lang.Object");
        Scene.v().loadClassAndSupport("java.lang.System");

        // Declare 'public class HelloWorld'
        sClass = new SootClass("HelloWorld", Modifier.PUBLIC);

        // 'extends Object'
        sClass.setSuperclass(Scene.v().getSootClass("java.lang.Object"));
        Scene.v().addClass(sClass);

        // Create the method, public static void main(String[])
        method = new SootMethod("main",
                Arrays.asList(new Type[] {ArrayType.v(RefType.v("java.lang.String"), 1)}),
                VoidType.v(), Modifier.PUBLIC | Modifier.STATIC);

        sClass.addMethod(method);

        // 添加属性
        GenericAttribute classAttr = new GenericAttribute(
                "ca.mcgill.sable.MyClassAttr",
                "foo".getBytes());
        sClass.addTag(classAttr);


        // Create the method body
        {
            // create empty body
            JimpleBody body = Jimple.v().newBody(method);

            method.setActiveBody(body);
            Chain units = body.getUnits();
            Local arg, tmpRef;

            // Add some locals, java.lang.String l0
            arg = Jimple.v().newLocal("l0", ArrayType.v(RefType.v("java.lang.String"), 1));
            body.getLocals().add(arg);

            // Add locals, java.io.printStream tmpRef
            tmpRef = Jimple.v().newLocal("tmpRef", RefType.v("java.io.PrintStream"));
            body.getLocals().add(tmpRef);

            // 添加tag
            Unit tmpUnit = Jimple.v().newIdentityStmt(arg,
                    Jimple.v().newParameterRef(
                            ArrayType.v(RefType.v("java.lang.String"), 1), 0));
            tmpUnit.addTag(new MyTag(1));
            units.add(tmpUnit);


            // add "tmpRef = java.lang.System.out"
            units.add(Jimple.v().newAssignStmt(tmpRef, Jimple.v().newStaticFieldRef(
                    Scene.v().getField("<java.lang.System: java.io.PrintStream out>").makeRef())));

            // 添加tag
            {
                SootMethod toCall = Scene.v().getMethod(
                        "<java.io.PrintStream: void println(java.lang.String)>");
                tmpUnit = Jimple.v().newInvokeStmt(Jimple.v().newVirtualInvokeExpr(
                        tmpRef, toCall.makeRef(), StringConstant.v("Hello world!")));
                tmpUnit.addTag(new MyTag(2));
                units.add(tmpUnit);
            }

            // insert "return"
            units.add(Jimple.v().newReturnVoidStmt());

            // MyTagAggregator解析tag
            MyTagAggregator mta = new MyTagAggregator();
            // body转换为 baf
            //method.setActiveBody(Baf.v().newBody((JimpleBody) method.getActiveBody()));
            // 转换
            mta.transform(method.getActiveBody());

        }

        // 使用已经转换过的pack结果
//        PackManager.v().getPack("tag").add(new Transform("tag.mta",
//                new MyTagAggregator()));

        // 使用baf生成class文件
        String fileName = SourceLocator.v()
                .getFileNameFor(sClass, Options.output_format_class);
        OutputStream streamOut = new JasminOutputStream(
                new FileOutputStream(fileName));
        PrintWriter writerOut = new PrintWriter(
                new OutputStreamWriter(streamOut));
        // baf
        //AbstractJasminClass jasminClass = new soot.baf.JasminClass(sClass);
        JasminClass jasminClass = new soot.jimple.JasminClass(sClass);
        jasminClass.print(writerOut);
        writerOut.flush();
        streamOut.close();
    }
}

class MyTag implements Tag {

    int value;

    public MyTag(int value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return "ca.mcgill.sable.MyTag";
    }


    @Override
    public byte[] getValue() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(4);
        DataOutputStream dos = new DataOutputStream(baos);
        try {
            dos.writeInt(value);
            dos.flush();
        } catch(IOException e) {
            System.err.println(e);
            throw new RuntimeException(e);
        }
        return baos.toByteArray();
    }
}


class MyTagAggregator extends TagAggregator {

    @Override
    public String aggregatedName() {
        return "ca.mcgill.sable.MyTag";
    }

    @Override
    public boolean wantTag(Tag t) {
        return (t instanceof MyTag);
    }

    @Override
    public void considerTag(Tag t, Unit u, LinkedList<Tag> tags, LinkedList<Unit> units) {
        units.add(u);
        tags.add(t);
    }

}
