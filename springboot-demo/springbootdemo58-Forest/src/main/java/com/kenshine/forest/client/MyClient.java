package com.kenshine.forest.client;

import com.dtflys.forest.annotation.DecompressGzip;
import com.dtflys.forest.annotation.Request;

/**
 * @author ：kenshine
 * @date ：Created in 2021/11/4 22:04
 * @description：Hello World
 * @modified By：
 * @version: $
 *
 * //@DecompressGzip 增加gzip解压能力
 */
@DecompressGzip
public interface MyClient {

    /**
     * 可以用@GetRequest, @PostRequest等注解代替@Request注解
     * @return
     */
    @Request("http://localhost:8080/hello")
    String helloForest();

}
