# 简介
eveldb 是一个持久化的 key/value 存储，key 和 value 都是任意的字节数组(byte arrays)，并且在存储时，key 值根据用户指定的 comparator 函数进行排序

# 特性
- keys 和 values 是任意的字节数组。
- 数据按 key 值排序存储。
- 调用者可以提供一个自定义的比较函数来重写排序顺序。
- 提供基本的 Put(key,value)，Get(key)，Delete(key) 操作。
- 多个更改可以在一个原子批处理中生效。
- 用户可以创建一个瞬时快照(snapshot)，以获得数据的一致性视图。
- 在数据上支持向前和向后迭代。
- 使用 Snappy 压缩库对数据进行自动压缩
- 与外部交互的操作都被抽象成了接口(如文件系统操作等)，因此用户可以根据接口自定义的操作系统交互
- 不支持SQL

# LevelDBTest目录
- test01：添加删除
- test02：批量写
- test03：遍历
- test04：快照
- test05：自定义比较器
- test06：禁用压缩
- test07：设置缓存最大值
- test08：获取状态
- test09：设置日志实现
- test10：删除数据库
- test11：内存池
- test12：修复数据库
