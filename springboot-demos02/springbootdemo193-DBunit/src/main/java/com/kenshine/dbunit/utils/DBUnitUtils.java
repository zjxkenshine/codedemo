package com.kenshine.dbunit.utils;

import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatDtdDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

import java.io.File;
import java.io.FileOutputStream;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/21 9:34
 * @description：DBUnit工具类
 * @modified By：
 * @version: $
 */
public class DBUnitUtils {

    //产生数据集
    public static void generateDatasetDtd(String[] tables) throws Exception{
        QueryDataSet dataSet=new QueryDataSet(DButils.getDataBaseConnection());
        for(String _table:tables){
            dataSet.addTable(_table);
        }
        FlatDtdDataSet.write(dataSet, new FileOutputStream(new File("resource/tmp.dtd")));
        //FlatXmlDataSet.write(dataSet,new FileOutputStream(new File("resource/dbunit1.xml")));
    }

    //备份表数据
    public static void backupDatabase(String[] tables, File backupFile) throws Exception{
        QueryDataSet dataSet=new QueryDataSet(DButils.getDataBaseConnection());
        for(String _table:tables){
            dataSet.addTable(_table);
        }
        FlatXmlDataSet.write(dataSet, new FileOutputStream(backupFile));
    }

    //清空表数据，并导入测试数据
    public static void importTables(File dataFile) throws Exception{
        IDataSet dataSet=new FlatXmlDataSetBuilder().build(dataFile);
        DatabaseOperation.CLEAN_INSERT.execute(DButils.getDataBaseConnection(), dataSet);
    }

    //清空表数据，恢复备份数据
    public static void resumeDatabase(File backupFile) throws Exception{
        IDataSet dataSet=new FlatXmlDataSetBuilder().build(backupFile);
        DatabaseOperation.CLEAN_INSERT.execute(DButils.getDataBaseConnection(), dataSet);
    }
}
