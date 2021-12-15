# 1.Snappy简介
- Snappy是一个快速的压缩解压工具，由谷歌开发
- 大约 200~400MB/秒的快速压缩/解压缩
- Snappy-Java 基于 JNI 的实现可实现与本机 C++ 版本相当的性能

# 2.SnappyJava主要功能与组成
- Snappy.compress/Snappy.uncompress：压缩/解压缩
- Snappy.rawCompress/Snappy.rawUncompress：低级别方法
- SnappyOutputStream/SnappyInputStream：基于流的压缩器/解压器
- SnappyFramedOutputStream/SnappyFramedInputStream：可用于帧格式
- SnappyHadoopCompatibleOutputStream
- BitShuffle：一种重新排序数据位（shuffle）以实现高效压缩（例如，整数序列、浮点值等）的算法
    - 支持原始数组（例如short[]，long[]， float[]，double[]， 等）的混洗和解混

