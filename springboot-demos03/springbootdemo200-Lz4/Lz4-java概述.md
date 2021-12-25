# 1.简介
主要由两部分组成：
- LZ4 Java：LZ4算法的Java实现
- xxhash Java：xxhash散列的Java实现
    - xxhash 是一种非加密、极快和高质量的哈希函数

# 2.LZ4
主要类: LZ4Factory
1. 两种压缩方式：
    - 快速压缩：LZ4
    - 高压缩比：LZ4 HC
        - 比LZ4 HC慢10倍
2. 两种压缩方式可以使用相同解压器解压
3. 有 3 种实现：
    - JNI 绑定到原始C实现
    - 纯 Java 实现
    - 使用 sun.misc.Unsafe API 以实现接近 C 实现的压缩和解压缩速度

# 3.xxhash
主要类：XXHashFactory
- 与LZ4一样有三种实现：
    - JNI
    - 纯Java
    - Unsafe API