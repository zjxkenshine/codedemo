package bilibili.utilites;

import com.google.common.io.BaseEncoding;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 23:29
 * @description：Base编码测试
 * @modified By：
 * @version: $
 */
public class BaseEncodingTest {

    /**
     * Base64测试
     */
    @Test
    public void  testBaseI64EncodingDecoding(){
        BaseEncoding baseEncoding = BaseEncoding.base64();
        System.out.println(baseEncoding.encode("hello".getBytes()));
        System.out.println(new String(baseEncoding.decode("aGVsbG8=")));
    }

}
