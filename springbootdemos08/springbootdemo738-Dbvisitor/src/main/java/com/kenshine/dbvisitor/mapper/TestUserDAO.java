package com.kenshine.dbvisitor.mapper;

import com.kenshine.dbvisitor.dto.TestUser;
import net.hasor.dbvisitor.dal.repository.Param;
import net.hasor.dbvisitor.dal.repository.RefMapper;
import net.hasor.dbvisitor.page.Page;
import net.hasor.dbvisitor.page.PageResult;

import java.util.List;

/**
 * @author kenshine
 * mapper文件管理sql
 */
@RefMapper("/mapper/quick_dao3/TestUserMapper.xml")
public interface TestUserDAO {
    int insertUser(@Param("name") String name, @Param("age") int age);

    int updateAge(@Param("id") int userId, @Param("age") int newAge);

    int deleteByAge(@Param("age") int age);

    List<TestUser> queryByAge(@Param("beginAge") int beginAge, @Param("endAge") int endAge);

    // 分页查询
    List<TestUser> queryByAge(
            @Param("beginAge") int beginAge,
            @Param("endAge") int endAge,
            Page pageInfo);

    // 也可以返回包含分页信息的分页结果
    PageResult<TestUser> queryByAge2(
            @Param("beginAge") int beginAge,
            @Param("endAge") int endAge,
            Page pageInfo);
}