package bilibili.utilites;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.IsEqual.*;
import static org.hamcrest.core.IsSame.*;
import static org.junit.Assert.fail;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/24 22:19
 * @description：Guava Joiner测试
 * @modified By：
 * @version: $
 *
 *
 */
public class JoinerTest {

    private final List<String> stringList = Arrays.asList(
       "Google","Guava","Java","Scala","Kafka"
    );

    private final List<String> stringListHasNull = Arrays.asList(
            "Google","Guava","Java","Scala",null
    );

    private final Map<String,String> stringMap = ImmutableMap.of("Hello","Guava","Java","Scala");

    private final String targetFileName = "D:\\logs\\guava-joiner.text";

    /**
     * Joiner 集合转字符串
     */
    @Test
    public void testJoin_OnJoin(){
        String result = Joiner.on("#").join(stringList);
        assertThat(result,equalTo("Google#Guava#Java#Scala#Kafka"));
    }

    /**
     * List中包含null值
     */
    @Test(expected = NullPointerException.class)
    public void testJoin_OnJoinWithNull(){
        String result = Joiner.on("#").join(stringListHasNull);
        assertThat(result,equalTo("Google#Guava#Java#Scala#Kafka"));
    }

    /**
     * 跳过List中的null值
     */
    @Test
    public void testJoin_OnJoin_WithNull_ButSkip(){
        String result = Joiner.on("#").skipNulls().join(stringListHasNull);
        assertThat(result,equalTo("Google#Guava#Java#Scala"));
    }


    /**
     * 将List中的null值设置为默认值
     */
    @Test
    public void testJoin_OnJoin_WithNull_UserDefaultValue(){
        String result = Joiner.on("#").useForNull("DEFAULT").join(stringListHasNull);
        assertThat(result,equalTo("Google#Guava#Java#Scala#DEFAULT"));
    }


    /**
     * 将集合中的值放入StringBuilder
     */
    @Test
    public void testJoin_On_Append_To_StringBuilder(){
        final StringBuilder builder = new StringBuilder();
        StringBuilder resultBuilder = Joiner.on("#").useForNull("DEFAULT").appendTo(builder,stringListHasNull);
        //resultBuilder 与 builder 是同一个对象
        assertThat(builder,sameInstance(resultBuilder));
        assertThat(resultBuilder.toString(),equalTo("Google#Guava#Java#Scala#DEFAULT"));
        assertThat(builder.toString(),equalTo("Google#Guava#Java#Scala#DEFAULT"));
    }

    /**
     * 将集合中的值写入文件
     */
    @Test
    public void testJoin_On_Append_To_Writer(){
        try (FileWriter writer = new FileWriter(new File(targetFileName))){
            Joiner.on("#").useForNull("DEFAULT").appendTo(writer,stringListHasNull);
            assertThat(Files.isFile().test(new File(targetFileName)),equalTo(true));
        } catch (IOException e) {
            fail("append to the writer error");
        }
    }

    /**
     * 通过java8 Stream实现Joiner
     */
    @Test
    public void testJoiningByStreamSkipNullValues(){
        String result = stringListHasNull.stream().filter(i->i!=null&&!i.isEmpty()).collect(Collectors.joining("#"));
        assertThat(result,equalTo("Google#Guava#Java#Scala"));
    }

    /**
     * 通过java8 Stream实现Joiner 设置默认值
     */
    @Test
    public void testJoiningByStream_UseDefaultValues(){
        String result = stringListHasNull.stream()
                .map(i->i==null||i.isEmpty()?"DEFAULT":i)
                .collect(Collectors.joining("#"));
        assertThat(result,equalTo("Google#Guava#Java#Scala#DEFAULT"));
    }

    /**
     * Map转字符串
     */
    @Test
    public void testJoinOnWithMap(){
        assertThat(Joiner.on("#").withKeyValueSeparator("=").join(stringMap),equalTo("Hello=Guava#Java=Scala"));
    }



}
