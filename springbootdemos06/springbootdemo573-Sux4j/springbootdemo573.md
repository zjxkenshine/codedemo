# 参考地址
sux4j 致力于将简洁数据结构引入Java
- https://github.com/vigna/Sux4J
- https://sux4j.di.unimi.it/

java17环境

# 简介
bit包
- Rank：基于bit数组的排名接口 Sux4jTest01.test01
    - SparseRank：稀疏bit数组的Rank实现，通过EliasFanoMonotoneLongBigList
    - Rank9：使用25%额外空间并提供异常快速排名的Rank结构
    - Rank11：使用6.25%额外空间并提供非常快速排名的排名结构。
    - Rank12：使用3.125%额外空间并提供快速排名的排名结构
    - Rank16：使用18.75%额外空间的排名结构并提供快速排名
- Select：提供bit数组选择操作  Sux4jTest01.test02
  - SimpleSelect：一个基于两级清单、溢出列表和宽字位搜索的简单选择实现。
  - SimpleSelectZero：基于两级清单、溢出列表和宽字位搜索的简单零选择实现。
  - SimpleBigSelect：与LongBigArrayBitVector一起使用的big版本
  - Select9：使用25%-37.5%的额外空间
  
io包：
- FileLinesList：将File行转换为List Sux4jTest01.test03
- BucketedHashStore：签名的临时存储区，实际上分为多个桶 Sux4jTest01.test04

mph包：Sux4jTest02
- Codec：压缩接口,GV3CompressedFunction压缩函数中间态
- Linear3SystemSolver：3则运算处理
- Linear4SystemSolver：4则运算处理
- Modulo2System：模2
- GOV3Function：使用Linear3SystemSolver准简洁地存储的不可变函数
- GV3CompressedFunction：以压缩形式存储的不可变函数
- Hashes：基础hash函数
- HollowTrieDistributor：基于HollowTire的分配器
- HypergraphSorter：一个实现3层超图边缘排序过程的类
- MinimalPerfectHashFunction：最小完美散列函数
- PaCoTrieDistributor：基于递归比特流的二进制部分压缩trie的简洁实现
- TwoStepsGOV3Function：使用两个GOV3Function存储的函数;一个用于频繁值和一个用于不频繁值
- VLLcpMonotoneMinimalPerfectHashFunction：一种基于固定大小bucketing的单调最小完美散列实现，使用最长的公共前缀作为分配器，并使用@link GOVMinimalPerfectHashFunction存储它们的长度
- ZFastTrieDistributor：基于z-fast-tire的分发器。

util：提供了一些简洁的静态列表存储技术的实现 Sux4jTest03
- EliasFanoLongBigList：一个压缩的长列表；每个元素占据以1加上其比特长度加上元素的平均比特长度的对数为界的比特数。
- EliasFanoMonotoneLongBigList：EliasFano单调序列表示的一个实现；一个元素占据以2加上平均间隙的对数为界的位数
- Z-fast-tire：使用低线性附加空间并对查询字符串进行应答的前置/后续数据结构
- SignedFunctionStringMap：基于签名函数的字符串映射。
- TwoSizesLongBigList：一个压缩的长列表；小元素和大元素分别存储，使用两种不同的、最佳选择的比特大小。
- EliasFanoPrefixSumLongBigList：提供前缀的压缩列表

