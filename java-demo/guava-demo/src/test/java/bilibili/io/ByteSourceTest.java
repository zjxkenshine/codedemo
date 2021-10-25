package bilibili.io;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteSink;
import com.google.common.io.ByteSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 22:27
 * @description：ByteSource 字节读取测试
 * @modified By：
 * @version: $
 */
public class ByteSourceTest {

    private final String PATH = "F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources\\io\\1.jpg";
    private final String SINK_PATH = "F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources\\io\\SINK.dat";
    private final String TARGET_PATH = "F:\\IDEAworkespace\\codedemo\\java-demo\\guava-demo\\src\\test\\resources\\io\\target.jpg";


    /**
     * ByteSource 读取二进制文件
     * @throws IOException
     */
    @Test
    public void testAsByteSource() throws IOException {
        File file = new File(PATH);
        ByteSource byteSource = Files.asByteSource(file);
        byte[] readBytes = byteSource.read();
        //将图片转换为了字节数组
        assertThat(readBytes,equalTo(Files.toByteArray(file)));
    }

    /**
     * 源切片
     */
    @Test
    public void testSliceByteSource() throws IOException {
        ByteSource byteSource = ByteSource.wrap(new byte[]{0x00,0x01,0x02,0x03,0x04,0x05,0x06,});
        ByteSource silenceByteSource = byteSource.slice(4,5);
        byte[] bytes = silenceByteSource.read();
        for (byte b:bytes){
            System.out.println(b);
        }
    }


    /**
     * ByteSink测试
     */
    @Test
    public void testByteSink() throws IOException {
        File file = new File(SINK_PATH);
        file.deleteOnExit();
        ByteSink byteSink = Files.asByteSink(file);
        byte[] bytes = {0x01,0x02};
        byteSink.write(bytes);

        byte[] expected = Files.toByteArray(file);
        assertThat(expected,equalTo(bytes));
    }

    /**
     * ByteSource到ByteSink测试
     * @throws IOException
     */
    @Test
    public void testFromSourceToSink() throws IOException {
        String source = PATH;
        String target = TARGET_PATH;
        File sourceFile = new File(source);
        File targetFile = new File(target);
        targetFile.deleteOnExit();
        ByteSource byteSource = Files.asByteSource(new File(source));
        byteSource.copyTo(Files.asByteSink(new File(target)));
        //是否复制
        assertThat(targetFile.exists(),equalTo(true));
        //hash是否相等
        String sourceHash = Files.asByteSource(sourceFile).hash(Hashing.sha256()).toString();
        String targetHash = Files.asByteSource(targetFile).hash(Hashing.sha256()).toString();
        assertThat(sourceHash,equalTo(targetHash));
    }


}
