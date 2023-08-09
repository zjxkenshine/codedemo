package test;

import com.kenshine.vault.Secrets;
import com.kenshine.vault.VaultApp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.vault.authentication.TokenAuthentication;
import org.springframework.vault.client.VaultEndpoint;
import org.springframework.vault.core.VaultTemplate;
import org.springframework.vault.support.VaultResponseSupport;

import java.net.URI;

/**
 * @author by kenshine
 * @Classname DemoApplicationTests
 * @Description 测试
 * @Date 2023-08-09 9:46
 * @modified By：
 * @version: 1.0$
 */
@SpringBootTest(classes = VaultApp.class)
public class DemoApplicationTests {
    static VaultTemplate vaultTemplate;

    @BeforeEach
    public void before() {
        //指定vault服务的地址，这里需要在本地启动vault服务，这里启动的只是开发模式
        URI uri = URI.create("http://127.0.0.1:8200");
        /** 还有就是这里的参数不能直接new VaultEndpoint(),然后再设置host或者port啥的，
         因为VaultEndpoint默认的scheme为https,然后本地的服务是http的，所以访问不了的。 **/
        vaultTemplate = new VaultTemplate(VaultEndpoint.from(uri),
                //这里填入自己的token，因为是开发模式，所以这里填入的是root token，后面的生产环境可以进行权限细分
                new TokenAuthentication("hvs.SPZ9klezjV9jurWmIqo6J0gf"));
    }

    @Test
    public void contextLoads() {
    }

    /**
     * 测试简单的kv加密引擎的使用
     */
    @Test
    public void testKvVault() {
        Secrets secrets = new Secrets();
        secrets.username = "hello";
        secrets.password = "world";

        /**
         * 这里有个大坑，开发者模式下默认是有一个“/secret”的path的，这个path用通用的读写指令"write/read"都不行，其他path
         * 都可以，在终端也是一样，需要用"kv put"和"kv get"才行，暂时不知道为什么.
         */
        vaultTemplate.write("kvdemo/myapp", secrets);

        VaultResponseSupport<Secrets> response = vaultTemplate.read("kvdemo/myapp", Secrets.class);
        System.out.println(response.getData().getUsername());
    }


    /**
     * 测试简单的kv加密引擎的使用
     */
    @Test
    public void testVault_list() {
        //查询指定path下的子path
        System.out.println(vaultTemplate.list("kvdemo"));
    }
}
