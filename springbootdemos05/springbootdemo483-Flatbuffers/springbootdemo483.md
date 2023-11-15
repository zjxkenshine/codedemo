# 参考地址
flatbuffers
- https://github.com/davidmoten/flatbuffers

flatc下载
- https://github.com/google/flatbuffers/releases

java flatbuffers
- https://blog.51cto.com/u_16175475/6978386

# 基本使用
- 定义schema文件 .fbs 结尾
- `flatc --java monster.fbs` 生成java类
`flatc --java F:\IDEAworkespace\codedemo\springbootdemos05\springbootdemo483-Flatbuffers\src\main\java\com\kenshine\fbs\monster.fbs`
- 使用生成的java类进行读写
- 创建对象使用Builder构建