package com.kenshine.designpattern.gof03_Factory.test01;

import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 0:49
 * @description：
 * @modified By：
 * @version: $
 *
 * 主要解决：主要解决接口选择的问题。
 * 何时使用：我们明确地计划不同条件下创建不同实例时。
 */
public class DBFactory {
    public DataBase getDataBase(String Type){
        if(Type == null){
            return null;
        }
        if(Type.equalsIgnoreCase("MYSQL")){
            return new Mysql();
        } else if(Type.equalsIgnoreCase("ORACLE")){
            return new Oracle();
        } else if(Type.equalsIgnoreCase("SQLSERVER")){
            return new SQLServer();
        }
        return null;
    }

    @Test
    public void test(){
        DBFactory factory = new DBFactory();
        DataBase d1= factory.getDataBase("MYSQL");
        d1.open();
        d1.close();

        DataBase d2= factory.getDataBase("ORACLE");
        d2.open();
        d2.close();

        DataBase d3= factory.getDataBase("SQLSERVER");
        d3.open();
        d3.close();
    }
}
