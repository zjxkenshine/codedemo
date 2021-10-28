package com.kenshine;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/28 14:37
 * @description：Mybatis测试3
 * @modified By：
 * @version: $
 *
 * 其他操作
 * - 逻辑删除
 * - 自动填充
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MpApp.class)
public class MybatisPlusTest3 {
    @Resource
    private UserMapper userMapper;
    private static Logger logger = LoggerFactory.getLogger(MybatisPlusTest3.class);

    /**
     * 根据ID批量删除测试 测试逻辑删除
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
     * 逻辑删除后查询测试
     * 查询时会追加where条件过滤掉已删除数据且使用entity生成的where条件会忽略逻辑删除字段
     */
    @Test
    public void selectAfterLogicDeleteTest() {
        // SELECT id,username,password,realname,gender,age,email,user_point,user_level,birthday,deleted FROM user WHERE
        // gender=? AND age=? AND deleted=0
        QueryWrapper<User> queryWrapper = new QueryWrapper<>(new User().setGender("女").setAge(22).setDeleted(1));
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(user -> logger.info(user.toString()));
    }

    /**
     * 插入一条记录测试 自动填充测试
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
     * 乐观锁测试
     */
    @Test
    public void optimisticLockerTest() {
        User user = userMapper.selectById(11L);
        user.setPassword("123edf321").setAge(29);
        int result = userMapper.updateById(user);
        logger.info("result: " + result);
    }

}
