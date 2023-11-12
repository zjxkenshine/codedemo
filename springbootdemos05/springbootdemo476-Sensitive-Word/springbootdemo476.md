# 参考地址
sensitive-word
- https://github.com/houbb/sensitive-word

# API
## SensitiveWordHelper
- contains(String)：验证字符串是否包含敏感词
- replace(String, ISensitiveWordReplace)：替换字符串
- replace(String, char)/replace(String)
- findAll(String)：返回字符串中所有敏感词
- findFirst(String)：返回第一个敏感词

## SensitiveWordBs
引导类

## 整合spring
自定义数据库WordAllow及WordDeny，提供链式SensitiveWordBs Bean即可
