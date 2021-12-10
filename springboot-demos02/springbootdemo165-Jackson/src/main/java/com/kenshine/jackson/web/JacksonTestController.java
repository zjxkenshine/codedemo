package com.kenshine.jackson.web;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenshine.jackson.pojo.User;
import com.kenshine.jackson.pojo.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/10 8:34
 * @description：测试Jackson
 * @modified By：
 * @version: $
 */
@RestController
public class JacksonTestController {

    @Autowired
    private ObjectMapper mapper;

    /**
     * readValue 反序列化
     */
    @GetMapping("/readValue")
    public String readValue() throws IOException {
        String json = "{\"name\":\"kenshine\",\"id\":1}";
        User user = mapper.readValue(json, User.class);
        return "name:"+user.getName()+",id:"+user.getId();
    }

    /**
     * writeValueAsString 序列化
     */
    @GetMapping("/writeValueAsString")
    public String writeValueAsString() throws IOException{
        User user = new User();
        user.setName("kenshine");
        user.setId((long) 2);
        return mapper.writeValueAsString(user);
    }

    /**
     * json转集合
     */
    @GetMapping("/json2Collection")
    public void json2Collection() throws JsonProcessingException {
        User user = new User();
        user.setId(3L);
        user.setName("ZAX");

        User user1 = new User();
        user.setId(4L);
        user.setName("QIN");

        // 序列化,得到对象集合的json字符串
        String json = mapper.writeValueAsString(Arrays.asList(user, user1));

        // 反序列化，接收两个参数：json数据，反序列化的目标类字节码
        List<User> users = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, User.class));
        for (User u : users) {
            System.out.println("u = " + u);
        }
    }

    /**
     * TypeReference：json转任意复杂类型
     */
    @GetMapping("/typeReference")
    public void typeReference() throws JsonProcessingException {
        User user = new User();
        user.setId(5L);
        user.setName("kenshine");

        // 序列化,得到对象集合的json字符串
        String json = mapper.writeValueAsString(Arrays.asList(user, user, user));

        // 反序列化，接收两个参数：json数据，反序列化的目标类字节码
        List<User> users = mapper.readValue(json, new TypeReference<List<User>>(){});
        for (User u : users) {
            System.out.println("u = " + u);
        }
    }


    /**
     * JsonView序列化分组 IdView
     */
    @JsonView(UserView.IdView.class)
    @RequestMapping("/idViewGroup")
    public UserView idViewGroup(){
        UserView userView = new UserView();
        userView.setId(1);
        userView.setName("kenshine");
        userView.setDate(LocalDateTime.now());
        userView.setDate2(LocalDateTime.now());
        userView.setAge(25);
        userView.setSex("男");
        return userView;
    }

    /**
     * JsonView序列化分组 IdNameView
     */
    @JsonView(UserView.IdNameView.class)
    @RequestMapping("/idNameViewGroup")
    public UserView idNameViewGroup(){
        UserView userView = new UserView();
        userView.setId(1);
        userView.setName("kenshine");
        userView.setDate(LocalDateTime.now());
        userView.setDate2(LocalDateTime.now());
        userView.setAge(25);
        userView.setSex("男");
        return userView;
    }




}
