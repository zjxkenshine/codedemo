package rest;

import com.kenshine.resttemplate.RestTemplateApp;
import com.kenshine.resttemplate.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/22 11:22
 * @description：测试RestTemplate Get请求
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestTemplateApp.class)
public class RestGetTest {
    @Autowired
    private RestTemplate restTemplate;

    /**
     * 查询字符串
     */
    @Test
    public void test01_getString(){
        String result = restTemplate.getForObject("http://localhost:8080/test/user/list", String.class);
        System.out.println(result);
    }

    /**
     * 查询列表
     */
    @Test
    public void test02_getList(){
        List<User> userList = restTemplate.getForObject("http://localhost:8080/test/user/list", List.class);
        System.out.println(userList);
    }

    /**
     * 传参，查询单个
     */
    @Test
    public void test03_getOne(){
        User user = restTemplate.getForObject("http://localhost:8080/test/user/{id}", User.class,"5");
        System.out.println(user);
    }




}
