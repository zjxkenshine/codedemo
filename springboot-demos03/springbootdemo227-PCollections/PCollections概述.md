# 1.PCollections概述
一个持久的Java集合库

# 2.主要解决问题
- 解决了Guava和`Java.util.Collections`中不可变集合的复制问题
- 如有一个不可变集合x，想要得到一个新的不可变集合x1，x1仅比x多一个元素e，类似String方式
    - java集合需要先复制一个集合再进行添加
    - PCollections可以如下操作：`PCollection y2 = y.plus(e);`

# 3.主要API
- HashTreePMap接口：PMap实现
- ConsPStack接口：PStack实现
- TreePVector接口：PVector实现
- HashTreePSet接口：PSet实现
- HashTreePBag接口：PBag实现，类似Set无序但是可以包含重复元素


