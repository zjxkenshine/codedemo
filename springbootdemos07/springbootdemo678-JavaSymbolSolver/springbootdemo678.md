# 参考地址
JavaParser
- https://github.com/javaparser/javaparser
- https://github.com/javaparser/javasymbolsolver-maven-sample
- https://javaparser.org/

相关项目：
- springbootdemo215-JavaParser

IDEA插件：快速删除Java代码中的注释
- https://zhuanlan.zhihu.com/p/351048233

状态机编程思想（2）：删除代码注释（目前支持C/C++和Java）
- https://www.cnblogs.com/xiaoxi666/p/7931763.html

JavaParser+JavaSymbolSolve 获取完整调用链路
- https://wenku.csdn.net/answer/1a6bd7b8ad9d4c7683b448c1795ae709

# 目录
- Test01：观察AST
- Test02：JavaParser与staticJavaParser
- Test03：SourceRoot 一次性分析整个项目
- ListClassesExample：基本使用示例
- observer：监视器
- lexical：词法保留
- comment：示例 删除Java代码中的注释

# 踩坑：
- Lexical error at line 1, column 4.  Encountered: "G" (71), after : "\\"
    - 不能使用`StaticParser.parse(String.valueof(...));`

