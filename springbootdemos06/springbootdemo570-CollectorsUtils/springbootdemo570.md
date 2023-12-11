# 参考地址
collectors-utils 为JDK 8 Stream API提供收集器
- https://github.com/JosePaumard/collectors-utils

# 简介
- CollectorsUtils API提供了一系列可用于Java 8 Stream API的收集器。
- JDK中提供的Collectors工厂类模型提供了大约12个类别的大约40个收集器。
- 而CollectorsUtils工厂类提供了6个类别的28个收集器。

# CollectorsUtils收集器简介
## 1.查找最频繁的 test01
- `findMostFrequent()`：这个收集器返回流中所有最常见的值的集合。如果有几个最常见的值，则它们都存在于集合中
- `streamMostFrequent()`：将结果放入流中，以便进行进一步处理。

## 2.提取一个最大值并返回 test02
这些收集器从流中提取一个最大值，并将其包装在一个可选值中返回
- `groupingByAndMaxBy()`：将多个操作打包为一个操作，group分组后选择最大值
- `groupingByAndMaxByCounting()`：上一个具有count（）下游收集器和comparingByValue（）比较器的收集器相同
- `groupingByAndMaxByValue()`：分组并比较值最大
- `groupingBySelfAndMaxByValue()`：findMostFrequent相同，但仅找第一个最频繁的
- `maxByCounting`：与第一个收集器相同,identity()

## 3.提取所有最大值并返回 test03
这些收集器从流中提取所有的最大值，并将它们返回到一个集合中
- `groupingByAndAllMaxBy()`：提取所有的最大值，并将它们返回到一个集合中
- `groupingByAndAllMaxByValue()`：采用了值的比较器，而不是条目的比较器
- `groupingByAndStreamAllMaxByValue`：返回结果为流

## 4.groupingByAndMaxesBy() test04
- 分组并选择符合条件的尽可能多的元素

## 5.将映射器作为可以返回集合或流的参数 test05
- mapToStream()/toStream()

## 6.转换为流集合，平面映射器
- flattenToStream，flatMapToStream：返回集合或流的函数

## 7.map然后转换为流 test06
- toMapThenStream：映射转换
- groupingByThenStream：分组转换

## 8.flatMapping 从每个元素生成流，并转换 test07

