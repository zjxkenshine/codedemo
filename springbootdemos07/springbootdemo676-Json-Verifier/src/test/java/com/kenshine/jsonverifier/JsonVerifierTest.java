package com.kenshine.jsonverifier;

import io.github.yashchenkon.test.JsonContentVerifier;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author by kenshine
 * @Classname JsonVerifierTest
 * @Description JsonVerifier使用测试
 * @Date 2024-01-12 14:20
 * @modified By：
 * @version: 1.0$
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = JsonVerifierApp.class)
public class JsonVerifierTest {
    @Resource
    private MockMvc mockMvc;

    @Rule
    public JsonContentVerifier jsonContentVerifier = new JsonContentVerifier();

    @Test
    public void test01() throws Exception {
        String responseBody = mockMvc.perform(get("/users/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
        System.out.println("responseBody===============");
        System.out.println(responseBody);
        System.out.println("responseBody===============");
        // JSON文件地址：src/test/resources/json/JsonVerifierTest/test01/response.json
        jsonContentVerifier.assertJson(responseBody);
    }
}
