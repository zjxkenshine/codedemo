package com.kenshine;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.kenshine.domain.User;
import com.kenshine.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 10:28
 * @description：Mybatis测试1
 * @modified By：
 * @version: $
 *
 * 基本增删改查测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MpApp.class)
public class MybatisPlusTest1 {
    @Resource
    private UserMapper userMapper;
    private static Logger logger = LoggerFactory.getLogger(MybatisPlusTest1.class);

    /**
     * 查询所有记录测试
     */
    @Test
    public void selectAllTest() {
        List<User> users = userMapper.selectList(null);
        if (users.isEmpty()) {
            logger.info("不存在用户数据");
        } else {
            users.forEach(user -> logger.info(user.toString()));
        }
    }

    /**
     * 根据ID查询测试，通过Mapper中自定义方法查询
     */
    @Test
    public void testFindById() {
        User user = userMapper.findById(3L);
        logger.info(user.toString());
    }

    /**
     * 插入一条记录测试
     * 使用方法 int insert(T entity)
     */
    @Test
    public void insertTest() {
        User user = new User();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse("1993-10-16 20:36:10", dateTimeFormatter);
        user.setUsername("kong1ming").setPassword("mkg568er7k").setRealname("诸葛亮").setGender("男").setAge(27)
                .setEmail("kongming@xxx.com").setUserPoint(6000).setUserLevel(Byte.valueOf("5")).setBirthday(localDateTime);
        // 返回的result是受影响的行数，并不是自增后的ID
        int result = userMapper.insert(user);
        logger.info("result: " + result);
        // 自增后的ID会回填到对象中
        logger.info("新增加的一条记录的ID：" + user.getId());
    }

    /**
     * ============================================= 测试删除方法 ==============================================================
     */
    /**
     * 删除一条数据
     */
    @Test
    public void deleteByIdTest() {
        int result = userMapper.deleteById(11L);
        logger.info("result: " + result);
    }

    /**
     * 根据ID批量删除测试
     * 使用方法 int deleteBatchIds(@Param("coll") Collection<? extends Serializable> idList)
     */
    @Test
    public void deleteByIdsTest() {
        Long[] array = {1L, 3L, 9L};
        List<Long> ids = Arrays.stream(array).collect(Collectors.toList());
        int result = userMapper.deleteBatchIds(ids);
        logger.info("result: " + result);
    }

    /**
     * 根据entity条件删除测试
     * 使用方法 int delete(@Param("ew") Wrapper<T> queryWrapper)
     */
    @Test
    public void deletedTest() {
        User user = new User().setGender("女").setAge(22);
        // WHERE gender=? AND age=?
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(user);
        int result = userMapper.delete(queryWrapper);
        logger.info("result: " + result);
    }

    /**
     * 删除所有测试，queryWrapper为null
     * 使用方法 int delete(@Param("ew") Wrapper<T> queryWrapper)
     */
    @Test
   public void deleteAllTest() {
        int result = userMapper.delete(null);
        logger.info("result: " + result);
    }

    /**
     * 根据columnMap条件删除测试
     * 使用方法 int deleteByMap(@Param("cm") Map<String, Object> columnMap)
     */
    @Test
    public void deletedByMapTest() {
        HashMap<String, Object> map = new HashMap<>();
        // WHERE user_level = ? AND user_point = ?
        map.put("user_level", Byte.valueOf("4"));
        map.put("user_point", 3000);
        int result = userMapper.deleteByMap(map);
        logger.info("result: " + result);
    }


    /**
     * 根据ID更新测试
     * 使用方法 int updateById(@Param("et") T entity)
     */
    @Test
    public void updateByIDTest() {
        User user = new User().setId(2L).setPassword("aa123bbd678").setUserPoint(1300).setUserLevel(Byte.valueOf("3"));
        int result = userMapper.updateById(user);
        logger.info("result: " + result);
    }


    /**
     * 根据whereWrapper条件更新测试1，使用entity进行set，queryWrapper构造条件
     * 使用方法 int update(@Param("et") T entity, @Param("ew") Wrapper<T> updateWrapper)
     */
    @Test
    public void updateByWrapperTest1() {
        // UPDATE user SET user_point=?, user_level=? WHERE (gender = ?)
        User user = new User().setUserPoint(3200).setUserLevel(Byte.valueOf("4")).setBirthday(null);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("gender", "男");
        int result = userMapper.update(user, queryWrapper);
        logger.info("result: " + result);
    }


