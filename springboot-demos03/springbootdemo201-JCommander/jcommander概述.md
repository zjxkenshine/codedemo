# 1.简介
JCommander 是一个非常小的命令行解析框架，可以使用注释解析命令行

# 2.选项类型
表示参数的字段可以是任何类型，默认情况下支持基本类型，可以自己编写类型转换器来支持其他类型(File等)
1. 布尔：
    - `@Parameter(names = "-debug", arity = 1)`:`-debug true/false`
2. List：
    - `@Parameter(names = "-host"...)`
    - 解析`-host host1 -host host2...`
3. 密码：
    - `@Parameter(names = "-password", password = true)`
4. 显示输入密码：echoInput
    - `@Parameter(names = "-password", password = true, echoInput = true)`

# 3.自定义类型（转换器和分离器）
IStringConverter和IParameterSplitter接口
## 3.1 自定义类型 - 单值
1. 两种方式：
    - 实现IStringConverterFactory或使用@Parameter的`converter=`属性
2. @Parameter注释：demo02
    - 自定义转换器实现`IStringConverter<T>`
    - `@Parameter(names = "-file", converter = CustomConverter.class)`
3. 工厂方式：demo03
    - 定义转换器实现IStringConverter
    - 创建转换器工厂IStringConverterFactory实现
    - `Commander.newBuilder().addConverterFactory()`方法添加转换器

## 3.2 自定义类型 - 列表值
使用@Parameter注解的`istConverter=`属性 demo04

## 3.3 拆分器splitter
使用@Parameter注解的`splitter=`属性 demo05

# 4.参数验证
验证器接口：IParameterValidator
1. 单个参数验证（局部）  demo06
    - @Parameter注解的`validateWith=`属性
2. 全局参数验证
    - 没有提供注解方式，需要以java编程方式
    
# 5.主要参数
- @Parameter有一个names属性指定名字
- 可以定义最多一个没有names属性的参数

# 6.参数分隔符
默认情况下为空格,自定义：
- `@Parameters(separators = "=")`

# 7.多重描述
可以将参数解析到多个类 demo07

# 8.@语法
JCommander 支持`@`语法，它允许您将所有选项放入一个文件中并将此文件作为参数传递

# 9.多个参数值
1. 固定个数 arity属性
    - `@Parameter(names = "-pairs", arity = 2, description = "Pairs")`
    - 表示-pairs后面需要两个参数
2. 两种变量接收方式
    - List
      ```
      @Parameter(names = "-foo", variableArity = true)
      public List<String> foo = new ArrayList<>();
      ```
    - order
      ```
        @SubParameter(order = 0)
        String from;
        @SubParameter(order = 1)
        String to;
      ```
 
 # 10.多个选项名称
 `@Parameter(names = { "-d", "--descripe" }`
 
 # 11.其他选项配置
 - `setCaseSensitiveOptions(boolean)`：指定选项是否区分大小写
 - `setAllowAbbreviatedOptions(boolean)`：指定用户是否可以传递缩写选项
 
 # 12.必选和可选参数
 `@Parameter(names = "-host", required = true)`
 
 # 13.默认值
 1. 可以在声明时赋值
 2. 实现 IDefaultProvider 接口，并使用`.defaultProvider()`方法设置
 
 # 14.帮助参数
 ```
@Parameter(names = "--help", help = true)
private boolean help;
```

# 15.命令
参考demo08

# 16.异常
ParameterException

# 17. usage
- `usage()`方法用于显示选项摘要
- `@Parameter(names = "...", order = 0)` order可设置选项顺序

# 18.隐藏参数
不希望参数用法出现在usage中，hidden属性：
- `Parameter(names = "-debug", hidden = true)`

# 19.国际化
```
@Parameters(resourceBundle = "MessageBundle")
private class ArgsI18N2 {
  @Parameter(names = "-host", description = "Host", descriptionKey = "host")
  String hostName;
}
```
host为键

# 20.参数委托
共享重复配置，而不是使用单一继承 demo09
- `@ParametersDelegate`注解

# 21.动态参数
`@DynamicParameter`注解
```
@DynamicParameter(names = "-D", description = "Dynamic parameters go here")
private Map<String, String> params = new HashMap<>();
```

# 22.自定义Usage格式
1. 实现IUsageFormatter接口
2. `setUsageFormatter(..)`方法设置


