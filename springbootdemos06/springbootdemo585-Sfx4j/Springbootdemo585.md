# 参考地址
sfx4j 将一个jar文件打包到一个类文件中
- https://github.com/kohsuke/sfx4j

# 简介
这个项目允许您将一个可执行的jar文件嵌入到一个类/jar文件中。

打包jar到一个class文件:
- `java -jar sfx4j.jar myjar.jar out/PackedClass.class`

执行
- `java -cp out PackedClass`

生成可执行的jar文件
- `java -jar sfx4j.jar myjar.jar out/PackedClass.jar`