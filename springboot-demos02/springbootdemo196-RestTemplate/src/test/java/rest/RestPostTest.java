package rest;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.kenshine.resttemplate.RestTemplateApp;
import com.kenshine.resttemplate.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 11:28
 * @description：测试RestTemplate Post请求/update请求/delete请求
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestTemplateApp.class)
public class RestPostTest {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Post请求
     */
    @Test
    public void testPost() throws JSONException {
        // 设置请求类型
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name","kenshine");

        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,headers);
        String url = "http://localhost:8080/test/user";
        ResponseEntity<String> mapResponseEntity = restTemplate.postForEntity(url, httpEntity, String.class);
        System.out.println(mapResponseEntity.getBody());
    }


    /**
     * put请求
     */
    @Test
    public void testPut() throws JSONException {
        // 设置请求类型
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id","1");
        jsonObject.put("name","qin");

        // 封装参数和头信息
        HttpEntity<JSONObject> httpEntity = new HttpEntity(jsonObject,headers);
        String url = "http://localhost:8080/test/user";
        restTemplate.put(url, httpEntity);

        User user = restTemplate.getForObject("http://localhost:8080/test/user/{id}", User.class,"1");
        System.out.println(user);
    }


    /**
     * delete请求
     */
    @Test
    public void testDelete() throws JSONException {
        restTemplate.delete("http://localhost:8080/test/user/{id}","13");

        List<User> userList = restTemplate.getForObject("http://localhost:8080/test/user/list", List.class);
        System.out.println(userList);
    }


}
