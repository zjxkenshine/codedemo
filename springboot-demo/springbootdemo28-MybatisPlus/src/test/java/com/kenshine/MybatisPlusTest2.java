package com.kenshine;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kenshine.domain.User;
import com.kenshine.mapper.UserMapper;
import com.kenshine.query.UserQuery;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 13:48
 * @description：mybatisplus测试2
 * @modified By：
 * @version: $
 *
 * 分页查询测试
 * 多条件查询测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MpApp.class)
public class MybatisPlusTest2 {
    @Resource
    private UserMapper userMapper;
    private static Logger logger = LoggerFactory.getLogger(MybatisPlusTest2.class);

    /**
     * 分页查询测试1，queryWrapper为null，查询所有记录并分页
     * 使用方法 <E extends IPage<T>> E selectPage(E page, @Param("ew") Wrapper<T> queryWrapper)
     */
    @Test
    public void selectPageTest1() {
        // 参数1：当前页，默认为1，小于1则按1处理，参数2：每页记录数，默认为10
        Page<User> page = new Page<>(3, 3);
        Page<User> userPage = userMapper.selectPage(page, null);
        logger.info("查询到的记录总数：" + userPage.getTotal());
        logger.info("总页数：" + userPage.getPages());
        // 取出分页数据
        List<User> users = userPage.getRecords();
        users.forEach(user -> logger.info(user.toString()));
        System.out.println(userPage);
    }


