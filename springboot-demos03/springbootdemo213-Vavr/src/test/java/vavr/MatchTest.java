package vavr;

import io.vavr.CheckedFunction0;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.junit.Test;

import java.util.function.Predicate;

import static io.vavr.API.*;
import static io.vavr.Patterns.*;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/30 9:57
 * @description：vavr模式匹配测试
 * @modified By：
 * @version: $
 */
public class MatchTest {
    /**
     * 示例1
     */
    @Test
    public void test01(){
        int i = 1;
        Option<String> s = Match(i).option(
                Case($(0), "zero")
        );
        System.out.println(s);
    }

    /**
     * 示例2
     */
    @Test
    public void test02(){
        Integer i = 1;
        String s = Match(i).of(
                Case($(1), "one"),
                Case($(2), "two"),
                Case($(), "?")
        );

        System.out.println(s);
    }

    /**
     * 3.参数为predicate
     */
    @Test
    public void test03(){
        Integer i = 2;
        String s = Match(i).of(
                Case($(is(1)), "one"),
                Case($(is(2)), "two"),
                Case($(), "?")
        );
        System.out.println(s);
    }

    /**
     * 执行副作用
     */
    @Test
    public void test04(){
        String arg = "-h";
        Match(arg).of(
                //run不能用作直接返回值
                Case($(isIn("-h", "--help")), o -> run(this::displayHelp)),
                Case($(isIn("-v", "--version")), o -> run(this::displayVersion)),
                Case($(), o -> run(() -> {
                    throw new IllegalArgumentException(arg);
                }))
        );
    }

    /**
     * 5.命名函数
     */
    @Test
    public void test05(){
        Integer obj1 = new Integer(1);
        Double obj2 = new Double(1.0);
        Number plusOne = Match(obj2).of(
                Case($(instanceOf(Integer.class)), i -> i + 1),
                Case($(instanceOf(Double.class)), d -> d + 1),
                Case($(), o -> { throw new NumberFormatException(); })
        );

        System.out.println(plusOne);
    }


    /**
     * 6.预定义模式 $Success的使用
     */
    @Test
    public void test06(){
        Try<Integer> itry = Try.of(new CheckedFunction0<Integer>() {
            @Override
            public Integer apply() throws Throwable {
                return 1;
            }
        });

        Number num =Match(itry).of(
                Case($Success($()), value -> value+1),
                Case($Failure($()), x -> { throw new NumberFormatException(); })
        );
        System.out.println(num);
    }

    /**
     * 自定义
     */


    private Predicate<Number> instanceOf(Class<?> inClass) {
       return new Predicate<Number>(){
            @Override
            public boolean test(Number num) {
                if(inClass==num.getClass()){
                    return true;
                }
                return false;
            }
        };
    }




    private void displayVersion() {
        System.out.println("version");
    }

    private void displayHelp() {
        System.out.println("help");
    }

    private Predicate<String> isIn(String... strings) {
        return new Predicate<String>() {
            @Override
            public boolean test(String s) {
                for(String s1:strings){
                    if(s.equals(s1)){
                        return true;
                    }
                }
                return false;
            }
        };
    }


    private  Predicate<Integer> is(int i) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                if(integer==i){
                    return true;
                }
                return false;
            }
        };
    }






}
