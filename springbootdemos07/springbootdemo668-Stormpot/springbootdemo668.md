# 参考地址
Stormpot JVM下的快速线程池
- https://github.com/chrisvest/stormpot
- http://chrisvest.github.io/stormpot/

jdk 11以上环境

# 使用步骤
1. 定义一个分配器：MyAllocator 
   - 分配器负责创建和销毁Poolable 可池化对象
2. 定义一个poolable对象：MyPoolable 
   - 池中包含的对象必须实现Poolable接口并遵守其约定。
3. 组合MyAllocator与MyPoolable对象

