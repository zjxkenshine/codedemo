# 参考地址
github
- https://github.com/davidmoten/geo

GeoHash算法学习讲解、解析及原理分析
- https://zhuanlan.zhihu.com/p/35940647

GeoHash算法简介
- https://blog.csdn.net/okiwilldoit/article/details/118897109

# 组成：
- `GeoHash.encodeHash`：编码geohash从纬度，经度到任意长度
- `GeoHash.decodeHash`：反编码geo
- `GeoHash.adjacentHash`：查找在任何方向的相邻哈希
- `GeoHash.neighbours`：找到所有8个相邻的哈希到一个哈希
- `GeoHash.hashLengthToCoverBoundingBox`：计算围合边界框的散列长度
- `GeoHash.coverBoundingBox`：计算给定长度的geohash以覆盖边界框，返回覆盖率
- `GeoHash.heightDegrees,GeoHash.widthDegrees`：以度计算geohash的高度和宽度
- `Base32.encodeBase32，Base32.decodeBase32`：对geohash中的long值进行编码和解码
- `GeoHash.coverBoundingBoxMaxHashes`：设置GeoHash.coverBoundingBox最大hash数，默认12
- `Position.getDistanceToKm`：以公里为单位的高度和宽度将取决于哈希在地球的哪个部分
