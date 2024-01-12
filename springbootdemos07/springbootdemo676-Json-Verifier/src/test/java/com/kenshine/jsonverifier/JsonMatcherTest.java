package com.kenshine.jsonverifier;

import io.github.yashchenkon.test.JsonContentLoader;
import io.github.yashchenkon.test.matcher.JsonMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.annotation.Resource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author by kenshine
 * @Classname JsonMatcherTest
 * @Description 使用JSON matcher
 * @Date 2024-01-12 15:11
 * @modified By：
 * @version: 1.0$
 */
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(classes = JsonVerifierApp.class)
public class JsonMatcherTest {
    @Resource
    private MockMvc mockMvc;

    @Rule
    public JsonContentLoader jsonContentLoader = new JsonContentLoader();

    @Test
    public void test02() throws Exception {
        String responseBody = mockMvc.perform(get("/users/0").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse().getContentAsString();
        // src/test/resources/json/JsonMatcherTest/test02/response.json
        assertThat(responseBody, JsonMatcher.json(jsonContentLoader.load()));
    }

}
