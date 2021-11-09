import com.kenshine.influxdb.InfluxDBApp;
import com.kenshine.influxdb.dao.InfluxDao;
import com.kenshine.influxdb.model.pojo.Location;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nutz.json.Json;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/9 16:48
 * @description：测试
 * @modified By：
 * @version: $
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = InfluxDBApp.class)
public class InfluxDBTests {
    @Autowired
    private InfluxDao influxDao;

    /**
     * 测试数据库连接是否成功
     */
    @Test
    public void ping() {
        if (influxDao.ping()) {
            log.info("连接成功");
        } else {
            log.info("连接失败");
        }
    }

    /**
     * 创建数据库
     */
    @Test
    public void create() {
        // 默认使用配置文件中数据库
        // influxDao.createDataBase();
        // 使用指定数据库
        influxDao.createDataBase("db2");
    }

    /**
     * 删除数据库
     */
    @Test
    public void delete() {
        // 默认使用配置文件中数据库
        // influxDao.deleteDataBase();
        // 使用指定数据库
        influxDao.deleteDataBase("db2");
    }

    /**
     * 插入数据
     */
    @Test
    public void insert() {
        // 插入单条数据
        Location location = new Location();
        String l = String.valueOf(TimeUnit.MILLISECONDS);
        location.setBelongId("1");
        location.setTime(l);
        location.setLd("ld");
        location.setHost("127.0.0.1");
        location.setLn("ln");
        location.setName("kenshine");
        location.setValue("0");
        influxDao.insert(location);
    }

    /**
     * 获取数据
     */
    @Test
    public void list() {
        //查询KENSHINE表所有数据
        String sql = "SELECT * FROM \"KENSHINE\" WHERE time > now() - 5m limit 100";
        List<Location> locations = influxDao.query(Location.class, sql);
        if (locations == null) {
            log.info("暂无数据");
        }
        System.out.println("数据为：" + Json.toJson(locations));
    }

}
