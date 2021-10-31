package bilibili.collections;

import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.Lists;
import org.junit.Test;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/31 10:08
 * @description：流式编程迭代器测试
 * @modified By：
 * @version: $
 *
 * 类似Stream
 */
public class FluentIterableTest {


    private FluentIterable<String> build(){
        ArrayList<String> list = Lists.newArrayList("Kenshine","Qin","Guava","Scala");
        return FluentIterable.from(list);
    }


    /**
     * 过滤
     */
    @Test
    public void TestFilter(){
        FluentIterable<String> fit = build();
        System.out.println(fit.size());

        //过滤仅保留元素长度大于4的
        FluentIterable<String> result = fit.filter(e->e!=null && e.length()>4);
        System.out.println(result.size());
    }


    /**
     * 添加
     */
    @Test
    public void testAppend(){
        FluentIterable<String> fit = build();

        FluentIterable<String> result1 = fit.append("haha","666");
        FluentIterable<String> result2 = fit.append(Lists.newArrayList("append"));

        System.out.println(result1);
        System.out.println(result2);
    }

    /**
     * 判断元素是否匹配
     */
    @Test
    public void  testMatch(){
        FluentIterable<String> fit = build();
        boolean result = fit.allMatch(e->e!=null&&e.length()>=4);
        System.out.println(result);

        boolean result1 = fit.anyMatch(e->e!=null&&e.length()>=4);
        System.out.println(result1);
        //匹配首个元素
        Optional<String> result2 = fit.firstMatch(e->true);
        System.out.println(result2.orNull());
    }

    /**
     * 首个元素或最后一个元素
     */
    @Test
    public void testFirstLast(){
        FluentIterable<String> fit = build();
        Optional<String> first = fit.first();
        Optional<String> last = fit.last();

        System.out.println(first.orNull());
        System.out.println(last.orNull());
    }


    /**
     * 限制元素个数
     */
    @Test
    public void testLimit(){
        FluentIterable<String> fit = build();
        FluentIterable<String> limit = fit.limit(3);
        System.out.println(limit);
    }

    /**
     * 复制 对应stream中断操作
     */
    @Test
    public void testCopyIn(){
        FluentIterable<String> fit = build();
        ArrayList<String> list = Lists.newArrayList("Java");
        fit.copyInto(list);
        System.out.println(list);
    }

    /**
     * 生成无限循环集合 无限流
     */
    @Test
    public void testCycle(){
        FluentIterable<String> fit = build();
        FluentIterable<String> cycle = fit.cycle().limit(20);

        System.out.println(cycle);
        cycle.forEach(System.out::println);
    }

    /**
     * 转换每个元素并生成新流
     */
    @Test
    public void testTransForm(){
        FluentIterable<String> fit = build();
        fit.transform(e->e.length()).forEach(System.out::println);
    }

    /**
     * 转换并连接
     * 会把查询出来的结果拼接到一起
     */
    @Test
    public void testTransFormAndConcat(){
        FluentIterable<String> fit = build();
        FluentIterable<Integer> result =fit.transformAndConcat(e->getList(e));

        System.out.println(result);
    }


    private List<Integer> getList(String key){
        if(key.equals("Kenshine")){
            //模拟批量查询了两条结果
            return Lists.newArrayList(1,3,5);
        }else {
            return Lists.newArrayList(6);
        }
    }

    /**
     * 连接
     */
    @Test
    public void testJoin(){
        FluentIterable<String> fit = build();
        String result = fit.join(Joiner.on(","));
        System.out.println(result);
    }



}
