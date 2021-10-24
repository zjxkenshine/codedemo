package com.kenshine.mapper;

import com.kenshine.pojo.User;
import com.kenshine.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Test
    public void test02(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();

        //方式二：不推荐
        List<User> users=sqlSession.selectList("com.kenshine.mapper.UserMapper.getUserList");
        System.out.println(users);

        //关闭sqlSession
        sqlSession.close();

    }

    @Test
    public void getUserByIdTest(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        User user=mapper.getUserById(1);
        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserById2Test(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map=new HashMap<>();
        map.put("userId",1);
        User user=mapper.getUserById2(map);
        System.out.println(user);

        //关闭sqlSession
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void addUserTest(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        int result=mapper.addUser(new User(4,"dog","111111"));
        System.out.println(result);

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void addUser2Test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("userId",5);
        map.put("userName","bin");
        map.put("userPwd","123456");
        mapper.addUser2(map);

        sqlSession.commit();
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void updateUserTest(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        int result=mapper.updateUser(new User(4,"pig","123123"));
        System.out.println(result);

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

    //增删改需要提交事务
    @Test
    public void deleteUserTest(){
        //第一步：获得sqlSession对象
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        int result=mapper.deleteUser(4);
        System.out.println(result);

        //提交事务
        sqlSession.commit();

        //关闭sqlSession
        sqlSession.close();
    }

    @Test
    public void getUserLikeTest(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        List<User> users=mapper.getUserLike("%k%");
        System.out.println(users);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void getUserLike2Test(){
        SqlSession sqlSession= MybatisUtils.getSqlSession();
        UserMapper mapper=sqlSession.getMapper(UserMapper.class);

        List<User> users=mapper.getUserLike2("k");
        System.out.println(users);

        sqlSession.commit();
        sqlSession.close();
    }





}
