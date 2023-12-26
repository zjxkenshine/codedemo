# 参考地址
jakarta-oro 正则表达式解析
- https://github.com/bes2008/jakarta-oro

官网
- https://jakarta.apache.org/oro/

# 对象与方法
- PatternCompiler对象：Perl5Compiler是PatternCompiler接口的一个实现，允许你把正则表达式编译成用来匹配的Pattern对象
- Pattern对象：把所对应的正则表达式编译成Pattern对象，需要调用compiler对象的compile()方法
- PatternMatcher对象：依据Pattern对象和字符串展开匹配检查
- Util.substitute()方法：查找后替换
