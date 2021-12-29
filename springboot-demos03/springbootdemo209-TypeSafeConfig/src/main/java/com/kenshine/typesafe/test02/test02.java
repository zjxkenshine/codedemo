package com.kenshine.typesafe.test02;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigValue;

import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/29 10:23
 * @description：测试02
 * @modified By：
 * @version: $
 */
public class test02 {
    public static void main(String[] args) {
        Config conf = ConfigFactory.load();

        for (Config config : conf.getConfigList("battleserver")) {
            System.out.println(config.getInt("id"));
            System.out.println(config.getString("ip"));
            System.out.println(config.getInt("port"));
        }

        System.out.println(conf.getString("login.db.driver"));
        System.out.println(conf.getString("login.db.url"));
        System.out.println(conf.getString("login.db.activeConn"));

        for (Map.Entry<String, ConfigValue> entry : conf.getConfig("res.android").entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().valueType() + " " + entry.getValue().unwrapped());

        }

        for (Map.Entry<String, ConfigValue> entry : conf.getConfig("whitelist.member").entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().valueType() + " " + entry.getValue().unwrapped());

        }

        System.out.println(conf.getString("company_ip"));

        System.out.println(conf.getString("lobbyserver.ip"));
        System.out.println(conf.getString("lobbyserver.port"));
        System.out.println(conf.getString("lobbyserver.rpc"));
    }
}
