package test;

import com.kenshine.snakeyml.domain.Customer;
import org.junit.Test;
import org.yaml.snakeyaml.Yaml;

import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/26 17:59
 * @description：
 * @modified By：
 * @version: $
 *
 * 生成YAML文件测试
 */
public class SnakeYamlTest02 {

    /**
     * 生成YAML文件 基本用法
     */
    @Test
    public void test01(){
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("name", "Silenthand Olleander");
        data.put("race", "Human");
        data.put("traits", new String[] { "ONE_HAND", "ONE_EYE" });
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        yaml.dump(data, writer);
        String expectedYaml = "name: Silenthand Olleander\nrace: Human\ntraits: [ONE_HAND, ONE_EYE]\n";
        assertEquals(expectedYaml, writer.toString());
    }

    /**
     * 输出自定义Java对象
     */
    @Test
    public void test02(){
        Customer customer = new Customer();
        customer.setAge(45);
        customer.setFirstName("Greg");
        customer.setLastName("McDowell");
        Yaml yaml = new Yaml();
        StringWriter writer = new StringWriter();
        yaml.dump(customer, writer);
        String expectedYaml = "!!com.kenshine.snakeyml.domain.Customer {age: 45, firstName: Greg, lastName: McDowell}\n";

        assertEquals(expectedYaml, writer.toString());
    }

}
