# 参考地址
官网
- https://github.com/vigna/dsiutils
- https://dsiutils.di.unimi.it/

# 目录
## io包：DsiutilsTest01
- FileLinesCollection：file行转collection，已过时，可以使用FileLinesMutableStringIterable
- FileLinesByteArrayCollection：将文件的行显示为字节数组，过时，使用FileLinesByteArrayIterable
- ByteBufferInputStream：ByteBuffer和InputStream桥接
- ByteDiskQueue：部分存储在磁盘上的字节队列。
- DebugInputBitStream\DebugOutputBitStream：输入输出bitStream的调试包装器
- DelimitedWordReader：读取文字并拆分
- FastBufferedReader：基于的轻量级、非同步缓冲读取器
- FileLinesByteArrayIterable：将文件的行显示为字节数组
- FileLinesMutableStringIterable：将文件的行显示为mutable stream迭代器
- InputBitStream：bit级别的流
- LineIterator：一个适配器，迭代行
- LineWordReader：将文档的每一行视为一个单词
- MultipleInputStream：多输入流
- NullInputStream：无输入流
- NullOutputStream：无输出，扔掉结果
- NullReader：无输入读取
- OfflineIterable：提供以前使用专用序列化方法脱机存储的元素。
- SafelyCloseable：安全关闭接口
- SegmentedInputStream：将单个显示为多个流，这些流被划分为单独的段
- WordReader：读取文件并拆分接口

## big.util包：DsiutilsTest02
- AbstractPrefixMap：前缀抽象Map
- FrontCodedStringBigList：使用前端编码压缩实现字符串的紧凑存储列表
- ImmutableBinaryTrie：不可变二叉搜索树
- ImmutableExternalPrefixMap：不可变前缀Map
- LiterallySignedStringMap：使用原始字符串列表签名的函数的字符串Map
- LongBigListSignedStringMap：LongBigList签名的String map 已过期
- MappedFrontCodedStringBigList：FrontCodedStringBigList的内存映射版本
- PermutedFrontCodedStringBigList：PermutedFrontCodedStringList的大版本
- PrefixMap：前缀到字符串间隔的映射
- SemiExternalGammaBigList：提供对OutputBitStream整数的LongBigList的半外部随机访问
- ShiftAddXorSignedStringMap：基于使用Shift-Add-Xor散列签名的函数的StringMap 已过时，有更好的散列函数
- StringMap：String到Long的映射
- StringMaps：StringMap相关静态方法
- TernaryIntervalSearchTree：三元去见搜索树

## bits
- AbstractBitVector：BitVector的抽象实现
- BitVector：bit级别的vector
- BitVectors：一个提供BitVector相关静态方法和对象的类
- BooleanListBitVector：基于布尔列表的实现的BitVector
- Fast：所有用于优化的位篡改静态方法容器类
- HuTuckerTransformationStrategy：将字符串映射到它们的Hu-Tucker编码的转换策略
- LongArrayBitVector：long数组实现的BitVector
- LongBigArrayBitVector：big版本
- PrefixCoderTransformationStrategy：前缀压缩转换策略
- TransformationStrategies：一个提供静态方法和对象的类，这些方法和对象通过转换策略做有用的事情
- TransformationStrategy：从给定类型的对象到BitVector的转换策略

## compression 压缩
- CanonicalFast64CodeWordDecoder：一种用于规范霍夫曼代码的快速基于表的解码器，仅支持具有有限（小于64位）的代码
- Codec：编码接口
- Coder：特定压缩技术的编码方法
- CodeWordCoder：基于CodeWord的编码器
- Decoder：解码接口
- Fast64CodeWordCoder：一种基于长度不超过64的码字集的快速编码器
- HuffmanCodec：Huffman编码
- HuTuckerCodec：HuTucker编码
- PrefixCodec：前缀编码
- PrefixCoder：前缀编码器
- TreeDecoder：在树中遵循0/1个标记路径的解码器

## lang
- EnumStringParser：Enum到String转换
- FlyweightPrototype：提供轻量复制操作的接口
- FlyweightPrototypes：工具类
- MutableString：可变String
- ObjectParser：基于字符串的简单对象规范的解析器

## parser 提供XML/HTML解析，过时

## stat
- Jackknife：将jacknifer应用于一般统计数据
- SummaryStats：一个简单的类，用于消化数字流并提供有关该流的基本统计信息
- Ziggurat：Ziggurat算法生产随机数

## util包
- ReorderingBlockingQueue：带有时间戳记录的阻塞队列
- AbstractPrefixMap：前缀映射抽象
- BloomFilter：布隆过滤器
- CircularCharArrayBuffer：循环字符缓冲区，可用于实现文本上的滑动窗口
- HyperLogLogCounterArray：近似集的数组，每个近似集使用HyperLogLog计数器表示
- Interval：整数的间隔
- Intervals：工具类
- IntParallelCounterArray：近似集合的数组，每个集合使用并行计数器表示
- KahanSummation：封装在对象中的Kahan求和算法
- LiterallySignedStringMap：基于使用原始字符串列表签名的函数的字符串映射
- LongInterval：long整数间的距离
- LongIntervals：工具类
- PermutedFrontCodedStringList：索引排列的FrontCodedStringList
- PrefixMap：前缀Map接口
- Properties
- SemiExternalGammaList：提供Gamma编码的半外部随机访问列表
- SplitMix64Random：快速、高质量、不可拆分的SplitMix版本
- SplitMix64RandomGenerator：伪随机数生成器
- TernaryIntervalSearchTree：三元区间搜索树
- TextPattern：快速匹配
- XorGensRandomGenerator：64位随机数生成器
- XoRoShiRo128PlusPlusRandom：128位随机数生成
- XorShift64StarRandom：Xorshift随机数生成，已过期
- Util：通用静态方法


