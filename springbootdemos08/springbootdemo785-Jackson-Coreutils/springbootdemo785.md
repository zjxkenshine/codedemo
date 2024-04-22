# 参考地址
jackson-coreutils JSON指针（RFC 6901）和JSON数字等效
- https://github.com/fge/jackson-coreutils

鲜为人知的 jackson Pointer 语法，超好用！
- https://www.51cto.com/article/775548.html

# 提供功能
数字等效：
```
[ 1, 2, 3 ]
等价与
[ 10e-1, 2.0, 0.3e1 ]
```

JSON指针是IETF RFC（6901），它允许将任何值明确地寻址到JSON文档中（包括文档本身，带有空指针）

跟踪数据检测：
`[]]`，会抛出异常
