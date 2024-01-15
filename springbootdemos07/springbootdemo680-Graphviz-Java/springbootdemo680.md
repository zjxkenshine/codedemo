# 参考地址
graphviz-java java操作graphviz
- https://github.com/nidi3/graphviz-java

快速使用Graphviz实现简单的图论绘制【java辅助文件读取】
- https://blog.csdn.net/laodanqiu/article/details/122265544

# 依赖
- graphviz-java：大部分情况，包含平台需要的J2V8包
- graphviz-java-all-j2v8：包含所有平台的j2v8
- graphviz-java-min-deps：最小依赖，其他可选
- org.graalvm.js.js.20.0.0：jdk15之后需要
- 需要提供slf4j日志实现

# 目录
- Test01：三种生成图方式
- Test02：解析dot文件
- Test03：复杂示例
- Test04：设置图片节点
- Test05：输入输出配置
- Test06：图片转手绘
- GraphvizTagle：注释插件