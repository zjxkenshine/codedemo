package bilibili.utilites;

import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsNull.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 12:28
 * @description：Splitter 拆分测试
 * @modified By：
 * @version: $
 */
public class SplitterTest {

    /**
     * 基本使用
     */
    @Test
    public void  testSplit_OnSplit(){
        List<String> result = Splitter.on("|").splitToList("hello|world");
        System.out.println(result);
        assertThat(result,notNullValue());
    }

    /**
     * 忽略拆分出来的空值
     */
    @Test
    public void  testSplit_OnSplit_OmitEmpty(){
        List<String> result = Splitter.on("|").omitEmptyStrings().splitToList("hello|world||");
        System.out.println(result);
    }

    /**
     * 拆分出来的字符串做trim处理
     */
    @Test
    public void  testSplit_OnSplit_OmitEmpty_TrimResult(){
        List<String> result = Splitter.on("|").trimResults().omitEmptyStrings().splitToList("hello  |  world ||");
        System.out.println(result);
    }

    /**
     * n个字符串一组进行拆分
     */
    @Test
    public void testSplitFixLength(){
        List<String> result =  Splitter.fixedLength(4).splitToList("aaabbbcccddd");
        System.out.println(result);
    }


    /**
     * 拆分成n项(限制为n项)
     */
    @Test
    public void testSplit_Limit(){
        List<String> result =  Splitter.on("#").limit(3).splitToList("aa#bb#cc#dd");
        System.out.println(result);
    }


    /**
     * 传递正则表达式字符串进行拆分
     */
    @Test
    public void testSplit_OnPatternString(){
        List<String> result =  Splitter.onPattern("\\|").trimResults().omitEmptyStrings().limit(3).splitToList("aa|bb||cc|dd");
        System.out.println(result);
    }

    /**
     * 传递正则表达式进行拆分，方式二
     */
    @Test
    public void testSplit_OnPattern(){
        List<String> result =  Splitter.on(Pattern.compile("\\|")).trimResults().omitEmptyStrings().limit(3).splitToList("aa|bb||cc|dd");
        System.out.println(result);
    }

    /**
     * 拆分并放入map中
     */
    @Test
    public void testSplit_OnSplitToMap(){
        Map<String,String> resultMap= Splitter.on(Pattern.compile("\\|")).trimResults().omitEmptyStrings().limit(3).withKeyValueSeparator("=").split("key1=v1||key2=v2|key3=v3");
        System.out.println(resultMap);
    }






}
