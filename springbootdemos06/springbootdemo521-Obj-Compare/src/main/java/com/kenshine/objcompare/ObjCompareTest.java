package com.kenshine.objcompare;

import com.kenshine.objcompare.annotation.Snapshoted;
import com.kenshine.objcompare.model.Item;
import com.kenshine.objcompare.model.RecycleUser;
import com.kenshine.objcompare.model.User;
import org.junit.Test;
import org.smartboot.compare.*;
import org.smartboot.compare.constants.Kind;
import org.smartboot.compare.diff.NotEqualsDifference;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname ObjCompareTest
 * @Description 使用测试
 * @Date 2023-12-01 18:39
 * @modified By：
 * @version: 1.0$
 */
public class ObjCompareTest {

    /**
     * 比较对象是否相等
     */
    @Test
    public void test01(){
        User expect = new User();
        expect.setId("1");
        expect.setPassword("111212");
        expect.setUsername("Tom");
        expect.setSex("male");

        User target = new User();
        target.setId("2");
        target.setPassword("1112112");
        target.setUsername("Jerry");
        target.setSex("male");

        CompareResult result = CompareObjectUtils.compare(expect, target);
        System.out.println(result.toString());
        System.out.println(result.isSame());
    }

    /**
     * 支持对象属性中的List、Set、Map类型比较，同时也支持直接List、Set、Map比较
     */
    @Test
    public void test02() {
        List<Integer> userIds = new ArrayList<>(8);
        userIds.add(1);
        userIds.add(2);
        userIds.add(3);

        List<Integer> comparedIds = new ArrayList<>(8);
        comparedIds.add(1);
        comparedIds.add(2);
        comparedIds.add(4);

        CompareResult result = CompareObjectUtils.compare(userIds, comparedIds);
        System.out.println(result.toString());
        System.out.println(result.isSame());
    }

    /**
     *支持自定义字段过滤比较，支持以下几种模式
     *
     * 支持自定义属性名称与类型
     * 支持自定义属性正则表达式
     * 支持自定义属性过滤器
     *
     * 使用lombok @Data无效
     */
    @Test
    public void test03(){
        User expect = new User();
        expect.setId("1");
        expect.setPassword("111212");
        expect.setUsername("278821");
        expect.setSex("male");

        User target = new User();
        target.setId("2");
        target.setPassword("1112112");
        target.setUsername("278821");
        target.setSex("male");

        List<IgnoreField> ignoreFields = new ArrayList<>();
        // 忽略类型为String.class 字段名为id的 属性比较
        ignoreFields.add(new IgnoreField("id", String.class));

        // 忽略任何以word结尾的属性，类型为任意类型
        IgnorePatternField ignorePatternField = new IgnorePatternField("[\\s\\d]*word");
        ignoreFields.add(ignorePatternField);

        CompareResult result = CompareObjectUtils.compare(expect, target, ignoreFields);
        System.out.println(result.getSkipFields());
        System.out.println(result);
    }

    /**
     *自定义属性过滤器
     * 跳过未被@Snapshoted注解修饰的属性比较
     */
    @Test
    public void test04(){
        /* load from database */
        Item expect = new Item();
        expect.setId(1L);
        expect.setName("无常大米");
        expect.setUrl("https://www.baidu.com/1.jpg");
        expect.setStock(10);

        /* modified with snapshoted */
        Item actual = new Item();
        actual.setId(1L);
        actual.setName("无常大米2");
        actual.setUrl("https://www.baidu.com/1.jpg");
        actual.setStock(10);

        /* Register global field filter : filter field not contains @Snapshoted */
        FieldFilters.registerGlobal((f, context) -> f.getType() == Kind.FIELD && f.getField().getAnnotation(Snapshoted.class) == null);

        CompareResult result = CompareObjectUtils.compare(expect, actual);

        if (!result.isSame()) {
            System.out.println(result);
        }

        /* modified without snapshoted */
        actual.setName("无常大米");
        actual.setStock(10);

        System.out.println("================================");

        result = CompareObjectUtils.compare(expect, actual);
        System.out.println(result.isSame());
    }

