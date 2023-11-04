package com.kenshine.similarity;

import image.similarity.ImageHistogram;
import image.similarity.ImagePHash;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname Test
 * @Description 相似度测试
 * @Date 2023-11-04 16:05
 * @modified By：
 * @version: 1.0$
 */
public class SimilarTest {


    /**
     * PHash算法
     */
    @Test
    public void testPhash(){
        ImagePHash p = new ImagePHash();
        try {
            int dis = p.distance(new File("img/1.jpg"), new File("img/1.jpg"));
            System.out.println("img1-->img1::::distance:" + dis);
            Assert.assertTrue(dis < 10);

            dis = p.distance(new File("img/1.jpg"), new File("img/2.jpg"));
            System.out.println("img1-->img2::::distance:" + dis);
            // incorrect
            Assert.assertTrue(dis > 10);

            dis = p.distance(new File("img/1.jpg"), new File("img/3.jpg"));
            System.out.println("img1-->img3::::distance:" + dis);
            // incorrect
            Assert.assertTrue(dis > 10);

            dis = p.distance(new File("img/2.jpg"), new File("img/3.jpg"));
            System.out.println("img2-->img3::::distance:" + dis);
            Assert.assertTrue(dis < 10);

            dis = p.distance(new File("img/2.jpg"), new File("img/4.jpg"));
            System.out.println("img2-->img4::::distance:" + dis);
            Assert.assertTrue(dis > 10);

            dis = p.distance(new File("img/1.jpg"), new File("img/4.jpg"));
            System.out.println("img2-->img3::::distance:" + dis);
            Assert.assertTrue(dis > 10);

//            String srcUrl = "http://oarfc773f.bkt.clouddn.com/100000094nzslsdnswbb_1_1_r.jpg";
//            dis = p.distance(new URL("https://img3.doubanio.com/lpic/s27140981.jpg"), new URL(srcUrl));
//            System.out.println("url::::distance:" + dis);
//            Assert.assertTrue(dis < 10);
//
//            dis = p.distance(new URL("https://img3.doubanio.com/lpic/s8966044.jpg"), new URL(srcUrl));
//            System.out.println("url::::distance:" + dis);
//            Assert.assertTrue(dis < 10);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 直方图算法
     */
    @Test
    public void testHistogram(){
        ImageHistogram histogram = new ImageHistogram();
        try {
            double score = histogram.match(new File("img/1.jpg"), new File("img/1.jpg"));
            System.out.println("img1-->img1::::score : " + score);
            Assert.assertTrue(score >= 0.8);

            score = histogram.match(new File("img/1.jpg"), new File("img/2.jpg"));
            System.out.println("img1-->img2::::score : " + score);
            Assert.assertTrue(score >= 0.8);

            score = histogram.match(new File("img/1.jpg"), new File("img/3.jpg"));
            System.out.println("img1-->img3::::score : " + score);
            Assert.assertTrue(score >= 0.8);

            score = histogram.match(new File("img/1.jpg"), new File("img/4.jpg"));
            System.out.println("img1-->img4::::score : " + score);
            Assert.assertTrue(score < 0.8);

            score = histogram.match(new File("img/5.jpg"), new File("img/6.jpg"));
            System.out.println("img5-->img6::::score : " + score);
            // incorrect
            Assert.assertTrue(score < 0.8);

            score = histogram.match(new File("img/1.jpg"), new File("img/6.jpg"));
            System.out.println("img1-->img6::::score : " + score);
            Assert.assertTrue(score < 0.8);

//            String srcUrl = "http://oarfc773f.bkt.clouddn.com/100000094nzslsdnswbb_1_1_r.jpg";
//            score = histogram.match(new URL(srcUrl), new URL("https://img3.doubanio.com/lpic/s27140981.jpg"));
//            System.out.println("url::::score:" + score);
//            Assert.assertTrue(score < 0.8);	// incorrect
//
//            score = histogram.match(new URL(srcUrl), new URL("https://img3.doubanio.com/lpic/s8966044.jpg"));
//            System.out.println("url::::score:" + score);
//            Assert.assertTrue(score < 0.8);	// incorrect

        } catch (IOException e) {
            e.printStackTrace();
            Assert.assertFalse(false);
        }
    }
}