    /**
     * 分页查询测试2，根据条件查询全部记录并分页
     * 使用方法 <E extends IPage<T>> E selectPage(E page, @Param("ew") Wrapper<T> queryWrapper)
     */
    @Test
    public void selectPageTest2() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // WHERE (gender = ? AND age >= ?)
        queryWrapper.eq("gender", "男").ge("age", 25);
        // 参数1：当前页，默认为1，小于1则按1处理，参数2：每页记录数，默认为10
        Page<User> page = new Page<>(1, 2);
        Page<User> userPage = userMapper.selectPage(page, queryWrapper);
        logger.info("查询到的记录总数：" + userPage.getTotal());
        logger.info("总页数：" + userPage.getPages());
        // 取出分页数据
        List<User> users = userPage.getRecords();
        users.forEach(user -> logger.info(user.toString()));
    }


    /**
     * 条件构造器测试1
     * allEq(boolean condition, Map<R, V> params, boolean null2IsNull)：全部eq，或个别isNull
     * 参数说明：
     * condition：表示该条件是否加入最后生成的sql中，true表示加入，false表示不加入
     * params：key为数据库字段名，value为字段值
     * null2IsNull：为true则在map的value为null时调用isNull方法，为false时则忽略value为null的
     */
    @Test
    public void selectByWrapperTest1() {
        // 手动模拟查询条件
        UserQuery userQuery = new UserQuery().setGenderQuery("男").setAgeQuery(25);
        // userQuery为null会查询所有记录
        if (userQuery != null) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            HashMap<String, Object> map = new HashMap<>();
            map.put("gender", userQuery.getGenderQuery());
            map.put("age", userQuery.getAgeQuery());
            map.put("birthday", null);
            // gender不为null或空，age不为null，WHERE (gender = ? AND age = ?)
            // gender不为null或空，age为null，WHERE (gender = ?)
            // gender为null或空，age不为null，WHERE (age = ?)
            // gender为null或空，age为null，没有条件
            queryWrapper.allEq(
                    !StringUtils.isNullOrEmpty(userQuery.getGenderQuery()) || userQuery.getAgeQuery() != null, map, false);
            List<User> users = userMapper.selectList(queryWrapper);
            users.forEach(user -> logger.info(user.toString()));
        } else {
            List<User> users = userMapper.selectList(null);
            users.forEach(user -> logger.info(user.toString()));
        }
    }

    /**
     * 条件构造器测试2
     * ne(boolean condition, R column, Object val)：不等于 <>
     * gt(boolean condition, R column, Object val)：大于 >
     * le(boolean condition, R column, Object val)：小于等于 <=
     * in(boolean condition, R column, Collection<?> coll)：字段 IN (value.get(0), value.get(1), ...)
     * 多个条件默认使用and连接
     */
    @Test
    public void selectByWrapperTest2() {
        // 手动模拟查询条件
        Long[] array = {1L, 5L, 7L, 9L};
        UserQuery userQuery = new UserQuery().setRealnameQuery("张飞").setMinAgeQuery(20).setMaxUserPointQuery(5000)
                .setIdsQuery(Arrays.stream(array).collect(Collectors.toList()));
        if (userQuery != null) {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            // 只有userQuery.getRealnameQuery()不为null或空才会拼接realname <> ?
            queryWrapper
                    .ne(!StringUtils.isNullOrEmpty(userQuery.getRealnameQuery()), "realname", userQuery.getRealnameQuery())
                    // 只有userQuery.getMinAgeQuery()不为null才会拼接age > ?
                    .gt(userQuery.getMinAgeQuery() != null, "age", userQuery.getMinAgeQuery())
                    // 只有userQuery.getMaxUserPointQuery()不为null才会拼接user_point <= ?
                    .le(userQuery.getMaxUserPointQuery() != null, "user_point", userQuery.getMaxUserPointQuery())
                    // 只有userQuery.getIdsQuery()不为null或空才会拼接id IN (?,?,?,?)
                    .in(userQuery.getIdsQuery() != null && !userQuery.getIdsQuery().isEmpty(), "id",
                            userQuery.getIdsQuery());
            List<User> users = userMapper.selectList(queryWrapper);
            users.forEach(user -> logger.info(user.toString()));
        } else {
            List<User> users = userMapper.selectList(null);
            users.forEach(user -> logger.info(user.toString()));
        }
    }


    /**
     * 条件构造器测试3
     * between(boolean condition, R column, Object val1, Object val2)：BETWEEN 值1 AND 值2
     * notBetween(boolean condition, R column, Object val1, Object val2)：NOT BETWEEN 值1 AND 值2
     * notInSql(R column, String inValue)：字段 NOT IN ( sql语句 )
     * 多个条件默认使用and连接，Lambda方式构造条件
     */
    @Test
    public void selectByWrapperTest3() {
        // 手动模拟查询条件
        UserQuery userQuery =
                new UserQuery().setMinAgeQuery(20).setMaxAgeQuery(30).setMinUserPointQuery(2000).setMaxUserPointQuery(5000);
        if (userQuery != null) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            // 只有userQuery.getMinAgeQuery()不为null且userQuery.getMaxAgeQuery()不为null才会拼接age BETWEEN ? AND ?
            queryWrapper
                    .between(userQuery.getMinAgeQuery() != null && userQuery.getMaxAgeQuery() != null, User::getAge,
                            userQuery.getMinAgeQuery(), userQuery.getMaxAgeQuery())
                    // 只有userQuery.getMinUserPointQuery()不为null且userQuery.getMaxUserPointQuery()不为null才会拼接
                    // user_point NOT BETWEEN ? AND ?
                    .notBetween(userQuery.getMinUserPointQuery() != null && userQuery.getMaxUserPointQuery() != null,
                            User::getUserPoint, userQuery.getMinUserPointQuery(), userQuery.getMaxUserPointQuery())
                    // id NOT IN (select id from user where user_level in (1,3))
                    .notInSql(User::getId, "select id from user where user_level in (1,3)");
            List<User> users = userMapper.selectList(queryWrapper);
            users.forEach(user -> logger.info(user.toString()));
        } else {
            List<User> users = userMapper.selectList(null);
            users.forEach(user -> logger.info(user.toString()));
        }
    }

    /**
     * 条件构造器测试4 模糊查询
     * like(boolean condition, R column, Object val)：LIKE '%值%'
     * notLike(boolean condition, R column, Object val)：NOT LIKE '%值%'
     * likeLeft(boolean condition, R column, Object val)：LIKE '%值'
     * likeRight(boolean condition, R column, Object val)：LIKE '值%'
     * 多个条件默认使用and连接，Lambda方式构造条件
     */
    @Test
    public void selectByWrapperTest4() {
        // 手动模拟查询条件
        UserQuery userQuery =
                new UserQuery().setUsernameQuery("ao").setPasswordQuery("so").setRealnameQuery("乔").setEmailQuery("xi");
        if (userQuery != null) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            // 只有userQuery.getUsernameQuery()不为null或空才会拼接username LIKE ?，Parameters：%val%
            queryWrapper
                    .like(!StringUtils.isNullOrEmpty(userQuery.getUsernameQuery()), User::getUsername,
                            userQuery.getUsernameQuery())
                    // 只有userQuery.getPasswordQuery()不为null或空才会拼接password NOT LIKE ?，Parameters：%val%
                    .notLike(!StringUtils.isNullOrEmpty(userQuery.getPasswordQuery()), User::getPassword,
                            userQuery.getPasswordQuery())
                    // 只有userQuery.getRealnameQuery()不为null或空才会拼接realname LIKE ?，Parameters：%val
                    .likeLeft(!StringUtils.isNullOrEmpty(userQuery.getRealnameQuery()), User::getRealname,
                            userQuery.getRealnameQuery())
                    // 只有userQuery.getEmailQuery()不为null或空才会拼接email LIKE ?，Parameters：val%
                    .likeRight(!StringUtils.isNullOrEmpty(userQuery.getEmailQuery()), User::getEmail,
                            userQuery.getEmailQuery());
            List<User> users = userMapper.selectList(queryWrapper);
            users.forEach(user -> logger.info(user.toString()));
        } else {
            List<User> users = userMapper.selectList(null);
            users.forEach(user -> logger.info(user.toString()));
        }
    }


    /**
     * 条件构造器测试5 多条件连接
     * ge(boolean condition, R column, Object val)：大于等于 >=
     * lt(boolean condition, R column, Object val)：小于 <
     * eq(boolean condition, R column, Object val)：等于 =
     * or()：拼接 OR
     * or(boolean condition, Consumer<Children> consumer)：OR 嵌套
     * 主动调用or表示紧接着下一个方法不是用and连接，不调用or则默认为使用and连接
     * Lambda方式构造条件
     */
    @Test
    public void selectByWrapperTest5() {
        // 手动模拟查询条件
        Byte[] bytes = {2, 3, 5, 6};
        List<Byte> user_levels = Arrays.stream(bytes).collect(Collectors.toList());
        UserQuery userQuery = new UserQuery().setMinUserPointQuery(5000).setMaxAgeQuery(20)
                .setUserLevelsQuery(user_levels).setGenderQuery("男");
        if (userQuery != null) {
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            // 只有userQuery.getMinUserPointQuery()不为null才会拼接user_point >= ?
            queryWrapper
                    .ge(userQuery.getMinUserPointQuery() != null, User::getUserPoint, userQuery.getMinUserPointQuery())
                    // OR
                    .or()
                    // 只有userQuery.getMaxAgeQuery()不为null才会拼接age < ?
                    .lt(userQuery.getMaxAgeQuery() != null, User::getAge, userQuery.getMaxAgeQuery())
                    // 只有userQuery.getUserLevelsQuery()不为null或空才会拼接OR (user_level NOT IN (?,?,?,?))
                    // 同时只有userQuery.getGenderQuery()不为null或空才会拼接OR (user_level NOT IN (?,?,?,?) AND gender = ?)
                    .or(userQuery.getUserLevelsQuery() != null && !userQuery.getUserLevelsQuery().isEmpty(),
                            i -> i.notIn(User::getUserLevel, userQuery.getUserLevelsQuery()).eq(
                                    !StringUtils.isNullOrEmpty(userQuery.getGenderQuery()), User::getGender,
                                    userQuery.getGenderQuery()));
            List<User> users = userMapper.selectList(queryWrapper);
            users.forEach(user -> logger.info(user.toString()));
        } else {
            List<User> users = userMapper.selectList(null);
            users.forEach(user -> logger.info(user.toString()));
        }
    }


    /**
     * 条件构造器测试6 排序
     * orderByAsc(R column)：ORDER BY 字段, ... ASC
     * orderByDesc(R column)：ORDER BY 字段, ... DESC
     * orderBy(boolean condition, boolean isAsc, R... columns)：ORDER BY 字段, ...
     * 部分参数说明：
     * isAsc：是否升序排序，true表示是，false表示否
     * Lambda方式构造条件
     */
    @Test
    public void selectByWrapperTest6() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//    // ORDER BY age ASC