    /**
     * 自定义属性比较
     */
    @Test
    public void test05(){
        // TagNamedTypeCompare和AttributesNamedTypeCompare已经内置，默认使用,分隔tag, 使用;分隔attribute，如果有需求，可以进行覆盖
        CompareFactory.addCompare(new NamedType("tag", String.class), new TagNamedTypeComparer("tag", String.class));
        CompareFactory.addCompare(new NamedType("tags", String.class), new TagNamedTypeComparer("tags", String.class));
        CompareFactory.addCompare(new NamedType("attribute", String.class), new TagNamedTypeComparer("attribute", String.class));

        User user = new User();
        user.setTag("123,456,789,987,555");
        user.setAttribute("fee:100;timestamp:123456;is_service:1;");

        User user2 = new User();
        user2.setTag("123,456,789,987,321");
        user2.setAttribute("fee:100;timestamp:1234567;is_service:2;style:B");

        CompareResult result = CompareObjectUtils.compare(user, user2);
        System.out.println(result);
    }

    /**
     * 循环依赖检测
     */
    @Test
    public void test06(){
        RecycleUser user = new RecycleUser();
        RecycleUser _user = new RecycleUser();

        user.setName("qinluo");
        user.setPassword("haolo2");
        user.setUser(_user);


        _user.setName("qinluo");
        _user.setPassword("haolo1");
        _user.setUser(user);

        CompareResult result = CompareObjectUtils.compare(user, _user);
        System.out.println(result);
    }

    /**
     * 严格/宽松模式
     *
     * 宽松模式下：
     * 如果是List、Map、Set类型，只比较数据本身的差异，size == 0与null视为相等
     * String类型，值blank与null视为相等
     * Boolean类型，值null视为false
     * String类型的判断也会影响到内置的tag和attribute比较行为
     */
    @Test
    public void test07(){
        List<String> names = new ArrayList<>(100);
        names.add("tom");
        names.add("Jerry");
        names.add(null);

        List<String> linkedNames = new LinkedList<>();
        linkedNames.add("tom");
        linkedNames.add("Jerry");
        linkedNames.add("");

        // 默认宽松模式
        CompareResult result = CompareObjectUtils.compare(names, linkedNames, true);
        System.out.println(result);
        System.out.println("===================================\n");
        result = CompareObjectUtils.compare(names, linkedNames);
        System.out.println(result);
    }

    /**
     * 自定义类型比较器
     * BigDecimal类比较器
     */
    @Test
    public void test08(){
        CompareFactory.addCompare(BigDecimal.class, new AbstractComparer<BigDecimal>() {
            @Override
            public void compare(BigDecimal expect, BigDecimal actual, CompareContext<BigDecimal> context) {
                expect = (expect != null) ? expect : BigDecimal.ZERO;
                actual = (actual != null) ? actual : BigDecimal.ZERO;
                if (!(expect.compareTo(actual) != 0)) {
                    context.addDiff(new NotEqualsDifference(context.getPath(), expect, actual));
                }
            }
        });
    }

    /**
     * 自定义数组类型比较
     */
    @Test
    public void test09(){
        CompareFactory.addCompare(int[].class, new AbstractComparer<int[]>() {
            @Override
            public void compare(int[] expect, int[] actual, CompareContext<int[]> context) {
                if (Arrays.equals(expect, actual)) {
                    context.addDiff(new NotEqualsDifference(context.getPath(), expect, actual));
                }
            }
        });
    }

    /**
     * 自定义 equals
     * 默认情况下，如果比较的POJO对象定义了equals方法，默认会调用该方法进行比较
     */
    @Test
    public void test10(){
        User expect = new User();
        expect.setId("1");
        expect.setPassword("111212");
        expect.setUsername("Tom");
        expect.setSex("male");

        User actual = new User();
        actual.setId("2");
        actual.setPassword("1112112");
        actual.setUsername("Jerry");
        actual.setSex("male");

        CompareContext<Object> compare = new CompareContext<>();
        compare.setType(Object.class);
        compare.setExpect(expect);
        compare.setActual(actual);
        // 禁用equals
        compare.setDisableEquals(true);
        CompareFactory.getCompare(Object.class).compare(compare);
        System.out.println(compare.getResult());
    }

}
