package com.kenshine.dbvisitor;

import com.kenshine.dbvisitor.dto.TestUser;
import com.kenshine.dbvisitor.mapper.TestUserMapper;
import com.kenshine.dbvisitor.util.DsUtils;
import lombok.Data;
import net.hasor.dbvisitor.dal.mapper.BaseMapper;
import net.hasor.dbvisitor.dal.session.DalSession;
import net.hasor.dbvisitor.jdbc.core.JdbcTemplate;
import net.hasor.dbvisitor.lambda.LambdaTemplate;
import net.hasor.dbvisitor.page.Page;
import net.hasor.dbvisitor.page.PageObject;
import net.hasor.dbvisitor.page.PageResult;
import net.hasor.dbvisitor.transaction.Isolation;
import net.hasor.dbvisitor.transaction.Propagation;
import net.hasor.dbvisitor.transaction.TransactionManager;
import net.hasor.dbvisitor.transaction.TransactionStatus;
import net.hasor.dbvisitor.transaction.support.LocalTransactionManager;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname DbVisitorTest
 * @Description dbvisitor使用测试
 * @Date 2024-03-10 11:11
 * @modified By：
 * @version: 1.0$
 */
public class DbVisitorTest {

    /**
     * 查询
     */
    @Test
    public void test01() throws IOException, SQLException {
        // 创建数据源
        DataSource dataSource = DsUtils.dsMySql();
        // 创建 JdbcTemplate 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        // 加载测试数据脚本
        //jdbcTemplate.loadSQL("CreateDB.sql");
        // 查询数据并 Map 形式返回
        List<Map<String, Object>> mapList = jdbcTemplate.queryForList("select * from test_user");
        System.out.println(mapList);
    }

    /**
     * 读取到对象
     */
    @Test
    public void test02() throws SQLException {
        // 创建数据源
        DataSource dataSource = DsUtils.dsMySql();
        // 创建 JdbcTemplate 对象
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<TestUser> dtoList = jdbcTemplate.queryForList("select * from test_user", TestUser.class);
        System.out.println(dtoList);
    }

    /**
     * 单表CRUD
     */
    @Test
    public void test03() throws SQLException {
        // 创建数据源
        DataSource dataSource = DsUtils.dsMySql();

        // 创建 LambdaTemplate 对象和创建 JdbcTemplate 一样
        LambdaTemplate lambdaTemplate = new LambdaTemplate(dataSource);

        // 查询，所有数据
        List<TestUser> dtoList = lambdaTemplate.lambdaQuery(TestUser.class)
                .queryForList();
        System.out.println(dtoList);

        // 插入新数据
        TestUser newUser = new TestUser();
        newUser.setName("new User");
        newUser.setAge(33);
        newUser.setCreateTime(new Date());

        int result = lambdaTemplate.lambdaInsert(TestUser.class)
                .applyEntity(newUser)
                .executeSumResult();

        // 更新，将name 从 mali 更新为 mala
        TestUser sample = new TestUser();
        sample.setName("mala");

        int result1 = lambdaTemplate.lambdaUpdate(TestUser.class)
                .eq(TestUser::getId, 1)
                .updateToSample(sample)
                .doUpdate();

        // 删除，ID 为 2 的数据
        int result2 = lambdaTemplate.lambdaDelete(TestUser.class)
                .eq(TestUser::getId, 2)
                .doDelete();
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }

    /**
     * 通用Mapper
     */
    @Test
    public void test04() throws SQLException {
        // 创建数据源
        DataSource dataSource = DsUtils.dsMySql();

        // 创建通用 Mapper
        DalSession session = new DalSession(dataSource);
        BaseMapper<TestUser> baseMapper = session.createBaseMapper(TestUser.class);

        // 查询数据
        List<TestUser> dtoList = baseMapper.query().queryForList();
        System.out.println(dtoList);

        // 插入新数据
        TestUser newUser = new TestUser();
        newUser.setName("new User");
        newUser.setAge(33);
        newUser.setCreateTime(new Date());

        int result = baseMapper.insert(newUser);

        // 更新，将name 从 mali 更新为 mala
        TestUser sample = baseMapper.selectById(1);
        sample.setName("mala");

        int result1 = baseMapper.updateById(sample);

        // 删除，ID 为 2 的数据
        int result2 = baseMapper.deleteById(2);

        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
    }

    /**
     * 注解化Mapper
     */
    @Test
    public void test05() throws SQLException {
        DataSource dataSource = DsUtils.dsMySql();
        //创建 Session
        DalSession session = new DalSession(dataSource);
        // 创建 Mapper 接口
        TestUserMapper userMapper = session.createMapper(TestUserMapper.class);
        List<TestUser> userList=userMapper.queryByAge(10,20);
        System.out.println(userList);
    }

    /**
     * 分页查询
     */
    @Test
    public void test06() throws SQLException {
        DataSource dataSource = DsUtils.dsMySql();
        LambdaTemplate lambdaTemplate = new LambdaTemplate(dataSource);

        // 构建分页对象，每页 3 条数据(默认第一页的页码为 0)
        Page pageInfo = new PageObject();
        pageInfo.setPageSize(3);

        // 分页查询数据
        List<TestUser> pageData1 = lambdaTemplate.lambdaQuery(TestUser.class)
                .usePage(pageInfo)
                .queryForList();

        // 分页查询下一页数据
        pageInfo.nextPage();
        List<TestUser> pageData2 = lambdaTemplate.lambdaQuery(TestUser.class)
                .usePage(pageInfo)
                .queryForList();

        System.out.println(pageData1);
        System.out.println(pageData2);
    }

    /**
     * BaseMapper分页
     */
    @Test
    public void test07() throws SQLException {
        // 创建数据源
        DataSource dataSource = DsUtils.dsMySql();

        // 创建通用 Mapper
        DalSession session = new DalSession(dataSource);
        BaseMapper<TestUser> baseMapper = session.createBaseMapper(TestUser.class);

        // 构建分页对象，每页 3 条数据(默认第一页的页码为 0)
        Page pageInfo = new PageObject();
        pageInfo.setPageSize(3);

        // 分页查询数据
        PageResult<TestUser> pageData1 = baseMapper.pageBySample(null,pageInfo);
        System.out.println(pageData1.getData());

        // 分页查询下一页数据
        pageInfo.nextPage();
        PageResult<TestUser> pageData2 = baseMapper.pageBySample(null,pageInfo);
        System.out.println(pageData2.getData());
    }

    /**
     * 事务
     */
    @Test
    public void test08() throws SQLException {
        DataSource dataSource = DsUtils.dsMySql();
        TransactionManager manager = new LocalTransactionManager(dataSource);
        TransactionStatus tranA = manager.begin(
                // 传播属性
                Propagation.REQUIRES_NEW,
                // 隔离级别
                Isolation.READ_COMMITTED);
        manager.commit(tranA);
    }


}
