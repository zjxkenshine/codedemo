package bilibili.io;

import com.google.common.io.ByteSource;
import com.google.common.io.Closer;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 23:10
 * @description：Closer 关闭流测试
 * @modified By：
 * @version: $
 */
public class CloserTest {

    private String PATH = "F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources\\io\\1.jpg";

    /**
     * Closer测试关闭
     */
    @Test
    public void testCloser() throws IOException {
        ByteSource byteSource = Files.asByteSource(new File(PATH));
        // 方式一: try(){}resource会自动关闭
//        try(InputStream inputStream = byteSource.openStream();){
//        } catch (Throwable e) {
//            e.printStackTrace();
//        } finally {
//        }

        //方式二 使用closer关闭
        Closer closer = Closer.create();
        try {
            InputStream inputStream = closer.register(byteSource.openStream());
        } catch (Throwable e) {
            //重新抛出异常
            //使用一般close方法也会抛异常，这里捕获的异常会被抛弃，closer不会有这个问题，会叠加异常
            throw closer.rethrow(e);
        } finally {
            closer.close();
        }
    }

}
