package com.kenshine.designpattern.gof03_Factory.test01;

import org.junit.Test;

import javax.lang.model.type.UnknownTypeException;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/7 0:54
 * @description：
 * @modified By：
 * @version: $
 */
public class DBFactory2 {
    enum DatabaseType{
        MYSQL,
        SQLSERVER,
        ORACLE
    }
    public DataBase getDataBase(DatabaseType type){
        switch(type){
            case MYSQL:
                return new Mysql();
            case ORACLE:
                return new Oracle();
            case SQLSERVER:
                return new SQLServer();
            default:
                throw new UnknownTypeException(null,type);
        }
    }

    @Test
    public void test(){
        DBFactory2 factory = new DBFactory2();
        DataBase d1= factory.getDataBase(DatabaseType.MYSQL);
        d1.open();
        d1.close();

        DataBase d2= factory.getDataBase(DatabaseType.ORACLE);
        d2.open();
        d2.close();

        DataBase d3= factory.getDataBase(DatabaseType.SQLSERVER);
        d3.open();
        d3.close();
    }

}
