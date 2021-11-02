import com.kenshine.cxf.CxfApp;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/2 22:41
 * @description：测试客户端调用
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CxfApp.class)
public class AppTest {

    @Test
    public void contextLoads() throws Exception {
        JaxWsDynamicClientFactory clientFactroy = JaxWsDynamicClientFactory.newInstance();
        Client client = clientFactroy.createClient("http://127.0.0.1:8080/webservice/demo?wsdl");
        Object[] invoke = client.invoke("myTest");
        System.out.println(invoke[0].toString());

        Object[] invoke2 = client.invoke("get", "11");
        System.out.println(invoke2[0].toString());

    }

}
