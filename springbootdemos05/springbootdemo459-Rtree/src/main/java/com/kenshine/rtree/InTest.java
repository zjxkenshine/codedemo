package com.kenshine.rtree;

import com.github.davidmoten.rtree.Entry;
import com.github.davidmoten.rtree.RTree;
import com.github.davidmoten.rtree.geometry.Geometries;
import com.github.davidmoten.rtree.geometry.Line;
import com.github.davidmoten.rtree.geometry.Point;
import com.github.davidmoten.rtree.geometry.Rectangle;
import org.junit.Test;

import java.util.*;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/5 21:41
 * @description：测试
 * @modified By：
 * @version: $
 */
public class InTest {
    //北京市东城区和西城区的边界，这里只展示部分数据，非完全边界数据
    private static String dongcheng = "MULTIPOLYGON ((116.38059 39.871148,116.399097 39.872205,116.397612 39.898675,1116.38059 39.871148))";
    private static String xicheng = "MULTIPOLYGON ((116.387658 39.96093,116.38678 39.957014,116.393346 39.957355,116.387658 39.96093))";

    private RTree<String, Rectangle> secondTree = RTree.minChildren(3).maxChildren(6).create();

    private static Map<String,String> localShapeCache=new HashMap<>();

    static {
        localShapeCache.put("dongcheng",dongcheng);
        localShapeCache.put("xicheng",xicheng);
    }

    /**
     * 构建多边形 外接矩形
     */
    public void build() {
        List<CityDTO> sourceData = buildCityDTOs();
        //1.对每个多边形,存入所有边构建一级R树
        for (CityDTO sourceDatum : sourceData) {
            RTree<String, Line> tree = RTree.minChildren(3).maxChildren(6).create();
            List<List<Double>> polygon = GeoHelper.transfer2List(sourceDatum.getShape());
            for (int i = 0; i < polygon.size(); i++) {
                List<Double> nextPoints = polygon.get((i + 1) % polygon.size());
                List<Double> points = polygon.get(i);
                Double lng1 = points.get(0);
                Double lat1 = points.get(1);
                Double lng2 = nextPoints.get(0);
                Double lat2 = nextPoints.get(1);
                tree = tree.add(String.valueOf(i), Geometries.line(lng1, lat1, lng2, lat2));
            }
            //2. 将每个多边形的外接矩形构造为二级R树
            secondTree = secondTree.add(sourceDatum.getName(), tree.mbr().get());
        }
    }

    private List<CityDTO> buildCityDTOs() {
        return Arrays.asList(new CityDTO("dongcheng",dongcheng),
                new CityDTO("xicheng",xicheng));
    }

    /**
     * 搜索
     * 输入点坐标，查询命中的多边形name
     * @param lng
     * @param lat
     * @return
     */
    public String search(Double lng, Double lat) {
        build();
        Point point = Geometries.point(lng, lat);
        //r树粗筛一遍
        Iterator<Entry<String, Rectangle>> iterator = secondTree.search(point).toBlocking().toIterable().iterator();
        //射线法对粗筛的多边形精确计算
        while (iterator.hasNext()) {
            Entry<String, Rectangle> entry = iterator.next();
            String name = entry.value();
            //获取多边形wkt边界数据
            String wkt = localShapeCache.get(name);
            //射线法判断
            PointDTO p = new PointDTO();
            p.setLng(lng);
            p.setLat(lat);
            if (isInPolygon(p, GeoHelper.transfer2List(wkt))) {
                return name;
            }
        }
        return null;
    }

    /**
     * 射线法判断点是否在多边形内
     * @param pointDTO
     * @param polygon
     * @return
     */
    private boolean isInPolygon(PointDTO pointDTO, List<List<Double>> polygon) {
        int nCross = 0;
        for (int i = 0; i < polygon.size(); i++) {
            List<Double> p1 = polygon.get(i);
            List<Double> p2 = polygon.get((i + 1) % polygon.size());
            Double lng1 = p1.get(0);
            Double lat1 = p1.get(1);
            Double lng2 = p2.get(0);
            Double lat2 = p2.get(1);
            //p1p2 与 y = p0.y平行
            if (lng1.equals(lng2)) {
                continue;
            }
            //交点在p1p2的延长线上
            if (pointDTO.getLng() < Math.min(lng1, lng2)) {
                continue;
            }
            //交点在p1p2的延长线上
            if (pointDTO.getLng() >= Math.max(lng1, lng2)) {
                continue;
            }
            // 求交点的X坐标
            double x = (pointDTO.getLng() - lng1) * (lat2 - lat1) / (lng2 - lng1) + lat1;
            if (x > pointDTO.getLat()) {
                //只统计单边
                nCross++;
            }
        }
        //单边交点为奇数，点在多边形内
        return (nCross % 2 == 1);
    }

    /**
     * 获取多边形的外接矩形
     * @param wkt
     * @return
     */
    public Rectangle buildRectFromWkt(String wkt) {
        double minLng = 180.00;
        double minLat = 90;
        double maxLng = -180.00;
        double maxLat = -90.00;
        //wkt格式数据转为点 list
        List<List<Double>> polygon = GeoHelper.transfer2List(wkt);
        for (List<Double> points : polygon) {
            Double lng = points.get(0);
            Double lat = points.get(1);
            if (lng < minLng) {
                minLng = lng;
            }
            if (lng > maxLng) {
                maxLng = lng;
            }
            if (lat < minLat) {
                minLat = lat;
            }
            if (lat > maxLat) {
                maxLat = lat;
            }
        }
        return Geometries.rectangle(minLng, minLat, maxLng, maxLat);
    }

    @Test
    public void test(){
        System.out.println(this.search(116.387658,39.96093));
    }

}
