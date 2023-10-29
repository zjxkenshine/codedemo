# 参考地址
github
- https://github.com/samskivert/jmustache

# 语法
https://zhuanlan.zhihu.com/p/36572041
- {{keyName}}
- {{{keyName}}}
- {{#keyName}} {{/keyName}} 以#开始、以/结束表示区块，循环处理
- {{^keyName}} {{/keyName}} 同上，当keyName值为null, undefined, false时才渲染输出该区块内容
- {{.}} 枚举
- {{!comments}} 注释
- {{>partials}} 子模块

# 目录
- JmustacheTest
    - test01：简单使用
    - test02：循环处理
    - test03：子模块
    - test04：生成java代码
    - test05：excute中使用lambda表达式
    - test06： defaultValue 默认值
    - test07：不转义HTML
    - test08：自定义格式
    - test09：更改转义行为
- JmustacheTest02
    - test01： this变量
    - test02：.
    - test03：特殊变量-first和-last
    - test04：index填充
    - test05：复合变量
    - test06：反射和bean属性风格的查找
    - test07：嵌套上下文
    - test08：可逆lambda

