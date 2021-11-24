package com.kenshine.hazelcast.web;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Queue;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/24 8:53
 * @description：HazelcastController
 * @modified By：
 * @version: $
 */
@Slf4j
@RestController
@RequestMapping("/hazelcast")
public class HazelcastController {
    @Autowired
    private HazelcastInstance hazelcastInstance;

    @PostMapping(value = "/save")
    public String saveMapData(@RequestParam String key, @RequestParam String value) {
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("hazelcastMap");
        hazelcastMap.put(key, value);
        return "success";
    }

    @GetMapping(value = "/get")
    public String getMapData(@RequestParam String key) {
        Map<String, String> hazelcastMap = hazelcastInstance.getMap("hazelcastMap");
        return hazelcastMap.get(key);
    }

    @GetMapping(value = "/all")
    public Map<String, String> readAllDataFromHazelcast() {
        return hazelcastInstance.getMap("hazelcastMap");
    }

    @GetMapping(value = "/list")
    public String saveList(@RequestParam(required = false) String value) {
        // 创建集群List
        IList<Object> clusterList = hazelcastInstance.getList("myList");
        clusterList.add(value);
        return "success";
    }

    @GetMapping(value = "/showList")
    public IList<Object> showList() {
        return hazelcastInstance.getList("myList");
    }

    @GetMapping(value = "/clearList")
    public String clearList() {
        IList<Object> clusterList = hazelcastInstance.getList("myList");
        clusterList.clear();
        return "success";
    }

    @GetMapping(value = "/queue")
    public String saveQueue(@RequestParam String value) {
        // 创建集群Queue
        Queue<String> clusterQueue = hazelcastInstance.getQueue("myQueue");
        clusterQueue.offer(value);
        return "success";
    }

    @GetMapping(value = "/showQueue")
    public Queue<String> showQueue() {
        Queue<String> clusterQueue = hazelcastInstance.getQueue("myQueue");
        for (String obj : clusterQueue) {
            log.warn("value=" + obj);
        }
        return clusterQueue;
    }

    @GetMapping(value = "/clearQueue")
    public String clearQueue() {
        Queue<String> clusterQueue = hazelcastInstance.getQueue("myQueue");
        clusterQueue.clear();
        return "success";
    }

}
