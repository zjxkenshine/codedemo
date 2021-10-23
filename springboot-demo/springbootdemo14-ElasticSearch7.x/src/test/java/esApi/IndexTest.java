package esApi;

import com.kenshine.EsApp;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 11:18
 * @description：索引测试
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApp.class)
@WebAppConfiguration
public class IndexTest {
    public static final String INDEX = "kenshine_test_index";

    @Autowired
    @Qualifier(value = "restHighLevelClient")
    private RestHighLevelClient client;

    //测试索引的创建
    @Test
    public void testCreateIndex() throws IOException {
        //1.创建索引的请求
        CreateIndexRequest request = new CreateIndexRequest(INDEX);
        //2客户端执行请求，请求后获得响应
        CreateIndexResponse response = client.indices().create(request, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    //测试索引是否存在
    @Test
    public void testExistIndex() throws IOException {
        //1.创建索引的请求
        GetIndexRequest request = new GetIndexRequest(INDEX);
        //2客户端执行请求，请求后获得响应
        boolean exist =  client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println("测试索引是否存在-----"+exist);
    }

    //删除索引
    @Test
    public void testDeleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest(INDEX);
        AcknowledgedResponse delete = client.indices().delete(request,RequestOptions.DEFAULT);
        System.out.println("删除索引--------"+delete.isAcknowledged());
    }

}
