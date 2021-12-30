# 1.Vavr概述
- Vavr（以前称为 Javaslang）是 Java 8+ 的函数库，提供持久数据类型和函数控制结构
- Vavr利用 lambdas 来创建基于函数模式的各种新特性。其中之一是功能性集合库，旨在替代 Java 的标准集合

# 2.元祖 Tuple
- 元组将固定数量的元素组合在一起，以便它们可以作为一个整体传递
- 与数组或列表不同，元组可以包含不同类型的对象，但它们也是不可变的
- 元组目前有 8 个元素的上限，methodt._n 访问元组第n个元素

# 3.Function 函数
- Java8 只提供了一个Function接受一个参数的和一个BiFunction接受两个参数的
- 需要一个抛出已检查异常的函数，可以使用CheckedFunction1, CheckedFunction2
- vavr函数还提供了以下功能

## 3.1 Composition 组合函数
函数组合是将一个函数应用于另一个函数的结果以产生第三个函数
- 所有示例都在test中
- 实现1：andThen方法
- 实现2：then方法

## 3.2 Lifting 偏函数提升
将偏函数提升为返回Option结果的全函数
- 偏函数： f: X′ → Y，X′为X的子集

## 3.3 部分应用
允许您通过固定某些值从现有函数派生出新函数

## 3.4 Currying 科里化
柯里化是一种通过固定一个参数的值来部分应用函数的技术，产生一个Function1

## 3.5 Memoization
Memoization 是一种缓存形式。memoized 函数只执行一次，然后从缓存中返回结果

# 4.Value 值
## 4.1 Option
Option 是表示可选值的 monadic 容器类型
- java8 Optional 对.map结果为 null的调用将导致为空Optional
- Vavr中，它会导致aSome(null)可以导致NullPointerException

## 4.2 Try
Try 是一种 monadic 容器类型，它表示可能导致异常或返回成功计算值的计算

## 4.3 Lazy
Lazy 是一种表示惰性求值值的单子容器类型
- 与Supplier相比，Lazy只执行一次
- 新版本已删除

## 4.4 Either
要么表示两种可能类型的值。一个要么是左要么是右

## 4.5 Future 
Future 是在某个时刻变得可用的计算结果。
- 提供的所有操作都是非阻塞的。底层 ExecutorService 用于执行异步处理程序
- Future 有两种状态：待定和完成

## 4.6 Validation
Validation 控件是一个应用函子，有助于累积错误

# 5.Collections 集合
List
- Vavr List是一个不可变的链表

Stream
- 一个懒惰的链接列表。仅在需要时才计算值

其他集合类都在 io.vavr.collection包下

# 6.Property Check 属性检查
在vavr-test包下

# 7.模式匹配
模式匹配是一个很棒的特性，它使我们免于编写一堆 if-then-else 分支
- Vavr 提供了一个与 Scala 匹配的匹配 API
    - `$()` - 通配符模式
    - `$(value)` - 等于模式
    - `$(predicate)` - 条件模式

