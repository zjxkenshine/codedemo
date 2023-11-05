package com.kenshine.rtree;

import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.RTree;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Geometry;
import com.github.davidmoten.rtree.geometry.Point;
import org.junit.Test;
import rx.Observable;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/5 21:28
 * @description：测试
 * @modified By：
 * @version: $
 */
public class TreeTest {
    /**
     * 创建
     */
    @Test
    public void test01(){
        //创建R树，可以指定最小、最大孩子结点数，splitter,selector
        RTree<String, Geometry> tree = RTree.minChildren(3).maxChildren(6).create();
        // 创建R*树
        RTree<String, Geometry> Rtree = RTree.star().maxChildren(6).create();
    }

    /**
     *可插入4种空间数据：点、线、圆、矩形
     * Geometries.Rectangle
     * Geometries.circle
     * Geometries.point
     * Geometries.line
     */
    @Test
    public void test02(){
        RTree<String, Geometry> tree = RTree.minChildren(3).maxChildren(6).create();
        //插入点数据
        tree = tree.add("testPoint", Geometries.point(116.0D, 32.0D));
        System.out.println(tree.asString());
        //删除点数据
        tree = tree.delete("testPoint", Geometries.point(116.0D,32.0D));
        System.out.println(tree.asString());
        // 搜索
        Observable<Entry<String, Geometry>> entries = tree.search(Geometries.point(116.0D, 32.0D));
        Iterable<Entry<String, Geometry>> result1 = tree.search(Geometries.point(116.11D, 31.11D))
                .toBlocking().toIterable();
    }
}
