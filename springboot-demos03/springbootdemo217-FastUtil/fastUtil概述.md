# 1.简介
- fastutil是扩展了Java标准集合框架（Map、List、Set；HashMap、ArrayList、HashSet）的类库，提供了特殊类型的map、set、list和queue-
- fastutil能够提供更小的内存占用，更快的存取速度
- fastutil尽量提供了在任何场景下都是速度最快的集合类库
- 它还为二进制和文本文件提供大型（64 位）数组、集合、列表和快速实用的 I/O 类

# 2.类概述
1. ints包：int相关数据结构合集
2. longs包: long相关数据结构合集
3. booleans包
4. bytes包
5. chars包
6. floats包
7. doubles包
8. shorts包
9. objects：对象相关数据结构
10. io：更快的io
    - BinIO：提供静态方法来轻松执行二进制 I/O
    - MeasurableStream：可访问确切位置的Stream
    - RepositionableStream：指定字节流定位方法的接口
    - TextIO：提供静态方法以轻松执行文本 I/O
11. 其他数据结构：
    - BidirectionalIterator：双向迭代器
    - Arrays：数组操作
    - BigArrays：大数组操作
    - BigList：大列表
    - BigListIterator：大列表迭代
    - BigSwapper：可以交换位置由 long 指定的元素的对象
    - Function：将键映射到值的函数
    - Hash
    - Pair<L, R>：一对数据
    - PriorityQueue：优先级队列
    - Size64：大小可以超过Integer.MAX_VALUE数据结构的接口
    - Stack：栈
    - Swapper：交换接口

