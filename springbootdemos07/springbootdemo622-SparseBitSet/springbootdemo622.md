# 参考地址
SparseBitSet 一种高效的Java稀疏位集实现
- https://github.com/brettwooldridge/SparseBitSet

什么是稀疏数组？稀疏数组详解
- https://blog.csdn.net/sunnyzyq/article/details/116763427

# 简介
- 标准Java BitSet的内存效率非常低。使用位232-1的BitSet存储，单个位需要227个32位字（226个64位“字”）
- SparseBitSet 使用类似虚拟内存的结构，SparseBitSet的开销为每64位约0.03个32位字的开销