//    queryWrapper.orderByAsc(User::getAge);
//    // ORDER BY user_point DESC
//    queryWrapper.orderByDesc(User::getUserPoint);
        // ORDER BY birthday ASC
        queryWrapper.orderBy(true, true, User::getBirthday);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> logger.info(user.toString()));
    }


    /**
     * 条件构造器测试7 指定某些字段
     * select(String... columns)：设置查询字段
     * select(SFunction<T, ?>... columns)：Lambda方式设置查询字段
     */
    @Test
    public void selectByWrapperTest7() {
//    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//    queryWrapper.select("id", "realname", "age").in(true, "id", 1L, 3L, 5L);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        // SELECT id,realname,age FROM user WHERE (id IN (?,?,?))
        queryWrapper.select(User::getId, User::getRealname, User::getAge).in(true, User::getId, 2L, 4L, 6L);
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(map -> logger.info(map.toString()));
    }


    /**
     * 条件构造器测试9  分组和过滤
     * groupBy(R column)：GROUP BY 字段, ...
     * having(boolean condition, String sqlHaving, Object... params)：HAVING ( sql语句 )
     */
    @Test
    public void selectByWrapperTest9() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // SELECT user_level,GROUP_CONCAT(realname) AS realname_concat,COUNT(*) AS count,SUM(user_point) AS
        // point_sum,MAX(age) AS max_age FROM user GROUP BY user_level HAVING point_sum < 5000 OR max_age > 30
        queryWrapper
                .select("user_level", "GROUP_CONCAT(realname) AS realname_concat", "COUNT(*) AS count",
                        "SUM(user_point) AS point_sum", "MAX(age) AS max_age")
                .groupBy("user_level").having(true, "point_sum < 5000 OR max_age > 30");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(map -> logger.info(map.toString()));
    }

    /**
     * 10.and的使用  表示一对小括号
     */
    @Test
    public void test_And() {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        // SELECT username,password,realname FROM user WHERE (age > 28 and user_point > 5000) or age <25
        lqw.select(User::getUsername, User::getPassword,User::getRealname)
                .and(qw->qw.gt(User::getAge, 28).gt(User::getUserPoint,5000))
                .lt(User::getAge,25);
        // 只返回第一个字段username
        List<Object> objects = userMapper.selectObjs(lqw);
        objects.forEach(object -> logger.info(object.toString()));
    }










}
