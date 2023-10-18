# 参考地址
lxm23/ id-generator
- https://gitee.com/simpleweb/id-generator

```
// 生成id
long genId();

// 批量生成id
long[] batchGenId(int count);

// 解析id
Id decode(long id);

// 手动生成id
long encode(long time, long dataCenterId, long workerId, long seq);

// 解析id中的时间戳
Date transTime(long time);
```

