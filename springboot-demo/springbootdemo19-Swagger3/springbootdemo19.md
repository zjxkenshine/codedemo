# 参考文档
SpringBoot2.x 集成 Swagger3,knife4j
- https://blog.csdn.net/RtxTitanV/article/details/117908735
- https://blog.csdn.net/RtxTitanV/article/details/117908750

# 配置
可能需要在mvc配置静态资源
```
        registry.addResourceHandler("doc.html")
                .addResourceLocations("classpath:/META-INF/resources/");
```