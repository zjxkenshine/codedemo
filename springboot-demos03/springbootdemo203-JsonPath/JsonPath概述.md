# 1.JsonPath简介
XPath4JSON的java实现

# 2.JsonPath操作符
- `$`：根元素，启动jsonPath表达式
- `@`：谓词
- `*`：通配符
- `..`：深层扫描
- `.<name>`：子节点
- `['<name>' (, '<name>')]`：子节点或子孙
- `[<number> (, <number>)]`：数组或索引
- `[start:end]`：数组拆分
- `[?(<expression>)]`：过滤表达式

# 3. 函数
可以在路径尾端调用
 - `max()`,`min()`,`avg()`,`stddev()`,`length()`,`sum()`,`keys()`,`concat(X)`,`append(X)`

# 4. 过滤操作符
一般的运算符差不多，几个特殊的：
- `=~`：左侧匹配正则
- `in`,`nin`
- `subsetof`：是否右侧子集
- `anyof`,`noneof`
- `size`：长度与右侧匹配
- `empty`

# 5.配置选项
`Configuration.defaultConfiguration().addOptions()`
- DEFAULT_PATH_LEAF_TO_NULL：使 JsonPath 为丢失的叶子返回 null
- ALWAYS_RETURN_LIST：配置返回一个列表
- SUPPRESS_EXCEPTIONS：忽略某些异常
- REQUIRE_PROPERTIES：当解析的属性不存在时会报错

# 6.JsonProvider Spi
- 底层json解析支持，可以自定义实现
- 切换Provider：test02

# 7.CacheProvider Spi
缓存必须在第一次访问之前进行配置，否则会抛出 JsonPathException,默认两个实现
- LRUCache：默认，线程安全
- NOOPCache：无缓存

自定义缓存：
```
CacheProvider.setCache(new Cache() {...});
```