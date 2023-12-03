package com.kenshine.distream;

import cn.langpy.core.ListFrame;
import cn.langpy.core.MapFrame;
import com.kenshine.distream.model.Entity;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/3 13:37
 * @description：使用测试
 * @modified By：
 * @version: $
 */
public class DistreamTest01 {

    /**
     * 基本使用
     */
    @Test
    public void test01(){
        List<Entity> entityList = Arrays.asList(
            new Entity("kenshine",10.2451D),
            new Entity("lin",1.2341D),
            new Entity("seven",11.03321D),
            new Entity("pig",8.8888D),
            new Entity("",0.3456D),
            new Entity("kenshine",9D),
            new Entity("#lin",13.22D)
        );
        ListFrame<Entity> lines = ListFrame.fromList(entityList);
        double sum = lines.get("value").sum();
        /**
         * value的值保留两位小数
         * name为null时赋值 “”
         * value为null时赋值0，否则 加上2
         * 将name里面的#替换掉
         * 计算value的占比，并赋值给percent
         * 最后根据name分组求percent的和
         */
        MapFrame<Object,Double> groups = lines
                // value的值保留两位小数
                .handle("value=format(value,2)")
                // name为null时赋值 “”
                .handle(line->line.getName()==null,"name=''")
                // value为null时赋值0，否则 加上2
                .handle(line->line.getValue()==null,"value=0","value=value+2")
                // 将name里面的#替换掉
                .handle("name=replace(name,'#','')")
                // 计算value的占比，并赋值给percent
                .handle("percent=double(value)/"+sum)
                //按name分组 求和
                .groupBy("name").sum("percent");

        System.out.println(sum);
        System.out.println(groups);

        // 合并表达式
        MapFrame<Object,Double> groups1 = lines
                .handle(entity->entity.getName()==null,"name=''")
                .handle(entity->entity.getValue()==null,"value=0","value=value+2")
                .handle("name=replace(name,'#','');value=format(value,2);percent=double(value)/"+sum)
                .groupBy("name").sum("percent");
        System.out.println(groups1);
    }

    /**
     * 求最值
     */
    @Test
    public void test02(){
        List<Integer> list = Arrays.asList(2,3,4,5,8,9,4);
        ListFrame<Integer> listFrame = ListFrame.fromList(list );
        int max = listFrame.max(); //最大值
        int min= listFrame.min();//最小值
        double avg = listFrame.avg();//平均值
        double sum= listFrame.sum();//求和

        /*最大值所在索引位置*/
        int argmax= listFrame.argmax();
        /*最小值所在索引位置*/
        int argmin= listFrame.argmin();

        System.out.println(argmax);
        System.out.println(argmin);
    }

    /**
     * 类型转换
     */
    @Test
    public void test03(){
        List<String> list = Arrays.asList("1","2","3","4");
        ListFrame<String> listFrame = ListFrame.fromList(list);
        ListFrame<Integer> listInt= listFrame.asInteger();
        ListFrame<Double> listDouble= listFrame.asDouble();
        ListFrame<Float> listFloat= listFrame.asFloat();
        ListFrame<String> listString= listFloat.asString();
    }

    /**
     * 统计元素个数
     */
    @Test
    public void test04(){
        List<Integer> list = Arrays.asList(2,2,2,4);
        MapFrame<Integer,Integer> listFrame = ListFrame.fromList(list).frequency();
        System.out.println(listFrame);
    }

    /**
     * 方差和标准差
     */
    @Test
    public void test05(){
        List<Integer> list = Arrays.asList(2,2,2,4);
        ListFrame<Integer> listFrame = ListFrame.fromList(list );
        listFrame.variance();//方差
        listFrame.standardDeviation();//标准差
    }

    /**
     * 去重
     */
    @Test
    public void test06(){
        List<Integer> list = Arrays.asList(2,2,2,4);
        ListFrame<Integer> listFrame = ListFrame.fromList(list ).distinct();
        System.out.println(listFrame);
    }

    /**
     *  剔除null值
     */
    @Test
    public void test07(){
        List<Integer> list = Arrays.asList(2,null,2,null,6);
        ListFrame<Integer> listFrame = ListFrame.fromList(list );
        listFrame = listFrame.dropNull();
        System.out.println(listFrame);
    }


}
