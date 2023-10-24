package com.kenshine.fanuc;

import com.kenshine.fanuc.sdk.Fanuc;
import com.kenshine.fanuc.sdk.FanucCncAPI;
import org.json.JSONObject;

/**
 * @author by kenshine
 * @Classname ConnTest
 * @Description 连接测试
 * @Date 2023-10-24 15:01
 * @modified By：
 * @version: 1.0$
 */
public class ConnTest {
    public static void main(String[] args) {
        FanucCncAPI fanucCncAPI = new FanucCncAPI("192.168.20.103", (short) 8193,1000);
        Boolean conn=fanucCncAPI.connectCNC();
        System.out.println(conn);
        System.out.println(getF(fanucCncAPI));
    }

    private static JSONObject getF(FanucCncAPI fanucCncAPI) {
        JSONObject json = new JSONObject();
        Fanuc.ODBACT odbacts = fanucCncAPI.getF();
        json.put("time", System.currentTimeMillis());
        json.put("info", odbacts.data);
        return json;
    }

}
