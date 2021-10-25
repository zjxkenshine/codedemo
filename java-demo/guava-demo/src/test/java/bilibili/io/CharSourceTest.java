package bilibili.io;

import com.google.common.collect.ImmutableList;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.primitives.Chars;
import org.junit.Test;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 21:19
 * @description：CharSource 字符输入测试
 * @modified By：
 * @version: $
 *
 * Files中经常有用到CharSource,CharSink等
 *
 * CharSink测试参考ByteSink
 */
public class CharSourceTest {

    /**
     * 测试CharSourceWrap
     */
    @Test
    public void testCharSourceWrap() throws IOException {
        //创建charSource
        CharSource charSource = CharSource.wrap("a bb ccc dddd");
        String resultAsRead =  charSource.read();
        System.out.println(resultAsRead);
        ImmutableList<String> list = charSource.readLines();    //list.size=1
        System.out.println(list);
    }

    /**
     *
     */
    @Test
    public void testCharSourceConcat() throws IOException {
        CharSource charSource = CharSource.concat(
                CharSource.wrap("i am kenshine\n"),
                CharSource.wrap("i am 666\n"),
                CharSource.wrap("hello world\n")
        );
        //System.out.println(charSource);
        charSource.lines().forEach(System.out::println);
    }






}
