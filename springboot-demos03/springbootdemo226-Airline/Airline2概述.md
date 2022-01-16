# 1.概述
用于在 Java 中构建强大的 Git 风格 CLI，这里仅做入门学习

类似技术
- pico-cli
- JCommander
- commons-cli
- ClamShell-Cli
- jopt-simple

# 2.基本流程
## 2.1 定义阶段
Airline 中的定义阶段主要是通过对类及其字段使用注释来驱动的
1. 定义命令：@Command注解
   - name：名称字段
   - description：描述
2. 定义选项：@Option注解
   - 每个@Option定义必须与特定字段相关联
3. 定义参数：@Arguments注解
    - 注释字段来接受额外的任意输入

## 2.2 解析阶段
创建解析器并执行解析
```
SingleCommand<A> parser = SingleCommand.singleCommand(A.class);
GettingStarted cmd = parser.parse(args);
```

## 2.3 审讯阶段
询问收到的选项并采取相应的行动

## 2.4 两种执行方式
- `@Cli`：复杂命令构建
    - Cli类处理
- SingleCommand：处理`@Command`

# 3.自定义转换器 Test02Test02Converter
- TypeConverter：类型转换器，转换字段类型
- TypeConverterProvider：类型转换器提供器
- @Parser：注册自定义类型转换器
    - ParserBuilder效果相同

# 4.Option继承 Test03Extends
可以使用标准继承来定义包含@Option可由多个命令实现继承的定义的基类

选项覆盖：
- `@Unrestricted`注解

帮助信息部分继承：
- `@Discussion`：帮助信息
- `@HideSection`：隐藏帮助继承信息
- `@Copyright`：版权信息

# 5.异常信息
- ParseException：错误根类型
- ParserErrorHandler：错误处理器
- `@Parser(errorHandler = CollectAll.class)`：定义错误处理器，默认FailFast快速失败

# 6.详细教程
- https://rvesse.github.io/airline/guide/practise/
