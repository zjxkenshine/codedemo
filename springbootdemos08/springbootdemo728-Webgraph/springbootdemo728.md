# 参考地址
webgraph 图压缩框架
- https://github.com/vigna/webgraph

需要java9以上

官网
- https://webgraph.di.unimi.it/
- https://webgraph.di.unimi.it/docs/

数据集
- https://law.di.unimi.it/datasets.php

# 概述
1. 一组简单的代码，称为ζ代码，特别适合存储网络图
2. 压缩网络图的算法利用间隙压缩和差分压缩、intervalidation和ζ代码来提供高压缩比
3. 访问压缩图而不实际解压缩的算法，使用延迟技术将解压缩延迟到实际需要时
4. 分析超大图形的算法，如HyperBall

# 相关类
- ImmutableGraph：不可变图
- BVGraph：BV算法实现的压缩图
- EFGraph：Elias–Fano算法压缩图
- ArrayListMutableGraph：增量创建图，并可以提取不可变图
- ASCIIGraph/ArcListASCIIGraph：以ASCII形式保存不可变图
- IntegerListImmutableGraph：数据导入图示例
- ArcLabelledImmutableGraph：带弧标记的图
