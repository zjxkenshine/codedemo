package fluent;

import cn.org.atool.generator.FileGenerator;
import cn.org.atool.generator.annotation.Table;
import cn.org.atool.generator.annotation.Tables;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/8 23:05
 * @description：生成代码测试
 * @modified By：
 * @version: $
 */
@SpringBootTest
public class EntityGeneratorTests {

    // 数据源 url
    static final String url = "jdbc:mysql://127.0.0.1:3306/db1?useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&useSSL=true";
    // 数据库用户名
    static final String username = "root";
    // 数据库密码
    static final String password = "zjx123456";

    @Test
    public void generate() {
        // 引用配置类，build方法允许有多个配置类
        FileGenerator.build(Empty.class);
    }

    @Tables(
            // 设置数据库连接信息
            url = url, username = username, password = password,
            // 设置entity类生成src目录, 相对于 user.dir
            srcDir = "src/main/java",
            // 设置entity类的package值
            basePack = "com.kenshine.fluent",
            // 设置dao接口和实现的src目录, 相对于 user.dir
            daoDir = "src/main/java",
            // 设置哪些表要生成Entity文件
            tables = {@Table(value = {"user"})}
    )

    static class Empty { //类名随便取, 只是配置定义的一个载体
    }

}
