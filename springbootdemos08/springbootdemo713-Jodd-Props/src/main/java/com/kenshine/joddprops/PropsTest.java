package com.kenshine.joddprops;

import jodd.props.Props;
import jodd.props.PropsEntry;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @Classname PropsTest
 * @Description jodd-props使用示例
 * @Date 2024-02-28 11:34
 * @author by kenshine
 * @modified By：
 * @version: 1.0$
 */public class PropsTest{

    /**
     * 基本使用
     */
    @Test
     public void test01() throws IOException {
        Props p = new Props();
        p.load(new File("props\\test.props"));
        String story = p.getValue("story");
        System.out.println(story);
     }

    /**
     * 指定配置
     * 一次同时指定多个配置,会先试用第一个
     */
    @Test
     public void test02() throws IOException {
        Props p = new Props();
        p.load(new File("props\\db.props"));
        String url = p.getValue("db.url", "develop");
        String user = p.getValue("db.username", "develop");
        System.out.println(user);
        System.out.println(url);
     }

    /**
     * @profiles 默认配置
     */
    @Test
    public void test03() throws IOException {
        Props p = new Props();
        p.load(new File("props\\profile.props"));
        String value = p.getValue("key1");
        System.out.println(value);
     }

    /**
     * 列表读取
     */
    @Test
    public void test04() throws IOException {
        Props p = new Props();
        p.load(new File("props\\list.props"));
        Iterator<PropsEntry> it = p.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }


}
