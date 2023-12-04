# 参考地址
polyglot
- https://github.com/Sable/polyglot
- http://www.cs.cornell.edu/Projects/polyglot/
- https://github.com/polyglot-compiler/polyglot

# 组成包
- java_cup：Java CUP解析器生成器的调整版本0.10k
- polyglot：基本编译器及扩展
- ppg：Polyglot解析器生成器，Java CUP的扩展

# 自定义扩展编译器示例
- https://github.com/polyglot-compiler/polyglot/tree/master/examples
- https://github.com/polyglot-compiler/polyglot/tree/master/src/polyglot/ext
- 在编译器核心方法中调用polyglot的main或者compiler进行编译
- 编写ppg文件，修改java语法，ppg解析
- 编写.flex词法分析器，jflex解析
- https://github.com/polyglot-compiler/polyglot/tree/master/examples/pao
    - pao 编译器，参考学习

# 踩坑
polyglot.util.InternalCompilerError: Invalid constant tag: 15
- maven的Polyglot java版本太老了，clone https://github.com/polyglot-compiler/polyglot 自己编译使用

