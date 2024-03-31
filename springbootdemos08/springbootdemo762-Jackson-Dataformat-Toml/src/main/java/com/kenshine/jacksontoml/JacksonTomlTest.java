package com.kenshine.jacksontoml;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.toml.TomlMapper;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname JacksonTomlTest
 * @Description toml测试
 * @Date 2024-03-31 8:41
 * @modified By：
 * @version: 1.0$
 */
public class JacksonTomlTest {

    /**
     * TomlMapper序列化与反序列化
     */
    @Test
    public void test01() throws IOException {
        TomlMapper mapper = new TomlMapper();
        User user = new User(1, "kenshine", Arrays.asList("a","b"), new User(2, "qin", Arrays.asList("c","d"), null));
        String doc = mapper.writeValueAsString(user);
        mapper.writeValue(new File("toml\\test01.toml"), user);
        User user1 = mapper.readValue(doc, User.class);
        System.out.println(user1);
    }

    /**
     * writerFor/readerFor
     */
    @Test
    public void test02() throws IOException {
        TomlMapper mapper = new TomlMapper();
        User user = new User(1, "kenshine", Arrays.asList("a","b"), new User(2, "qin", Arrays.asList("c","d"), null));
        String props = mapper.writerFor(User.class)
                .writeValueAsString(user);
        mapper.writerFor(User.class)
                .writeValue(new File("toml\\test02.toml"), user);
        User result = mapper.readerFor(User.class)
                .readValue(props);
        System.out.println(result);
    }
}
