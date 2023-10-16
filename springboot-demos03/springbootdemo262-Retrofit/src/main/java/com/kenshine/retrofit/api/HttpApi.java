package com.kenshine.retrofit.api;

import com.github.lianjiatech.retrofit.spring.boot.annotation.Intercept;
import com.github.lianjiatech.retrofit.spring.boot.annotation.RetrofitClient;
import com.kenshine.retrofit.domain.TestEntity;
import com.kenshine.retrofit.interceptor.TokenInterceptor;
import okhttp3.MultipartBody;
import org.springframework.stereotype.Component;
import retrofit2.Response;
import retrofit2.http.*;

import java.util.List;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/16 22:53
 * @description：
 * @modified By：
 * @version: $
 *
 * 接口必须使用@RetrofitClient注解标记！
 *
 * include里面是要拦截的路径，还可配置exclude = ""不包含路径
 * //路径前缀，必须以 / 结尾
 */
@Component
@RetrofitClient(baseUrl = "http://localhost:8080/")
@Intercept(handler = TokenInterceptor.class, include = "test/**")
public interface HttpApi {

    /**
     *方法注解：@GET、@POST、@PUT、@DELETE、@PATH、@HEAD、@OPTIONS、@HTTP。
     * 标记注解：@FormUrlEncoded、@Multipart、@Streaming。
     * 参数注解：@Query，@QueryMap；@Body；@Field、@FieldMap；@Part，@PartMap。
     * 其他注解：@Path；@Header,@Headers；@Url
     *
     * 下面是一些使用示例
     */

    //发送 Get 请求时，不可传值实体类，会报错
    //传送实体类的时候必须加 @Body
    @POST("server/postList")
    List<TestEntity> postList(@Body TestEntity testEntity);

    @GET("server/getList")
    List<TestEntity> getList(@Query("pageNum") Integer pageNum, @Query("pageSize") Integer pageSize);

    @GET("server/entity/{id}")
    List<TestEntity> getList2(@Path("id") Long id);

    // 调用Test01
    @GET("server/test01")
    Void getTest();

    //!!!!!
    //注意
    //注意，没有返回值，用void会启动报错，要用大写的 Void 才不会报错
    @GET("test/delete/{id}")
    Void delete(@Path("id") Long id);

    @POST("test/add")
    Void add(@Body TestEntity testEntity);

    @POST("test/update/{id}")
    Void update(@Path("id") Long id, @Body TestEntity testEntity);

    //@FormUrlEncoded 代表发送表单数据
    //@Field会拼接name和age为 name1=age1&name2=age2 这种格式
    @FormUrlEncoded
    @POST("test")
    Void postFrom(@Field("name") String name,@Field("occupation") String age);

    //还有一个@FieldMap
    @FormUrlEncoded
    @POST("test")
    Void postMap(@FieldMap Map<String, String> fields);

    //@Header注解:作用于方法的参数,用于添加请求头，使用该注解定义的请求头可以为空,当为空时,会自动忽略,当传入一个List或array时,为拼接每个非空的item的值到请求头中
    //可作用在参数上
    @GET("server/getHeader")
    Void header(@Header("Accept-Language") String head);

    //还有一个@HeaderMap：以map的方式添加多个请求头,map中的key为请求头的名称,value为请求头的值,且value使用String.valueOf()统一转换为String类型，
    //map中每一项的键和值都不能为空,否则抛出IllegalArgumentException异常
    @GET("test")
    Void headers(@HeaderMap Map<String, String> headers);

    //也可作用于方法上,具有相同名称的请求头不会相互覆盖,而是会照样添加到请求头中
    @Headers("Accept: text/plain")
    @GET("/")
    Void headers2();

    //HTTP注解：作用于方法,用于发送一个自定义的HTTP请求
    //发送一个DELETE请求,发送实体类要加hasBody
    @HTTP(method = "DELETE", path = "test/delete", hasBody = true)
    Void delete2(@Body TestEntity testEntity);

    //也可以自定义HTTP请求的标准样式
    @HTTP(method = "CUSTOM", path = "test/")
    Void custom();

    //@HTTP(method = "DELETE"）等价于 @DELETE("/")，@HTTP(method = "PUT"）等价于 @PUT("/")

    //Multipart注解：使用该注解,表示请求体是多部分的。 每一部分作为一个参数,且用Part注解声明

    //使用Part注解定义的参数类型有以下3种方式可选:
    //1, 如果类型是okhttp3.MultipartBody.Part，内容将被直接使用。 省略part中的名称,即 @Part MultipartBody.Part part
    //2, 如果类型是RequestBody，那么该值将直接与其内容类型一起使用。 在注释中提供part名称（例如，@Part（“foo”）RequestBody foo）。
    //3, 其他对象类型将通过使用转换器转换为适当的格式。 在注释中提供part名称（例如，@Part（“foo”）Image photo）
    @Multipart
    @POST("/")
    Void multipartExample(@Part("description") String description, @Part(value = "image", encoding = "8-bit") TestEntity image, @PartMap Map<String, String> params);

    //下面演示一下上传文件和下载文件，serviceImpl 的写法有些不一样
    @POST("test/upload")
    @Multipart
    Void upload(@Part MultipartBody.Part file);

    @GET("test/{fileKey}")
    Response download(@Path("fileKey") String fileKey);

}
