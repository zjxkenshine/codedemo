# 参考文档
slice
- https://github.com/airlift/slice

presto Slice入门
- https://blog.csdn.net/u010711495/article/details/112258730

# 踩坑
java.lang.ClassNotFoundException: io.airlift.slice.Slices
- 使用main方法报错，使用test则不会
- maven添加了`<scope>provided</scope>`，只在编译和测试时有用
