package com.kenshine.tair;

import com.alibaba.fastjson.JSON;
import com.taobao.tair.DataEntry;
import com.taobao.tair.Result;
import com.taobao.tair.ResultCode;
import com.taobao.tair.impl.DefaultTairManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author by kenshine
 * @Classname TairTest
 * @Description tair使用测试
 * @Date 2024-05-28 9:43
 * @modified By：
 * @version: 1.0$
 */
public class TairTest {

    public static void main(String[] args) {
        List<String> configList = new ArrayList<>();
        //ConfigServer的ip和端口
        configList.add("192.168.1.122:5198");
        DefaultTairManager tairManager = new DefaultTairManager();
        tairManager.setConfigServerList(configList);
        tairManager.setTimeout(5000);
        tairManager.setCharset("utf-8");
        //和配置中的组名称保持一致
        tairManager.setGroupName("group_test");
        tairManager.init();
        //put数据
        ResultCode putResult = tairManager.put(1,"name","tairtest");
        System.out.println("putResult:"+putResult);
        System.out.println("putResult:"+ JSON.toJSONString(putResult));
        //get数据
        Result<DataEntry> getResult = tairManager.get(1, "name");
        System.out.println("getResult:"+getResult);
        System.out.println("getResult:"+JSON.toJSONString(putResult));
        DataEntry dataEntry = getResult.getValue();
        System.out.println(JSON.toJSONString(dataEntry));
        //删除数据
        ResultCode delResult = tairManager.delete(1,"name");
        System.out.println("delResult:"+JSON.toJSONString(delResult));
        //获取数据
        Result<DataEntry> getResult2 = tairManager.get(1,"name");
        System.out.println("getResult:"+getResult2);
    }
}
