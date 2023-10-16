# 参考地址
- https://blog.csdn.net/jiuba_wb/article/details/124625869
- https://blog.csdn.net/qianjingfan/article/details/123207572
方法：
- BCrypt.gensalt() : 生成salt的方法，一般不需要单独调用，和其他方法一起使用。gensalt() 生成盐的方法默认入参是10，你也可以设置复杂的入参，有效的数值在（4-30）
- BCrypt.hashpw(password, BCrypt.gensalt(4))：生成hash密码，传入用户密码和salt
- BCrypt.checkpw(candidate, hashed)：密码验证，传入密码候选值和hash密码
