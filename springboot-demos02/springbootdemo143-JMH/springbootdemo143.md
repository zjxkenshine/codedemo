# 参考地址
基准测试框架JMH使用详解
- https://blog.csdn.net/ZYC88888/article/details/113741316

浅谈性能测试中的基准测试
- https://zhuanlan.zhihu.com/p/45221637

使用JMH进行性能测试详细idea版
- https://zhuanlan.zhihu.com/p/74891608

# 踩坑
```
ERROR: transport error 202: connect failed: Connection refused
ERROR: JDWP Transport dt_socket failed to initialize, TRANSPORT_INIT(510)
JDWP exit error AGENT_ERROR_TRANSPORT_INIT(197): No transports initialized [debugInit.c:750]
```
- 不要用debug，用start



