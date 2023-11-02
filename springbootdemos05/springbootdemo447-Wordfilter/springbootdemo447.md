# 参考地址
gitHub
- https://github.com/humingzhang/wordfilter

# API
- 敏感词替换：replace
- 是否包含敏感词：include
- 获取敏感词数：wordCount
- 获取敏感词列表：wordList
- 增加白名单功能：
    - blacklist.txt
    - whitelist.txt
- 在线添加敏感词：addWord
- 在线删除敏感词：removeWord，白名单没有就忽略
- Skip距离：跳过不同的距离，查找敏感词，距离越长，过滤越严格，效率越低
    - 0 匹配张三 
    - 1 匹配张三，张x三 
    - 2 匹配张三，张x三，张xx三
