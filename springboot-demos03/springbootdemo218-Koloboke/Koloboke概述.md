# 1.Koloboke简介
- Koloboke的目标是替换标准的Java集合和流的API，提供更高效的实现
- Koloboke提供了一套完整的集合原始类型的实现，可以避免开销很大的装箱/拆箱操作，节省了原始类型装箱消耗的内存

# 2.性能
在Koloboke中，HashSet和HashMap比其它专门的实现（比如GS collections、fastutil、Trove）要更快
- 相比于其它库，Koloboke对每个entry使用了更少的内存
- Koloboke目标是把键和值存储在同一行高速缓存中
- 所有的方法都经过了实现优化，而不是像AbstractSet类或AbstractMap类那样委托给框架类

# 3.包
- collect:集合实现
    - hash:原始类型hash工厂
    - map:map接口集合
        - hash:hashMap
    - set:set接口集合
        - hash:hashSet
- function:java8函数式接口原始类型实现
- Cusor接口:指向迭代中元素的可变指针

# 4.以intintMap为例
- IntIntMap：顶层接口
    - HashIntIntMap：Hash接口
- IntIntMapFactory：Map工厂
    - HashIntIntMapFactory：Hash工厂接口
        - `newMutableMap`：创建可变Map
        - `newMutableMapOf()`：从元素中创建可变Map
        - `newUpdatableMap`：创建可更新Map
        - `newUpdatableMapOf()`：从元素中创建可更新Map
        - `newImmutableMap`：不可更改Map
        - `newImmutableMapOf()`
- HashIntIntMaps：静态方法用于创建
 
具体实现抽象类：
- LHashParallelKVIntIntMapFactorySO：LHash轻量级Hash实现（工厂）
- QHashParallelKVIntIntMapFactorySO：QHash实现（工厂）
- ImmutableLHashParallelKVIntIntMapSO
- ImmutableQHashParallelKVIntIntMapSO
- MutableLHashParallelKVIntIntMapSO
- MutableQHashParallelKVIntIntMapSO
- UpdatableLHashParallelKVIntIntMapSO
- UpdatableQHashParallelKVIntIntMapSO