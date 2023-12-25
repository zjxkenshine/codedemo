package com.kenshine.diffutils;

import org.junit.Test;

import java.util.List;

/**
 * @author by kenshine
 * @Classname DiffutilsTest
 * @Description 不同比较测试
 * @Date 2023-12-25 9:11
 * @modified By：
 * @version: 1.0$
 */
public class DiffutilsTest {

    /**
     * 比对测试
     */
    @Test
    public void test01(){
        List<CompareInfo> compareInfoList=CompareUtils.compareAll("src\\main\\resources\\t1.txt","src\\main\\resources\\t2.txt");
        System.out.println(compareInfoList);
        compareInfoList.forEach(
                compareInfo -> {
                    if( !compareInfo.getCompareType().equals(CompareUtils.Result_EQUAL)){
                        System.out.println(compareInfo);
                    }
                }
        );
    }

}
