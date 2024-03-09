package com.kenshine.yap4j;

import com.kenshine.yap4j.model.User;
import com.kenshine.yap4j.model.User2;
import com.polymathiccoder.yap4j.csv.CsvParser;
import com.polymathiccoder.yap4j.csv.CsvParserFactory;
import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname Yap4jTest
 * @Description Yap4j使用测试
 * @Date 2024-03-09 9:53
 * @modified By：
 * @version: 1.0$
 */
public class Yap4jTest {

    /**
     * 带表头CSV解析
     */
    @Test
    public void tet01(){
        CsvParser csvParser=CsvParserFactory.createParser(User.class);
        List<User> userList=csvParser.deserialize();
        System.out.println(userList);
    }

    /**
     * 不带表头解析
     */
    @Test
    public void tet02(){
        CsvParser csvParser=CsvParserFactory.createParser(User2.class);
        List<User2> userList=csvParser.deserialize();
        System.out.println(userList);
    }
}
