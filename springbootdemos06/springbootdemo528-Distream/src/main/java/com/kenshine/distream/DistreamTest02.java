package com.kenshine.distream;

import cn.langpy.core.ListFrame;
import cn.langpy.core.MapFrame;
import com.kenshine.distream.handler.MapHandler;
import org.junit.Test;

import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/3 14:23
 * @description：使用测试 补充
 * @modified By：
 * @version: $
 */
public class DistreamTest02 {

    /**
     * 读取文件
     */
    @Test
    public void test01(){
        ListFrame<String> lines = ListFrame.readString("src\\main\\resources\\test.txt");
        //按行读取文件,并在每一行的结尾添加";"，每一行的开头添加"=>"
        lines = lines
                .handle(line -> line + ";")
                .handle(line -> "=>"+line );
        System.out.println(lines);
        // 保存到文件
        lines.toFile("src\\main\\resources\\test01.txt");
    }

    /**
     * 读取CSV文件到Map
     */
    @Test
    public void test02(){
        ListFrame<Map<String, Object>> lines = ListFrame.readMap("src\\main\\resources\\test.csv",new Class[]{Integer.class,String.class,Integer.class,Double.class});
        lines = lines
                .handle("收入=收入*0.8")
                .handle("序号='0'+序号;姓名=序号+姓名")
                .handle(new MapHandler());
        System.out.println(lines);
        // 保存到文件
        lines.toFile("src\\main\\resources\\test01.txt");
    }

    /**
     * 按列获取数据，求最值
     */
    @Test
    public void test03(){
        ListFrame<Map<String, Object>> lines = ListFrame.readMap("src\\main\\resources\\test.csv",new Class[]{Integer.class,String.class,Integer.class,Double.class});
        ListFrame<Double> indexs = lines.get("收入");
        double maxIncome = indexs.max();
        double minIncome = indexs.min();
        double avgIncome = indexs.avg();
        int argmax= indexs.argmax();
        /*the index of min*/
        int argmin= indexs.argmin();
        System.out.println(argmin);
        System.out.println(argmax);
    }

    /**
     * 分组求和
     */
    @Test
    public void test04(){
        ListFrame<Map<String, Object>> lines = ListFrame.readMap("src\\main\\resources\\test.csv",new Class[]{Integer.class,String.class,Integer.class,Double.class});
        MapFrame<Object, ListFrame> agesGroup = lines.groupBy("年龄");
        MapFrame<Object, Integer> count = agesGroup.count();
        MapFrame<Object, Double> incomeAvg = agesGroup.avg("收入");
        MapFrame<Object, Double> incomeSum = agesGroup.sum("收入");
        MapFrame<Object, ListFrame> incomeConcat = agesGroup.concat("收入");
        /*连续分组*/
        MapFrame<Object, MapFrame<Object, ListFrame>> incomeAgeConcat = lines.groupBy("收入").groupBy("年龄");

        System.out.println(incomeAgeConcat);
    }

    /**
     * 数据替换
     */
    @Test
    public void test05(){
        ListFrame<Map<String, Object>> lines = ListFrame.readMap("src\\main\\resources\\test.csv",new Class[]{Integer.class,String.class,Integer.class,Double.class});
        lines = lines.replace("姓名","张三","kenshine");
        System.out.println(lines);
    }

    /**
     * 常用函数
     */
    @Test
    public void test06(){
        ListFrame<Map<String, Object>> lines = ListFrame.readMap("src\\main\\resources\\test.csv",new Class[]{Integer.class,String.class,Integer.class,Double.class});
        /*code的值转为int并赋值给id  等价于  line.put("id",Integer.valueOf(code))*/
        lines = lines.handle("id=int(code)");

        /*value的值转为double并赋值给percent  等价于  line.put("percent",Double.valueOf(code))*/
        lines = lines.handle("percent=double(value)");

        /*value的值转为string并赋值给name等价于  line.put("name",value+"")*/
        lines = lines.handle("name=string(value)");

        /*等价于string的substring*/
        lines = lines.handle("name=substring(name,1,2)");

        /*把name的"xxx" 替换为"yyy"*/
        lines = lines.handle("name=replace(name,'xxx','yyy')");

        /*把name的"xxx" 替换为""*/
        lines = lines.handle("name=name-'xxx'");

        /*类似于indexof*/
        lines = lines.handle("id=index(name,'xxx')");

        /*percent保留两位小数*/
        lines = lines.handle("percent=format(percent,2)");
    }
}
