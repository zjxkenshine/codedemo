package com.kenshine.resource.demo01;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/4 22:40
 * @description：
 * @modified By：
 * @version: $
 */
public class ResourceUtil {
    public static File getResourceFile() throws FileNotFoundException {
        //Spring提供的ResourceUtils
        return ResourceUtils.getFile(
                "classpath:data/test.txt");
    }
}
