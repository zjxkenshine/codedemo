# 参考文档
kryo
- https://github.com/EsotericSoftware/kryo

java原生序列化和Kryo序列化性能比较
- https://www.cnblogs.com/520playboy/p/6341490.html

kryo序列化使用及踩坑过程
- https://www.jianshu.com/p/be25792212ac/

# 踩坑
com.esotericsoftware.kryo.KryoException: Buffer underflow.
```
    if (remaining < required) {
         throw new KryoException("Buffer underflow.");
    }
```
忽略不抛出就可以