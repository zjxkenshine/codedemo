# 1.Janino简介
- Janino是一个极小,极快的 开源Java 编译器
- Janino 不仅可以像 JAVAC 一样将 Java 源码文件编译为字节码文件，还可以编译内存中的 Java 表达式、块、类和源码文件，加载字节码并在 JVM 中直接执行。
- Janino 同样可以用于静态代码分析和代码操作

# 2.Janino相关功能：
- ExpressionEvaluator：解析一个表达式并创建一个“语法树”
- ScriptEvaluator：编译和处理 Java“块”，即方法的主体。
    - 如果定义了“void”以外的返回值，则块必须返回该类型的值
- ClassBodyEvaluator：编译和处理 Java 类的主体，即一系列方法和变量声明
- SimpleCompiler：编译一个单一的.java文件，但是可以声明多个public类
- Compiler：编译了一套.java文件，并创建.class文件。每个编译单元可以声明不同的包，并且编译单元可以相互引用，甚至以循环的方式
- JavaSourceClassLoader：源代码类加载器
- jsh：java shell程序
- janinoc：模仿javac的工具
- AntCompilerAdapter：Ant编译器
- 可以作为Tomcat编译器
- 可作为代码分析器
- 可作为代码操纵者
- ICompilerFactory：自定义编译器实现
- Sandbox：沙箱，安全访问相关
