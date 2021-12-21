package dbunit;

import com.kenshine.dbunit.DBUnitApp;
import com.kenshine.dbunit.db.AbstractDbunitTestCase;
import com.kenshine.dbunit.mapper.UserMapper;
import com.kenshine.dbunit.model.User;
import org.dbunit.DatabaseUnitException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/21 8:52
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DBUnitApp.class)
public class TestUserMapper extends AbstractDbunitTestCase {


    //期望返回的数据
    private User exUser;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    public TestUserMapper() throws DatabaseUnitException {
        super("dbunit/testUser.xml");
    }

    // 备份数据，准备数据
    @Before
    public void init() throws SQLException, DatabaseUnitException, IOException {
        exUser = new User(10,"kenshine","123456");
        setConn(dataSource.getConnection());
        backOneTable("user");
        insertTestData();
    }

    @Test
    public void testFindUserById(){
        User acUser = userMapper.findUserById(10);
        //断言 判断请求回来的数据是否和预期的一致
        Assert.assertEquals(exUser.getId(),acUser.getId());
        Assert.assertEquals(exUser.getName(),acUser.getName());
        Assert.assertEquals(exUser.getPwd(),acUser.getPwd());
    }

    /**
     * 还原数据
     */
    @After
    public void destory() throws FileNotFoundException, DatabaseUnitException, SQLException {
        resumeTable();
    }


}
