# 参考地址
URI模板的全功能Java实现（RFC6570）：为您的REST API创建URI，不留任何错误空间
- https://github.com/fge/uri-template

# uri template概述
可用替换：
```
查询参数映射的替换
http://foo.bar.com/some/request{?queryparams*}
简单替换
http://some.restsite.com/{user}/profile
片段替换
http://yet.another.site/path/to/somewhere#{+fragmentPart}
```
如键值对`hello -> world!`
替换为：`http://foo.bar.com/some/request?hello=world`

