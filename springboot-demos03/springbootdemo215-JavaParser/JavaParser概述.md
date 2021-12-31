# 1.JavaParser简介
- JavaParser用于生成AST抽象语法树
- JavaSymbolSolver用于静态代码分析

# 2.API
- JavaParser：把Java源码转换成 JavaParser定义的Statement对象
- CompilationUnit：
    - 是一个完整的类文件的表示
    - 在AST中，你可以把这个类看成是AST的根节点
- Visitor：用于找到某个类型的节点
- Comments：一个节点(node)只能有一个comment
    - LineComment
    - BlockComment
    - JavadocComment
- TypeSolver：确定寻找类的位置
    - JarTypeSolver：在.jar文件中寻找类，我们需要传入一个.jar文件的位置
    - JavaParserTypeSolve：在souce file中寻找文件，我们只需传入根目录即可
    - ReflectionTypeSolver：一些类作为语言的一部分被定义，比如 java.lang.Object
    - MemoryTypeSolver：简单地返回我们记录的文件，多用于测试
    - CombinedTypeSolver：将几个不同的solver合并成一个
    - JavaSymbolSolver：`ParserConfiguration.setSymbolResolver(SymbolResolver)`