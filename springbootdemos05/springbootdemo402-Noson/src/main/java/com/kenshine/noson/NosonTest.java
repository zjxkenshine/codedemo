package com.kenshine.noson;

import com.kenshine.noson.entity.Cycle;
import com.kenshine.noson.entity.Nico;
import org.junit.Test;
import org.nico.noson.Noson;
import org.nico.noson.NosonConfig;
import org.nico.noson.entity.NoType;

import java.util.*;

/**
 * @author by kenshine
 * @Classname NosonTest
 * @Description noson测试
 * @Date 2023-10-23 10:06
 * @modified By：
 * @version: 1.0$
 */
public class NosonTest {
    /**
     * 循环
     */
    @Test
    public void test01(){
        //设置死循环-最大循环上限
        NosonConfig.ALLOW_CYCLE_MAX_COUNT = 1;
        NosonConfig.ALLOW_EMPTY = false;
        NosonConfig.ALLOW_EMPTY_TO_NULL = false;

        Cycle c = new Cycle();
        System.out.println(Noson.reversal(c));

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("map", map);
        System.out.println(Noson.reversal(map));

        List<Object> list = new ArrayList<Object>();
        list.add(list);
        System.out.println(Noson.reversal(list));

        Set<Object> sets = new HashSet<Object>();
        sets.add(sets);
        System.out.println(Noson.reversal(sets));

        map.put("list", list);
        System.out.println(Noson.reversal(map));

    }

    /**
     * 基本使用
     */
    @Test
    public void test02(){
        //json字符串
        String json = "{\"name\":kenshine,age:21,skill:[java,c,c#,python,php,javascript],deposit:0.0,info:{address:china,job:IT}}";

        //json 对象数数组
        String jsonArray = "[" + json + "," + json + "]";

        //解析为noson
        Noson noson = Noson.parseNoson(json);
        List<Object> nosonArray = Noson.parseArray(jsonArray);

        //noson转json
        System.out.println("==========>> Noson to Json：");
        System.out.println(json = noson.toString());
        System.out.println(jsonArray = nosonArray.toString());
        System.out.println();

        //从noson获取参数
        System.out.println("==========>> Get parameter from noson：");
        System.out.println("name\t" + noson.get("name"));
        System.out.println("age\t" + noson.get("age"));
        System.out.println("skill\t" + noson.get("skill"));
        System.out.println("deposit\t" + noson.get("deposit"));
        System.out.println("info\t" + noson.get("info"));
        System.out.println();

        //转换为Map
        Map<String, Object> testMap = Noson.convert(json, Map.class);
        System.out.println("==========>> Convert to Map：");
        System.out.println(testMap);
        System.out.println();

        //转换为list
        List<Object> testList = Noson.convert(nosonArray, List.class);
        System.out.println("==========>> Convert to List：");
        System.out.println(testList);
        System.out.println();

        //转换为set
        Set<Object> testSet = Noson.convert(nosonArray, Set.class);
        System.out.println("==========>> Convert to Set：");
        System.out.println(testSet);
        System.out.println();

        //转换为java对象
        System.out.println("==========>> Convert to Java Object：");
        Nico nico = Noson.convert(json, Nico.class);
        System.out.println(nico);
        System.out.println();

        //转换为复杂类型
        System.out.println("==========>> Convert to Complex Types：");
        List<Nico> nicos = Noson.convert(nosonArray, new NoType<List<Nico>>(){});
        System.out.println(nicos);
        System.out.println();

        //反转对象
        System.out.println("==========>> Reversal Object to Json：");
        System.out.println(Noson.reversal(testMap));
        System.out.println(Noson.reversal(testList));
        System.out.println(Noson.reversal(testSet));
        System.out.println(Noson.reversal(nico));
        System.out.println(Noson.reversal(nicos));
        System.out.println();
    }
}
