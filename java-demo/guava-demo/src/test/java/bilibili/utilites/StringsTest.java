package bilibili.utilites;

import com.google.common.base.Charsets;
import com.google.common.base.Strings;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 14:47
 * @description：Strings测试
 * @modified By：
 * @version: $
 */
public class StringsTest {

    /**
     * Strings测试
     */
    @Test
    public void testStrings(){
        //空字符串转null
        String result1 = Strings.emptyToNull("");
        //null转空字符串
        String result2 = Strings.nullToEmpty(null);
        String result3 = Strings.nullToEmpty("aaa");
        //公共前缀
        String result4 = Strings.commonPrefix("aabbcc","aaddee");
        //公共后缀
        String result5 = Strings.commonSuffix("aabbcc","aaddeecc");
        //前面填充
        String result6 = Strings.padStart("Aa",3, 'B');
        //后面填充
        String result7 = Strings.padEnd("Aa",3, 'B');

        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
    }

    @Test
    public void testCharSet(){
        System.out.println(Charsets.UTF_8);
    }


}
