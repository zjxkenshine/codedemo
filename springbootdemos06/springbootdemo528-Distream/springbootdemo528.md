# 参考地址
distream 
- https://gitee.com/huoyo/distream

Java-Distream：数据连续流式处理，不一样的java8 stream
- https://blog.csdn.net/qq_21120275/article/details/123217480

# 简介
表达式内置函数
```
ListFrame<Map<String, Object>> lines = xxx;
/*code的值转为int并赋值给id  等价于  line.put("id",Integer.valueOf(code))*/
lines = lines.handle("id=int(code)");

/*value的值转为double并赋值给percent  等价于  line.put("percent",Double.valueOf(code))*/
lines = lines.handle("percent=double(value)");

/*value的值转为string并赋值给name等价于  line.put("name",value+"")*/
lines = lines.handle("name=string(value)");

/*等价于string的substring*/
lines = lines.handle("name=substring(name,1,2)");

/*把name的"xxx" 替换为"yyy"*/
lines = lines.handle("name=replace(name,'xxx','yyy')");

/*把name的"xxx" 替换为""*/
lines = lines.handle("name=name-'xxx'");

/*类似于indexof*/
lines = lines.handle("id=index(name,'xxx')");

/*percent保留两位小数*/
lines = lines.handle("percent=format(percent,2)")
```

# 目录
DistreamTest01
- test01：基本使用
- test02：求最值
- test03：类型转换
- test04：统计元素个数
- test05：方差和标准差
- test06：去重
- test07：排除空值

DistreamTest02
- test01：读取文件，写入到文件
- test02：读取csv
- test03：按列获取数据，求最值
- test04：分组求和
- test05：数据替换
- test06：常用函数


# 踩坑
1. 1.1.0 版本有递归问题，使用1.0.9版本
