package forestTest;

import com.dtflys.forest.Forest;
import com.kenshine.forest.ForestApp;
import com.kenshine.forest.client.MyClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 22:10
 * @description：测试
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ForestApp.class)
@Slf4j
public class ForestTest {

    @Resource
    private MyClient client;

    /**
     * Client用法
     */
    @Test
    public void test01(){
        System.out.println(client.helloForest());
    }

    /**
     * 快捷接口
     */
    @Test
    public void test02(){
        // Get请求
        // 并以 String 类型接受数据
        String str = Forest.get("http://localhost:8080/hello").executeAsString();
        System.out.println(str);
    }

    /**
     *post 定义各种参数
     */
    @Test
    public void test03(){
        Map<String, Object> map = Forest.post("/test03")
                .backend("okhttp3")        // 设置后端为 okhttp3
                .host("127.0.0.1")         // 设置地址的host为 127.0.0.1
                .port(8080)                // 设置地址的端口为 8080
                .contentTypeJson()         // 设置 Content-Type 头为 application/json
                .addBody("name", "kenshine")           // 添加 Body 项(键值对)： a, 1
                .addBody("password", 123456)           // 添加 Body 项(键值对：  b, 2
                .addBody("age", 40)
                .maxRetryCount(3)          // 设置请求最大重试次数为 3
                // 设置 onSuccess 回调函数
                .onSuccess((data, req, res) -> { log.info("success!"); })
                // 设置 onError 回调函数
                .onError((ex, req, res) -> { log.info("error!"); })
                // 设置请求成功判断条件回调函数
                .successWhen((req, res) -> res.noException() && res.statusOk())
                // 执行并返回Map数据类型对象
                .executeAsMap();
        System.out.println(map);
    }


    /**
     * 异步请求
     */
    @Test
    public void test04(){
        // 异步 Post 请求
        // 通过 onSuccess 回调函数处理请求成功后的结果
        // 而 onError 回调函数则在请求失败后被触发
        Forest.post("/test04")
                .backend("okhttp3")        // 设置后端为 okhttp3
                .host("127.0.0.1")
                .port(8080)                // 设置地址的端口为 8080
                .async()
                .contentTypeJson()         // 设置 Content-Type 头为 application/json
                .onSuccess(((data, req, res) -> {
                    // data 为响应成功后返回的反序列化过的数据
                    // req 为Forest请求对象，即 ForestRequest 类实例
                    // res 为Forest响应对象，即 ForestResponse 类实例
                    System.out.println(data);
                }))
                .onError(((ex, req, res) -> {
                    // ex 为请求过程可能抛出的异常对象
                    // req 为Forest请求对象，即 ForestRequest 类实例
                    // res 为Forest响应对象，即 ForestResponse 类实例
                    System.out.println("error"+ex.getMessage());
                }))
                .execute();
    }


}
