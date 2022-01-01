package fastutil;

import it.unimi.dsi.fastutil.io.FastBufferedOutputStream;
import org.junit.Test;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/1 22:19
 * @description：测试io
 * @modified By：
 * @version: $
 */
public class IoTest {
    int count=100000;

    @Test
    public void testIO() throws IOException {
        byte[] out = new byte[count];
        for(int i=0;i<count;i++){
            out[i] = (byte) (1);
        }

        //起始时间
        long start1 =System.currentTimeMillis();
        DataOutputStream output1 = new DataOutputStream(new FileOutputStream(new File("F:\\IDEAworkespace\\codedemo\\springboot-demos03\\springbootdemo217-FastUtil\\out\\java")));
        output1.write(out);
        output1.close();
        long end1 = System.currentTimeMillis();
        System.out.println("FileOutputStream写入时长："+(end1-start1));

        long start2 =System.currentTimeMillis();
        FastBufferedOutputStream output2 = new FastBufferedOutputStream(new FileOutputStream(new File("F:\\IDEAworkespace\\codedemo\\springboot-demos03\\springbootdemo217-FastUtil\\out\\fastUtil")));
        output2.write(out);
        output2.close();
        long end2 = System.currentTimeMillis();
        System.out.println("FastBufferedOutputStream时长："+(end2-start2));
    }

}
