package bilibili.utilites;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.List;
import java.util.Objects;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/25 12:51
 * @description：Preconditions断言测试
 * @modified By：
 * @version: $
 */
public class PreconditionsTest {


    private void checkNotNull(final List<String> list){
        Preconditions.checkNotNull(list);
    }

    private void checkNotNull_WithMessage(final List<String> list){
        Preconditions.checkNotNull(list,"list 不能为null");
    }

    private void checkNotNull_WithFormatMessage(final List<String> list){
        Preconditions.checkNotNull(list,"长度不能为%s",0);
    }



    /**
     * 测试断言1
     */
    @Test(expected = NullPointerException.class)
    public void testCheckNotNull(){
        checkNotNull(null);
    }



    /**
     * 测试断言2 断言消息
     */
    @Test
    public void testCheckNotNull_WithMessage(){
        try {
            checkNotNull_WithMessage(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    /**
     * 测试断言3 格式化消息
     */
    @Test
    public void testCheckNotNull_WithFormatMessage(){
        try {
            checkNotNull_WithFormatMessage(null);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * 测试参数是否相等
     */
    @Test
    public void testCheckArguments(){
        try {
            String type = "A";
            Preconditions.checkArgument(type.equals("A"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 测试状态信息    与checkArgument类似 抛出异常不同
     */
    @Test
    public void testCheckState(){
        try {
            String type = "A";
            Preconditions.checkState(type.equals("B"),"状态不合法");
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /**
     * 测试索引值
     */
    @Test
    public void testCheckIndex(){
        List<String> list = ImmutableList.of();
        Preconditions.checkElementIndex(10,list.size());
    }

    /**
     * Java8中 Objects 类做断言
     */
    @Test(expected = NullPointerException.class)
    public void testByObjects(){
        Objects.requireNonNull(null);
    }

    /**
     * assert 断言
     */
    @Test
    public void testAssert(){
        List<String> list = null;
        //AssertionError
        assert list!=null;
    }

    /**
     * assert 断言消息
     */
    @Test
    public void testAssertWithMessage(){
        List<String> list = null;
        //断言消息
        try {
            assert list!=null:"list 不能为空";
        }catch (Error e){
            System.out.println(e.getMessage());
        }
    }





}
