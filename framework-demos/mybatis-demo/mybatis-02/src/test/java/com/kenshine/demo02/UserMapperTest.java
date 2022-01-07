package com.kenshine.demo02;

import com.kenshine.demo02.mapper.UserMapper;
import com.kenshine.demo02.pojo.User;
import com.kenshine.demo02.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author kenshine
 * @create 2020-10-30 16:03
 **/
public class UserMapperTest {

    @Test
    public void test01(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();

        //执行,方式一：getMapper
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);
        List<User> users= mapper.getUserList();
        System.out.println(users);

        //方式二：不推荐
        //sqlSession.selectList("com.kenshine.mapper.UserMapper.getUserList");

        //关闭sqlSession
        sqlSession.close();
    }
}
