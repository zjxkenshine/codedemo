package esApi;

import com.alibaba.fastjson.JSON;
import com.kenshine.EsApp;
import com.kenshine.domain.User;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/23 11:30
 * @description：文档操作测试
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApp.class)
@WebAppConfiguration
public class DocTest {
    public static final String INDEX = "kenshine_test_index";

    @Autowired
    @Qualifier(value = "restHighLevelClient")
    private RestHighLevelClient client;


    // 添加文档
    @Test
    public void testAddDocument() throws IOException {
        User user = new User("kenshine", 25);
        IndexRequest request = new IndexRequest(INDEX);
        // 规则 PUT /index/_doc/1
        request.id("1");
        request.timeout(TimeValue.timeValueSeconds(1));
        // 将数据放入请求 json
        request.source(JSON.toJSONString(user), XContentType.JSON);
        IndexResponse response = client.index(request, RequestOptions.DEFAULT);
        System.out.println(response.toString());
        System.out.println(response.status());
    }

    // 获取文档 判断是否存在 GET /index/_doc/1
    @Test
    public void testIsExists() throws IOException {
        GetRequest request = new GetRequest(INDEX, "1");
        // 不获取返回的 _source 的上下文了
        request.fetchSourceContext(new FetchSourceContext(false));
        request.storedFields("_none_");

        boolean exists = client.exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    // 获取文档
    /**
     * 返回结果：
     * {"age":28,"name":"狂神说"}
     * {"_index":"xiaofan_test_index","_type":"_doc","_id":"1","_version":1,"_seq_no":0,"_primary_term":1,"found":true,"_source":{"age":28,"name":"狂神说"}}
     */
    @Test
    public void testGetDocument() throws IOException {
        GetRequest request = new GetRequest(INDEX, "1");
        GetResponse response = client.get(request, RequestOptions.DEFAULT);
        System.out.println(response.getSourceAsString());
        System.out.println(response);
    }

    // 更新文档
    @Test
    public void testUpdateDocument() throws IOException {
        UpdateRequest request = new UpdateRequest(INDEX, "1");
        request.timeout("1s");

        User user = new User("qin", 25);
        request.doc(JSON.toJSONString(user), XContentType.JSON);

        UpdateResponse updateResponse = client.update(request, RequestOptions.DEFAULT);
        System.out.println(updateResponse);
    }

    // 删除文档
    @Test
    public void testDeleteDocument() throws IOException {
        DeleteRequest request = new DeleteRequest(INDEX, "1");
        request.timeout("1s");

        DeleteResponse deleteResponse = client.delete(request, RequestOptions.DEFAULT);
        System.out.println(deleteResponse);

    }

    // 批量插入数据（修改，删除类似操作）
    @Test
    public void testBulkRequest() throws IOException {
        BulkRequest request = new BulkRequest();
        request.timeout("10s");

        ArrayList<User> users = new ArrayList<>();
        users.add(new User("kenshine1", 21));
        users.add(new User("kenshine2", 22));
        users.add(new User("kenshine3", 23));
        users.add(new User("qin1", 18));
        users.add(new User("qin2", 19));

        // 批处理请求， 修改，删除，只要在这里修改相应的请求就可以
        for (int i = 0; i < users.size(); i++) {
            request.add(new IndexRequest(INDEX)
                    .id(String.valueOf(i + 1))
                    .source(JSON.toJSONString(users.get(i)), XContentType.JSON));
        }

        BulkResponse bulkResponse = client.bulk(request, RequestOptions.DEFAULT);
        //是否失败，返回false表示成功
        System.out.println(bulkResponse.hasFailures());
    }

    // 查询文档
    @Test
    public void testSearch() throws IOException {
        SearchRequest searchRequest = new SearchRequest(INDEX);
        // 构建搜索条件
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

        // 查询条件， 可以使用QueryBuilders工具类实现
        // QueryBuilders.termQuery 精确
        // QueryBuilders.matchLLQuery() 匹配所有
        TermQueryBuilder termQueryBuilder = QueryBuilders.termQuery("name", "kenshine1");
        // MatchAllQueryBuilder matchAllQueryBuilder = QueryBuilders.matchAllQuery();
        sourceBuilder.query(termQueryBuilder);
        sourceBuilder.timeout(new TimeValue(60, TimeUnit.SECONDS));

        searchRequest.source(sourceBuilder);

        SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
        System.out.println(JSON.toJSON(searchResponse.getHits()));
        System.out.println("======================================");
        for (SearchHit documentFields : searchResponse.getHits().getHits()) {
            System.out.println(documentFields.getSourceAsMap());
        }
    }

}
