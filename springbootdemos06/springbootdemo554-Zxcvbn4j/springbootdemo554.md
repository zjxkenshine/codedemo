# 参考地址
github zxcvbn4j
- https://github.com/nulab/zxcvbn4j

# 得分
```
# 0 Weak        （guesses < 10^3 + 5）
# 1 Fair        （guesses < 10^6 + 5）
# 2 Good        （guesses < 10^8 + 5）
# 3 Strong      （guesses < 10^10 + 5）
# 4 Very strong （guesses >= 10^10 + 5）
```

# 踩坑
- 加载不到resource bundle：要放在resource目录下
- 乱码：java中properties配置文件默认的编码为：ISO-8859-1，是不支持中文的，所以会乱码，自己转码
    - 暂未解决，源码绑定问题，需要自己实现resource bundle绑定

