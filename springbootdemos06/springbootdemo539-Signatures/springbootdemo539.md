# 参考地址
signatures 分子签名工具包
- https://github.com/gilleain/signatures

# 简介
这个项目是对Jean-Loup Faulon的分子签名代码的重写，使其独立于工具包。签名最终是整个分子或原子价态环境的规范表示。
- 例如，苯的典型特征可能很简单:C(C(C(C1))C(C(C1)))其中括号表示分支，数字表示连接(如SMILES)

# 踩坑
- maven依赖的没有chemisty等包，需要自行编译打包
