# 1.运行方式  见Test01
idea插件https://plugins.jetbrains.com/plugin/15303-aviatorscript/versions

## 1.1 编译执行
1. 编译脚本并执行 aviator脚本后缀.av
    ```
    Expression exp = AviatorEvaluator.getInstance().compileScript("examples/hello.av", true);
    exp.execute();
    ```
2. 编译脚本文本
    ```
    Expression script = AviatorEvaluator.getInstance().compile("println('Hello, AviatorScript!');");
    script.execute();
    ```
   `compile(script, cached)`可缓存编译结果，防止重复生成对象
3. 执行：`execute()`
4. 语法校验：`AviatorEvaluator`
5. 引擎模式

## 1.2 解释器模式
5.3 版本开始 性能会下降

# 2.基本类型和语法 Test02
## 2.1 基本类型
- 统一整数类型都为 long
- 大整数(BigInt): `let b = 1000N;`
- 浮点数: 仅支持 double 类型
- 高精度计算(BigDecimal)：`let a = 2M;`
- 数字类型转换
    - 多种类型参与的运算，按照下列顺序：`long -> bigint -> decimal -> double`自动提升
- 字符串
- 转义：` \ `
- 字符串插值: 5.1.0开始
- 布尔类型和逻辑运算
- 逻辑运算和短路规则：`&&`,`||`,`!`,`&`,`|`
- 三元运算符:允许两个分支返回的结果类型可以是不兼容的
- 正则表达式

## 2.2 运算符
- 幂运算:`a**b` 5.1.3之前`math.pow(a, b)`
- 位运算:与java完全一致
- 运算符优先级
- 自定义运算符:运算符重载

## 2.3 注释
- `#...`

## 2.4 变量
- 定义和赋值：定义一个变量的同时需要给他赋值
- 动态类型：变量的类型随着赋值而改变
- nil：未赋值 `a = nil;`
- 传入变量
- 变量的语法糖:类符合JavaBean规范, 并且是 public 的，我们就可以使用语法糖
    - 当你要访问变量a中的某个属性b, 那么你可以通过a.b访问到
    - 更进一步, a.b.c将访问变量a的b属性中的c属性值
- 引用变量: 对于深度嵌套并且同时有数组的变量访问
    - 引用变量要求以 # 符号开始
    - 不支持`#foo.bars[i].name`这样的访问
- 可直接访问Java静态变量
- 特殊变量：
   -  `__exp__` （注意是双下划线），当前表达式的 Expression 对象
   -  `__env__` 当前上下文环境 env
   - `__instance__` 当前执行引擎 AviatorEvaluatorInstance 实例
   - `__args__` 当前函数调用的参数列表
- 外部变量（未初始化全局变量）

## 2.5 作用域
- let:let语句就是让你在特定作用域内定义一个变量，如果父作用域有同名的变量，将“掩盖”父作用域的变量
- 嵌套作用域：
    
## 2.6 多行表达式和 return
- 整个脚本的返回结果默认是最后一个表达式的结果

## 2.7 创建对象和 new
- AviatorScript默认支持new语句（启用 Feature.NewInstance 特性），可以用于创建任意的 java 对象
- 在启用了反射机制的情况下（默认 aviator 脚本模式下启用)，你还可以调用任意方法

## 2.8 use语句引入Java类
- 如`use java.util.*;`

# 3.条件判断 
if else

# 4.循环语句
- `for ... in`: 遍历一个集合
- 索引和 KV 遍历：支持迭代遍历过程带上索引或者 key/value
- continue/break/return
- while语句

# 5.Statement 语句和值
- if条件语句也有一个值，就是实际执行的分支语句的结果
- 循环语句的值：循环语句的结果是最后一次迭代过程中返回的值
- 块（Block）的值：通过大括号括起来的一个块也有一个值，就是这个块里最后一个执行的表达式的值

# 6.异常处理
- 与java类似，仅做了简化
- throw 和 catch：和java一样
- 多异常 Catch
- finally

# 7.函数
## 7.1 函数的定义和调用
- `fn` 语法来定义一个命名函数
- return 返回函数值
- 函数重载
- 不定参数
- Unpacking Arguments（参数解包）

## 7.2 匿名函数和闭包
- 匿名函数 lambda
- 函数是一等公民:可以作为参数来传递
- AviatorsScript 的函数都支持闭包 closure
- 闭包模拟 OOP：闭包可以“保存”状态

## 7.3 自定义函数和调用 Java 方法
- 自定义函数：可以通过 java 代码实现并往引擎中注入自定义函数，在 AviatorScript 中就可以使用
- 所有的函数都实现了 AviatorFunction 接口
- 调用java静态方法：直接调用 Java 类的静态方法
- 导入方法：
    - 静态方法：`AviatorEvaluator.addStaticFunctions("str", StringUtils.class);`
    - 实例方法: `AviatorEvaluator.addInstanceFunctions("s", String.class);`
- Function Missing
    - 当函数找不到的时候，就调用到 FunctionMissing 接口的实现
- 调用 Java 实例方法（基于反射）
- 函数加载器 FunctionLoader
    - 当函数找不到的时候，会尝试优先从函数加载器加载函数并调用，如果还没有，最终调用 FunctionMissing
    - ClassPathConfigFunctionLoader:默认配置，用于从 classpath 加载自定义函数列表
    - 从 spring 容器加载自定义函数：SpringContextFunctionLoader 

## 7.4 函数和 Runnable、Callable
Aviator 中的函数都实现了 Java 中的 Runnable 和 Callable 接口，只要这个函数是无参的，就可以直接作为 Runnable 和 Callable 的实现使用
    
# 8.exports 和模块

# 9.数组和集合
## 9.1 数组
- Tuple：创建一个固定大小的object数组
- 类型数组：`seq.array(type, ..args)`
- 空数组：`seq.array_of(type,len)`
- 多维数组

## 9.2 集合 List, Map 和 Set
- 创建 List：`seq.list`
- `repeat(n, x)` 函数用来创建一个全部是 x 的 List
- 创建 Map:`seq.map(k1, v1, k2, v2 ...)`
- 创建 Set: `seq.set`
- 操作集合
    - 添加元素 `seq.add`
    - 访问元素 `seq.get`
    - 是否存在 `include(coll, element)`
    - 删除元素 `seq.remove`
    - 遍历集合 `for..in`

