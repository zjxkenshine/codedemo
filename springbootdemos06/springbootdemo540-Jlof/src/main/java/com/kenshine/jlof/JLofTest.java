package com.kenshine.jlof;

import com.jlof.core.LOF;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author by kenshine
 * @Classname JLofTest
 * @Description JLof测试
 * @Date 2023-12-05 12:04
 * @modified By：
 * @version: 1.0$
 */
public class JLofTest {

    /**
     * 测试
     */
    @Test
    public void test01(){
        ArrayList<double[]> data = new ArrayList<double[]>();
        data.add(new double[]{0, 0});
        data.add(new double[]{0, 1});
        data.add(new double[]{1, 0});
        data.add(new double[]{1, 1});
        data.add(new double[]{1, 2});
        data.add(new double[]{2, 1});
        data.add(new double[]{2, 2});
        data.add(new double[]{2, 0});
        data.add(new double[]{2, 0});
        data.add(new double[]{2, 0});
        data.add(new double[]{2, 0});

        LOF model = new LOF(data);
        int kNN = 5;

        System.out.println(model.getScore(new double[]{2, 0}, kNN));
        System.out.println(model.getScore(new double[]{0, 0}, kNN));
        System.out.println(model.getScore(new double[]{10, 4}, kNN));
    }

    /**
     * 找到最近的邻居
     */
    @Test
    public void test02(){
        ArrayList<double[]> data = new ArrayList<>();
        data.add(new double[]{0, 0});
        data.add(new double[]{0, 1});
        data.add(new double[]{1, 0});
        data.add(new double[]{1, 1});
        data.add(new double[]{1, 2});
        data.add(new double[]{2, 1});
        data.add(new double[]{2, 2});
        data.add(new double[]{2, 0});
        data.add(new double[]{2, 0});
        data.add(new double[]{2, 0});
        data.add(new double[]{2, 0});
        int kNN = 5;

        LOF model = new LOF(data);
        double[] testSample = new double[]{2, 0};
        System.out.println("\nNeighbors of "+ Arrays.toString(testSample));
        ArrayList<double[]> neighbors = model.getNeighbors(testSample, kNN);
        for(double[] n : neighbors){
            System.out.println(Arrays.toString(n));
        }
    }

    /**
     * 获取数据对应的lof值
     */
    @Test
    public void test03(){
        ArrayList<double[]> data = new ArrayList<double[]>();
        data.add(new double[]{0, 0});
        data.add(new double[]{0, 1});
        data.add(new double[]{1, 0});
        data.add(new double[]{1, 1});
        data.add(new double[]{1, 2});
        data.add(new double[]{2, 1});
        data.add(new double[]{2, 2});
        data.add(new double[]{2, 0});
        data.add(new double[]{2, 0});
        data.add(new double[]{2, 0});
        data.add(new double[]{2, 0});

        LOF model = new LOF(data);
        int kNN = 5;

        double[] scores = model.getTrainingScores(kNN);
        for(int i = 0; i < scores.length; i++){
            System.out.println(Arrays.toString(data.get(i)) + "\t" + scores[i]);
        }
    }
}