    /**
     * 根据whereWrapper条件更新测试2，entity为null，使用updateWrapper构造条件并set
     * 使用方法 int update(@Param("et") T entity, @Param("ew") Wrapper<T> updateWrapper)
     */
    @Test
    public void updateByWrapperTest2() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        // UPDATE user SET user_point=?,user_level=?,birthday=? WHERE (gender = ?)
        updateWrapper.eq("gender", "女").set("user_point", 12000).set("user_level", Byte.valueOf("6")).set("birthday",
                null);
        int result = userMapper.update(null, updateWrapper);
        logger.info("result: " + result);
    }


    /**
     * =================================================== 查询 ===============================================================
     */
    /**
     * 根据ID查询测试
     * 使用方法 T selectById(Serializable id)
     */
    @Test
    public void selectByIdTest() {
        User user = userMapper.selectById(6L);
        logger.info(user.toString());
    }

    /**
     * 根据ID批量查询测试
     * 使用方法 List<T> selectBatchIds(@Param("coll") Collection<? extends Serializable> idList)
     */
    @Test
    public void selectByIdsTest() {
        Long[] array = {1L, 5L, 9L, 11L};
        List<Long> ids = Arrays.stream(array).collect(Collectors.toList());
        List<User> users = userMapper.selectBatchIds(ids);
        users.forEach(user -> logger.info(user.toString()));
    }

    /**
     * 根据条件查询一条记录测试
     * 使用方法 T selectOne(@Param("ew") Wrapper<T> queryWrapper)
     */
    @Test
    public void selectOneTest() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // WHERE (realname = ?)
        queryWrapper.eq("realname", "貂蝉");
//    queryWrapper.eq("gender", "女");
        User user = userMapper.selectOne(queryWrapper);
        logger.info(user.toString());
    }

    /**
     * 根据条件查询全部记录测试
     * 使用方法 List<T> selectList(@Param("ew") Wrapper<T> queryWrapper)
     */
    @Test
    public void selectListTest() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // SELECT realname,age,user_point,user_level FROM user WHERE (age BETWEEN ? AND ? OR user_point < ?)
        queryWrapper.select("realname", "age", "user_point", "user_level").between("age", 21, 24).or().lt("user_point",
                500);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> logger.info(user.toString()));
    }

    /**
     * 根据columnMap条件查询测试
     * 使用方法 List<T> selectByMap(@Param("cm") Map<String, Object> columnMap)
     */
    @Test
    public void selectByMapTest() {
        HashMap<String, Object> map = new HashMap<>();
        // WHERE gender = ? AND age = ?
        map.put("gender", "男");
        map.put("age", 25);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(user -> logger.info(user.toString()));
    }

    /**
     * 根据Wrapper条件查询全部记录测试
     * 使用方法 List<Map<String, Object>> selectMaps(@Param("ew") Wrapper<T> queryWrapper)
     */
    @Test
   public void selectMapsTest() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // SELECT realname,age,user_point,user_level FROM user WHERE (age BETWEEN ? AND ? OR user_point < ?)
        queryWrapper.select("realname", "age", "user_point", "user_level").between("age", 21, 24).or().lt("user_point",
                500);
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(map -> logger.info(map.toString()));
    }

    /**
     * 根据Wrapper条件查询全部记录测试，只返回第一个字段的值
     * 使用方法 List<Object> selectObjs(@Param("ew") Wrapper<T> queryWrapper)
     */
    @Test
    public void selectObjsTest() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // SELECT username,password,realname FROM user WHERE (age > ?)
        queryWrapper.select("username", "password", "realname").gt("age", 25);
        // 只返回第一个字段username
        List<Object> objects = userMapper.selectObjs(queryWrapper);
        objects.forEach(object -> logger.info(object.toString()));
    }

    /**
     * 根据Wrapper条件查询总记录数测试
     * 按用方法 Integer selectCount(@Param("ew") Wrapper<T> queryWrapper)
     */
    @Test
   public void selectCountTest() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // WHERE (user_point > ? AND age < ?)
        queryWrapper.gt("user_point", 1000).lt("age", 25);
        Integer count = userMapper.selectCount(queryWrapper);
        logger.info("count: " + count);
    }








}
