package com.kenshine.jdave;

import jdave.Specification;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author by kenshine
 * @Classname ListTest
 * @Description 列表判定
 * @Date 2024-01-17 13:54
 * @modified By：
 * @version: 1.0$
 */
public class ListTest extends Specification<List<Integer>> {

    @Test
    public void test01(){
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        // 包含5
        specify(list,contain(5));
        // 不包括10
        specify(list,does.not().contain(10));
    }
}
