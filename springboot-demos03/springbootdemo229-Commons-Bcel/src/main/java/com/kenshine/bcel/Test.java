package com.kenshine.bcel;

import org.apache.bcel.Constants;
import org.apache.bcel.generic.*;

import static org.apache.bcel.Const.*;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/18 9:39
 * @description：
 * @modified By：
 * @version: $
 */
public class Test {

    public static void main(String[] args) {
        try {
            // BCEL附录示例
            //创建一个类，类名HelloWorld
            ClassGen cg = new ClassGen("HelloWorld", "java.lang.Object",
                    "<generated>", ACC_PUBLIC | ACC_SUPER, null);
            ConstantPoolGen cp = cg.getConstantPool();
            InstructionList il = new InstructionList();

            // 创建main方法
            MethodGen mg = new MethodGen(ACC_STATIC | ACC_PUBLIC, Type.VOID,
                    new Type[] { new ArrayType(Type.STRING, 1) },
                    new String[] { "argv" }, "main", "HelloWorld", il, cp);
            InstructionFactory factory = new InstructionFactory(cg);
            // 定义一些常用的类型
            ObjectType i_stream = new ObjectType("java.io.InputStream");
            ObjectType p_stream = new ObjectType("java.io.PrintStream");
            //%%
            //BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            //%%
            // 创建类型及名称
            il.append(factory.createNew("java.io.BufferedReader"));
            il.append(InstructionConstants.DUP);
            il.append(factory.createNew("java.io.InputStreamReader"));
            il.append(InstructionConstants.DUP);
            //初始化inputStream
            il.append(factory.createFieldAccess("java.lang.System", "in",
                    i_stream, Constants.GETSTATIC));
            il.append(factory.createInvoke("java.io.InputStreamReader",
                    "<init>", Type.VOID, new Type[] { i_stream },
                    Constants.INVOKESPECIAL));
            il.append(factory.createInvoke("java.io.BufferedReader", "<init>",
                    Type.VOID, new Type[] { new ObjectType("java.io.Reader") },
                    Constants.INVOKESPECIAL));
            //add in into the local variable pool and get the index automatically
            //添加到局部变量表并且自动获取索引
            LocalVariableGen lg = mg.addLocalVariable("in", new ObjectType(
                    "java.io.BufferedReader"), null, null);
            int in = lg.getIndex();//index of "in" var
            lg.setStart(il.append(new ASTORE(in)));//store the reference into local variable
            //首先创建对象，并初始化，操作结果在JVM的“堆”里，还需要在本地变量表中创建引用，因此在本地变量表中添加一个“in”比那辆，
            //然后根据索引值调用“astore”指令，即可将对象引用赋值给本地变量
             /*
             0: new #8; //class java/io/BufferedReader
             3: dup
             4: new #10; //class java/io/InputStreamReader
             7: dup
             8: getstatic #16; //Field java/lang/System.in:Ljava/io/InputStream;
             11: invokespecial #20; //Method java/io/InputStreamReader."<init>":(Ljava/io/InputStream;)V
             14: invokespecial #23; //Method java/io/BufferedReader."<init>":(Ljava/io/Reader;)V
             17: astore_1
             * */
            //%%
            //String name = null;
            //%%
            // 创建局部变量 String name
            lg = mg.addLocalVariable("name", Type.STRING, null, null);
            int name = lg.getIndex();
            il.append(InstructionConstants.ACONST_NULL);//add "null" to the stack top
            lg.setStart(il.append(new ASTORE(name)));//"store" the value of "null" into "name" var
            //%%
            //System.out.print("Please enter your name> ")
            //%%
            // 创建try_catch块
            InstructionHandle try_start = il.append(factory.createFieldAccess(
                    "java.lang.System", "out", p_stream, Constants.GETSTATIC));
            //从常量池中取出“please .....”，压入栈顶：这里感觉有问题，这个字符串常量应该先压入常量池才可以（最好是在这之前加一句，
            //加一句添加常量池操作其实并不影响实际运行的效率）
            il.append(new PUSH(cp, "Please enter your name> "));
            il.append(factory.createInvoke("java.io.PrintStream", "print",
                    Type.VOID, new Type[] { Type.STRING },
                    Constants.INVOKEVIRTUAL));
            //%%
            //name = in.readLine();
            //%%
            //将本地变量“in”推送至栈顶
            il.append(new ALOAD(in));
            il.append(factory.createInvoke("java.io.BufferedReader",
                    "readLine", Type.STRING, Type.NO_ARGS,
                    Constants.INVOKEVIRTUAL));//调用readLine()方法
            il.append(new ASTORE(name));//接收的结果在栈顶，需要保存，因此加上保存到“name”slot的指令
            //%%
            // } catch(IOException e) { return; }
            //%%
            GOTO g = new GOTO(null);
            InstructionHandle try_end = il.append(g);
            //add return：如果出异常，才会走到这条“return”指令，并返回到caller中
            InstructionHandle handler = il.append(InstructionConstants.RETURN);
            // 添加该方法的异常处理器
            mg.addExceptionHandler(try_start, try_end, handler, null);
            //%%
            //没有异常，继续执行：System.out.println("Hello, " + name);
            //%%
            // "normal" code continues, set the branch target of the GOTO
            InstructionHandle ih = il.append(factory.createFieldAccess(
                    "java.lang.System", "out", p_stream, Constants.GETSTATIC));
            g.setTarget(ih);
            // print "Hello"：创建一个StringBuffer对象，通过调用StringBuffer的append操作，实现
            //string1 + string2的操作，并且操作结果调用toString方法
            il.append(factory.createNew(Type.STRINGBUFFER));
            il.append(InstructionConstants.DUP);
            il.append(new PUSH(cp, "Hello, "));
            il.append(factory.createInvoke("java.lang.StringBuffer", "<init>",
                    Type.VOID, new Type[] { Type.STRING },
                    Constants.INVOKESPECIAL));
            il.append(new ALOAD(name));
            il.append(factory.createInvoke("java.lang.StringBuffer", "append",
                    Type.STRINGBUFFER, new Type[] { Type.STRING },
                    Constants.INVOKEVIRTUAL));
            //
            il.append(factory.createInvoke("java.lang.StringBuffer",
                    "toString", Type.STRING, Type.NO_ARGS,
                    Constants.INVOKEVIRTUAL));
            il.append(factory.createInvoke("java.io.PrintStream", "println",
                    Type.VOID, new Type[] { Type.STRING },
                    Constants.INVOKEVIRTUAL));
            il.append(InstructionConstants.RETURN);
            // finalization
            mg.setMaxStack();
            cg.addMethod(mg.getMethod());
            il.dispose();
            cg.addEmptyConstructor(ACC_PUBLIC);
            // dump the class
            cg.getJavaClass().dump("springbootdemo229-Commons-Bcel\\src\\main\\java\\com\\kenshine\\bcel\\HelloWorld.class");
            System.out.println("dump successly");
        } catch (java.io.IOException e) {
            System.err.println(e);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
}
