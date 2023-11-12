package com.kenshine.csv;

import com.github.houbb.csv.bs.CsvReadBs;
import com.github.houbb.csv.bs.CsvWriteBs;
import com.github.houbb.csv.support.reader.impl.CsvReaders;
import com.github.houbb.csv.support.writer.impl.CsvWriters;
import com.github.houbb.csv.util.CsvHelper;
import com.github.houbb.heaven.util.nio.PathUtil;
import com.kenshine.csv.model.*;
import org.junit.Test;

import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/12 21:13
 * @description： 读写测试
 * @modified By：
 * @version: $
 */
public class CsvTest {

    private List<User> buildCommonList() {
        User user = new User();
        short s = 4;
        byte b = 1;
        user.setAge(10)
                .setName("你好")
                .setId(1L)
                .setScore(60)
                .setCoin(b)
                .setLevel(s)
                .setMoney(200)
                .setSex(true)
                .setStatus('Y');
        return Arrays.asList(user);
    }

    /**
     * 基本读写
     */
    @Test
    public void test01(){
        final String path = PathUtil.getAppTestResourcesPath()+"/helper.csv";
        //写
        CsvHelper.write(buildCommonList(), CsvWriters.filePath(path));
        // 读
        List<User> userList = CsvHelper.read(path, User.class);
        System.out.println(userList);
    }


    /**
     * 构建基于注解的测试列表
     * @return 列表
     */
    private List<UserAnnotation> buildAnnotationList() {
        UserAnnotation user = new UserAnnotation();
        user.setName("你好")
                .setPassword("123")
                .setStatus("F")
                .setBirthday(new Date());
        return Arrays.asList(user);
    }
    /**
     * @CSV注解处理
     */
    @Test
    public void test02(){
        String path = PathUtil.getAppTestResourcesPath()+"/annotation.csv";
        // 引导类写入
        CsvWriteBs.newInstance().writer(CsvWriters.filePath(path)).write(buildAnnotationList());
        // 引导类读取
        List<UserAnnotation> userList = CsvReadBs.newInstance().reader(CsvReaders.filePath(path)).read(UserAnnotation.class);
        System.out.println(userList);
    }

    private List<UserCollection> buildCollectionList() {
        UserCollection user = new UserCollection();
        String[] arrays = new String[]{"a", "b", "c"};
        LinkedList<String> lists = new LinkedList<>(Arrays.asList(arrays));
        Map<String, String> maps = new HashMap<>();
        maps.put("key", "value");
        maps.put("key2", "value2");
        Set<String> sets = new HashSet<>();
        sets.add("set1");
        sets.add("set2");
        user.setLists(lists);
        user.setArrays(arrays);
        user.setMaps(maps);
        user.setSets(sets);
        return Arrays.asList(user);
    }

    /**
     * 集合支持
     */
    @Test
    public void test03(){
        String path = PathUtil.getAppTestResourcesPath()+"/collection.csv";
        // 引导类写入
        CsvWriteBs.newInstance().writer(CsvWriters.filePath(path)).write(buildCollectionList());
        // 引导类读取
        List<UserCollection> userList = CsvReadBs.newInstance().reader(CsvReaders.filePath(path)).read(UserCollection.class);
        System.out.println(userList);
    }

    private List<UserEntry> buildEntryList() {
        UserEntry userEntry = new UserEntry();
        userEntry.setName("test");
        userEntry.setUser(buildCommonList().get(0));
        return Collections.singletonList(userEntry);
    }

    /**
     * 内嵌对象
     */
    @Test
    public void test04(){
        String path = PathUtil.getAppTestResourcesPath()+"/entry.csv";
        // 引导类写入
        CsvWriteBs.newInstance().writer(CsvWriters.filePath(path)).write(buildEntryList());
        // 引导类读取
        List<UserEntry> userList = CsvReadBs.newInstance().reader(CsvReaders.filePath(path)).read(UserEntry.class);
        System.out.println(userList);
    }

    private List<UserEscape> buildUserEscapeList() {
        UserEscape escape = new UserEscape();
        Map<String, String> map = new HashMap<>();
        map.put("key=key", "value=value");
        User user = new User();
        user.setName("entry:name");

        escape.setName("one,one");
        escape.setNameList(Arrays.asList("one|one", "two|two"));
        escape.setMap(map);
        escape.setUser(user);
        return Collections.singletonList(escape);
    }

    /**
     * 特殊字符转义
     */
    @Test
    public void test05(){
        String path = PathUtil.getAppTestResourcesPath()+"/escape.csv";
        // 引导类写入
        CsvWriteBs.newInstance().writer(CsvWriters.filePath(path)).escape(true).write(buildUserEscapeList());
        // 引导类读取
        List<UserEscape> userList = CsvReadBs.newInstance().reader(CsvReaders.filePath(path)).escape(true).read(UserEscape.class);
        System.out.println(userList);
    }

}
