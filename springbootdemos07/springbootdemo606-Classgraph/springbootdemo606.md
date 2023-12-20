# 参考地址
ClassGraph - 超快速，超轻量级，并行化的Java类路径扫描程序
- https://blog.csdn.net/wan_zaiyunduan/article/details/123052094

github
- https://github.com/classgraph/classgraph

# 简介
- ClassGraph具有“反转”Java类和/或反射API的能力，或者具有索引类和资源的能力。
- 例如，Java类和反射API可以告诉你给定类的超类，或者给定类实现的接口，或者可以给你一个类的注释列表;ClassGraph可以找到所有扩展了给定类(给定类的所有子类)的类，或者所有实现给定接口的类，或者所有用给定注释标注的类。
- Java API可以在特定的ClassLoader中以特定的路径加载资源文件的内容，但ClassGraph可以在所有类加载器中找到并加载所有资源，其路径与给定的模式匹配。
