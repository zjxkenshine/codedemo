package com.kenshine.rtree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/5 21:48
 * @description：
 * @modified By：
 * @version: $
 */
public class GeoHelper {
    // wkt数据转list
    // MULTIPOLYGON ((-79.9767 40.4887, -79.9718 40.4885, -79.9717 40.4888, -79.9722 40.4889, -79.9727 40.4883))
    public static List<List<Double>> transfer2List(String wkt) {
        String sa1 = wkt.replaceAll("MULTIPOLYGON ","");
        String sa2 = sa1.replaceAll("[()]","");
        String sa3 = sa2.replaceAll(", ","#");
        String sa4 = sa3.replaceAll(" ",",");
        String[] splitString = sa4.split( "#" );
        List<List<Double>> list = new ArrayList<>();
        for (String point : splitString ) {
            String[] latLon=point.split(",");
            List<Double> list1=new ArrayList<>();
            list1.add(Double.parseDouble(latLon[0]));
            list1.add(Double.parseDouble(latLon[1]));
            list.add(list1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(transfer2List("MULTIPOLYGON ((-79.9767 40.4887, -79.9718 40.4885, -79.9717 40.4888, -79.9722 40.4889, -79.9727 40.4883))"));
    }
}
