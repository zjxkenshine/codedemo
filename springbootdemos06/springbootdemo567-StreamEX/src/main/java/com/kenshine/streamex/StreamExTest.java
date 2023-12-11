package com.kenshine.streamex;

import com.kenshine.streamex.model.Role;
import com.kenshine.streamex.model.User;
import one.util.streamex.DoubleStreamEx;
import one.util.streamex.EntryStream;
import one.util.streamex.IntStreamEx;
import one.util.streamex.StreamEx;
import org.junit.Test;

import java.util.*;
import java.util.function.BinaryOperator;

/**
 * @author by kenshine
 * @Classname StreamExTest
 * @Description StreamEx 使用测试
 * @Date 2023-12-11 13:04
 * @modified By：
 * @version: 1.0$
 */
public class StreamExTest {

    /**
     * StreamEx 快捷collect方法
     */
    @Test
    public void test01(){
        List<User> users = getUserList();
        List<String> userNames = StreamEx.of(users).map(User::getName).toList();
        Map<Role, List<User>> role2users = StreamEx.of(users).groupingBy(User::getRole);
        System.out.println(userNames);
        System.out.println(role2users);

        // "1; 2; 3"
        String result = StreamEx.of(1,2,3).joining("; ");
        System.out.println(result);
    }

    /**
     * 转换流
     */
    @Test
    public void test02(){
        List<User> users =getUserList();
        List<User> userList= IntStreamEx.range(getUserList().size())
                .mapToObj(users::get).select(User.class).toList();
        System.out.println(userList);
    }

    /**
     *  添加到流
     */
    @Test
    public void test03(){
        List<User> users =getUserList();
        List<String> strList =StreamEx.of(users).map(User::getName).prepend("(none)").toList();
        System.out.println(strList);
        // array添加
        int[] a=IntStreamEx.of(new int[]{1,2}).append(3).toArray();
        // boxed包装流
        System.out.println(IntStreamEx.of(a).boxed().toList());
    }

    /**
     * 删除不需要的元素并将流用作Iterable
     */
    @Test
    public void test04(){
        List<String> strings = Arrays.asList("kenshine","","pig","lin","");
        // 删除空数据
        for(String line : StreamEx.of(strings).remove(String::isEmpty)) {
            System.out.print(line);
            System.out.print(System.lineSeparator());
        }
    }

    /**
     * Map筛选
     */
    @Test
    public void test05(){
        Map<String, Boolean> roleMap = new HashMap<>();
        roleMap.put("kenshine",true);
        roleMap.put("hong",true);
        roleMap.put("qin",false);
        roleMap.put("lin",true);

        // 筛选enable为true的
        Set<String> set= StreamEx.ofKeys(roleMap,b->b).toSet();
        System.out.println(set);
    }

    /**
     * 在key-value对上操作
     */
    @Test
    public void test06(){
        Map<String, String> roleMap = new HashMap<>();
        roleMap.put("kenshine","a");
        roleMap.put("hong","a");
        roleMap.put("qin","b");
        roleMap.put("lin","a");
        // 值映射分组
        Map<String,List<String>> listMap= EntryStream.of(roleMap).flatMapValues(s -> StreamEx.of("a"+s)).invert().grouping();
        System.out.println(listMap);

        Map<String,String> map=EntryStream.of(roleMap).mapKeys(String::valueOf).mapValues(String::valueOf).toMap();
        System.out.println(map);
    }

    /**
     * Pairwise differences: 成对差异
     */
    @Test
    public void test07(){
        List<Double> doubles=DoubleStreamEx.of(1,10,3,14).pairMap((a, b) -> b-a).boxed().toList();
        System.out.println(doubles);
    }

    /**
     * 支持byte/char/short/float类型
     */
    @Test
    public void test08(){
        List<Integer> list=IntStreamEx.of(1,2,3,4).map(x -> x*2).boxed().toList();
        System.out.println(list);
    }

    /**
     * 递归定义自定义延迟中间操作
     */
    @Test
    public void test09(){
        // 从左到右遍历并相加
        List<String> strings=scanLeft(StreamEx.of("kenshine", "lin", "qin","hong"), new BinaryOperator<String>() {
            @Override
            public String apply(String s, String s2) {
                return s+s2;
            }
        }).toList();
        System.out.println(strings);
    }

    /**
     * 递归定义自定义延迟中间操作
     */
    private <T> StreamEx<T> scanLeft(StreamEx<T> input, BinaryOperator<T> operator) {
        return input.headTail((head, tail) -> scanLeft(tail.mapFirst(cur -> operator.apply(head, cur)), operator)
                .prepend(head));
    }

    public List<User> getUserList(){
       return Arrays.asList(
                new User().setName("kenshine").setRole(new Role().setName("admin")),
                new User().setName("hong").setRole(new Role().setName("user")),
                new User().setName("qin").setRole(new Role().setName("user"))
        );
    }


    public List<Role> getRoleList(){
        return Arrays.asList(
            new Role().setEnable(true).setName("admin"),
            new Role().setEnable(true).setName("user"),
            new Role().setEnable(true).setName("guest"),
            new Role().setEnable(false).setName("pig")
        );
    }

}
