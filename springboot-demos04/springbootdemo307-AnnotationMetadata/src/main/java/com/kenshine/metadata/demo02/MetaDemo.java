package com.kenshine.metadata.demo02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 10:53
 * @description：
 * @modified By：
 * @version: $
 */
@Repository("repositoryName")
//@Service("serviceName")
@EnableAsync
public class MetaDemo extends HashMap<String, String> implements Serializable {
    private static class InnerClass {
    }

    @Autowired
    private String getName() {
        return "demo";
    }

}
