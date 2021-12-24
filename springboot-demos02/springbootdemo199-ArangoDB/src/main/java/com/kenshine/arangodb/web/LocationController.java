package com.kenshine.arangodb.web;

import com.arangodb.springframework.core.ArangoOperations;
import com.kenshine.arangodb.model.Location;
import com.kenshine.arangodb.repository.CharacterRepository;
import com.kenshine.arangodb.repository.ChildOfRepository;
import com.kenshine.arangodb.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Range;
import org.springframework.data.geo.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/24 23:38
 * @description： 地理位置信息相关
 * @modified By：
 * @version: $
 */
@RestController
@RequestMapping("/geo")
public class LocationController {

    @Autowired
    private ArangoOperations operations;
    @Autowired
    private CharacterRepository characterRepo;

    @Autowired
    private ChildOfRepository childOfRepo;

    @Autowired
    private LocationRepository locationRepo;

    @GetMapping("/init")
    public void init(){
        System.out.println("# Geospatial");

        locationRepo.saveAll(Arrays.asList(
                new Location("Dragonstone",     new Point(-6.815096, 55.167801)),
                new Location("King's Landing",  new Point(18.110189, 42.639752)),
                new Location("The Red Keep",    new Point(14.446442, 35.896447)),
                new Location("Yunkai",          new Point(-7.129532, 31.046642)),
                new Location("Astapor",         new Point(-9.774249, 31.50974)),
                new Location("Winterfell",      new Point(-5.581312, 54.368321)),
                new Location("Vaes Dothrak",    new Point(-6.096125, 54.16776)),
                new Location("Beyond the wall", new Point(-21.094093, 64.265473))
        ));
    }

    /**
     * 1.near 按与给定点的距离对实体进行排序
     */
    @GetMapping("/test01")
    public void test01_Near(){
        System.out.println("## Find the first 5 locations near 'Winterfell'");
        GeoPage<Location> first5 = locationRepo.findByLocationNear(new Point(-5.581312, 54.368321), PageRequest.of(0, 5));
        first5.forEach(System.out::println);

        System.out.println("## Find the next 5 locations near 'Winterfell' (only 3 locations left)");
        GeoPage<Location> next5 = locationRepo.findByLocationNear(new Point(-5.581312, 54.368321), PageRequest.of(1, 5));
        next5.forEach(System.out::println);
    }

    /**
     * 2.WithIn 在范围里面
     */
    @GetMapping("/test02")
    public void test02_WithIn(){
        System.out.println("## Find all locations within 50 kilometers of 'Winterfell'");
        GeoResults<Location> findWithing50kilometers = locationRepo
                .findByLocationWithin(new Point(-5.581312, 54.368321), new Distance(50, Metrics.KILOMETERS));
        findWithing50kilometers.forEach(System.out::println);

        System.out.println("## Find all locations which are 40 to 50 kilometers away from 'Winterfell'");
        Iterable<Location> findByLocationWithin = locationRepo.findByLocationWithin(new Point(-5.581312, 54.368321),
                Range.of(Range.Bound.inclusive(40000.), Range.Bound.exclusive(50000.)));
        findByLocationWithin.forEach(System.out::println);
    }


    /**
     * 3.搜索多边形内的位置
     */
    @GetMapping("/test03")
    public void test03_Polygon(){
        System.out.println("## Find all locations within a given polygon");
        Iterable<Location> withinPolygon = locationRepo.findByLocationWithin(
                new Polygon(Arrays.asList(new Point(-25, 40), new Point(-25, 70), new Point(25, 70))));
        withinPolygon.forEach(System.out::println);
    }


}
