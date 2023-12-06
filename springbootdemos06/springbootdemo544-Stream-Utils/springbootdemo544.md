# 参考地址
Streams Utils是一组基于Java 8 Streams编写的操作。它允许一些Java 8中没有的基本操作，这些操作在某些情况下被证明是非常有用的。它是More Spliterators的更新版本。
- https://github.com/JosePaumard/streams-utils

# 目录
- test01：cycle重复流元素 
- test02：group分组 
- test03：group自定义分组分隔符
- test04：repeat重复整个流
- test05：roll滚动生成流
- test06：traverse每个流取一个元素生成几个流
- test07：weave每个流取一个元素生成一个流
- test08：zip压缩合并流
- test09：validate验证处理流
- test10：interrupt中断流
- test11：gate判定为真开始生成流
- shiftingWindowCollect、shiftingWindowSummarizingInt、shiftingWindowAveragingDouble
    - 计算平均值，总和等的流
