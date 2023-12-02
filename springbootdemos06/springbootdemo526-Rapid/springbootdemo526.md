# 参考地址
rapid 并发程序的动态分析
- https://github.com/umangm/rapid

# 简介
RAPID不支持自己的日志记录机制，但可以利用外部工具——RVPredict或RoadRunner——来记录程序执行(跟踪)
- RVPredict参考springbootdemo500

RAPID支持四种跟踪格式:STD、RoadRunner、RVPredict和CSV(过时)

## STD 格式
`e = <t, op(decor)， loc>`
- t是执行e的线程的标识符
- op(装饰)表示操作和操作数
    - r/w(从内存位置读/写)
    - acq/rel(获取/释放锁对象)
    - fork/join(线程的fork或join)
- loc表示与此事件e对应的程序位置

示例：
```
T0|r(V123)|345
T1|w(V234.23[0])|456
T0|fork(T2)|123
T2|acq(L34)|120
T2|rel(L34)|130
T0|join(T2)|134
```
## RoadRunner格式
暂未学习RoadRunner
https://github.com/umangm/rapid/blob/master/notes/Generate_RoadRunner_traces.md

## RV格式
参考springbootdemo500

## CSV格式
```
r(V123),,
,w(V234.23[0]),
fork(T2),,
,,acq(L34)
..rel(L34)
join(T2),,
```

# Rapid架构
- Engine：一个抽象类，可以被继承来实现不同的动态分析引擎
- Generic Utilities：通用实用程序——为了实现动态分析引擎，可能会使用复杂的数据结构，如矢量时钟(VC)、自适应VC (epoch)等。我们已经在软件包util中实现了一些流行的工具，这些工具正在一些竞赛检测引擎中使用
- Parsing Utilities：在parse包中实现了RVPredict、CSV、STD三种格式的trace轨迹解析功能

# 使用方式
`java -cp ./lib/*:rapid.jar <PrintClass> -f <format> -p <path>`
- PrintClass：PrintSTD或PrintCSV
- 如果跟踪是使用RoadRunner生成的，则<format>为rr
- 如果跟踪是使用RVPredict生成的，则<format>为rv
- 打完包的文件在lib\rapid.jar中

源码ant打包：
```
git clone git@github.com:umangm/rapid.git
cd rapid;
ant clean;
ls lib/;
ant build;
ant jar;
在rapid目录下
java -cp ./lib/*;rapid.jar PrintSTD -f rv -p 目录
```

测试：
```
java -cp .\lib\*;rapid.jar PrintSTD -f rv -p D:\Github\codedemo\springbootdemos06\springbootdemo500-RvPredict\rv\result\result.txt
java -cp .\lib\*;rapid.jar PrintCSV -f rv -p D:\Github\codedemo\springbootdemos06\springbootdemo500-RvPredict\rv\result\result.txt
```

# 踩坑
1. 报错 错误: 找不到或无法加载主类 PrintSTD
```
Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/commons/cli/ParseException
...
```
在rapid目录下执行
- https://blog.csdn.net/qq_21383435/article/details/126880181
- -cp .\lib\*;rapid.jar 中间是：不是

2. 解析不了
- rapid版本问题

