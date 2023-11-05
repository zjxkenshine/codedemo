package com.kenshine.geo;

import com.github.davidmoten.geo.Coverage;
import com.github.davidmoten.geo.Direction;
import com.github.davidmoten.geo.GeoHash;
import com.github.davidmoten.geo.LatLong;
import org.junit.Test;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/5 14:59
 * @description： geohash测试
 * @modified By：
 * @version: $
 */
public class GeoTest {

    /**
     * 经纬度LatLon测试
     */
    @Test
    public void test01(){
        System.out.println(new LatLong(10, 20).toString());
    }

    /**
     * 测试geohash
     */
    @Test
    public void test02(){
        // 期望hash长度为10 纬度/经度
        String geohash=GeoHash.encodeHash(29.99129,122.21393 , 10);
        System.out.println(geohash);
        // 解码
        LatLong latLong=GeoHash.decodeHash(geohash);
        System.out.println(latLong);
        // 相邻hash 左
        String leftHash=GeoHash.adjacentHash(geohash, Direction.LEFT);
        System.out.println(GeoHash.decodeHash(leftHash));
        // 相邻hash 右 5米
        String rightHash=GeoHash.adjacentHash(geohash, Direction.RIGHT,5);
        System.out.println(GeoHash.decodeHash(rightHash));
        // 南边1米距离 类似有top,left,right等
        String bottom=GeoHash.bottom(geohash);
        System.out.println(GeoHash.decodeHash(bottom));
        // 方形范围
        Coverage coverage=GeoHash.coverBoundingBox(28.71516,118.58158,28.71465,118.58221,10);
        System.out.println(coverage);
        // 邻居
        List<String> neighbours= GeoHash.neighbours(geohash);
        System.out.println(neighbours);
    }

}
