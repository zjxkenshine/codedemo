package com.kenshine.jodacollect;

import org.joda.collect.grid.DenseGrid;
import org.joda.collect.grid.Grid;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname JodaCollectTest
 * @Description JodaCollect使用测试
 * @Date 2024-01-06 12:00
 * @modified By：
 * @version: 1.0$
 */
public class JodaCollectTest {

    /**
     * Grid基本使用
     */
    @Test
    public void test01(){
        // 10行10列网格
        Grid<String> grid = DenseGrid.create(10,10);
        grid.put(1,1,"kenshine");
        grid.put(1,2,"qin");
        grid.put(1,3,"hong");
        System.out.println(grid);
        // cell 一个元素
        Grid.Cell<String> cell =grid.cell(1,1);
        System.out.println(cell);
        System.out.println(grid.cells());
        // 获取值
        System.out.println(grid.get(1,3));
    }

}
