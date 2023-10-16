# 参考地址
spring-boot项目整合Retrofit最佳实践，最优雅的HTTP客户端工具！
- https://juejin.cn/post/6854573211426750472
- https://blog.csdn.net/why_still_confused/article/details/108041657

Retrofit2 详解和使用
- https://blog.csdn.net/m0_37796683/article/details/90702095

官方文档：
- https://square.github.io/retrofit/

# 1. 注解
方法注解
- @GET	get请求
- @POST	post请求
- @PUT	put请求
- @DELETE	delete请求
- @PATCH	patch请求，该请求是对put请求的补充，用于更新局部资源
- @HEAD	head请求
- @OPTIONS	options请求
- @HTTP	通过注解，可以替换以上所有的注解，它拥有三个属性：method、path、hasBody

请求头注解
- @Headers	用于添加固定请求头，可以同时添加多个，通过该注解的请求头不会相互覆盖，而是共同存在
- @Header	作为方法的参数传入，用于添加不固定的header，它会更新已有请求头

请求参数注解
- @Body	多用于Post请求发送非表达数据，根据转换方式将实例对象转化为对应字符串传递参数，比如使用Post发送Json数据，添加GsonConverterFactory则是将body转化为json字符串进行传递
- @Filed	多用于Post方式传递参数，需要结合@FromUrlEncoded使用，即以表单的形式传递参数
- @FiledMap	多用于Post请求中的表单字段，需要结合@FromUrlEncoded使用
- @Part	用于表单字段，Part和PartMap与@multipart注解结合使用，适合文件上传的情况
- @PartMap	用于表单字段，默认接受类型是Map<String,RequestBody>，可用于实现多文件上传
- @Path	用于Url中的占位符
- @Query	用于Get请求中的参数
- @QueryMap	与Query类似，用于不确定表单参数
- @Url	指定请求路径

请求和响应格式(标记)注解
- @FromUrlCoded	表示请求发送编码表单数据，每个键值对需要使用@Filed注解
- @Multipart	表示请求发送form_encoded数据(使用于有文件上传的场景)，每个键值对需要用@Part来注解键名，随后的对象需要提供值
- @Streaming	表示响应用字节流的形式返回，如果没有使用注解，默认会把数据全部载入到内存中，该注解在下载大文件时特别有用

更多高级用法查看官网：
- https://gitee.com/lianjiatech/retrofit-spring-boot-starter
