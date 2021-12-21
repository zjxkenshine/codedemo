package com.kenshine.dbunit.db;

import com.kenshine.dbunit.DBUnitApp;
import org.dbunit.DatabaseUnitException;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlProducer;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.operation.DatabaseOperation;
import org.xml.sax.InputSource;

import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/21 8:45
 * @description：基类 与DBUnitUtils作用相同
 * @modified By：
 * @version: $
 */
public class AbstractDbunitTestCase {
    // 封装的链接对象
    private DatabaseConnection conn;

    // 临时文件
    private File tempFile;

    private IDataSet dataSet;

    public AbstractDbunitTestCase(String testDataName) throws DatabaseUnitException {
        dataSet = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(AbstractDbunitTestCase.class.getClassLoader().getResourceAsStream(testDataName))));
    }

    /**
     * 初始化DatabaseConnection
     * @param connection
     * @throws DatabaseUnitException
     */
    public void setConn(Connection connection) throws DatabaseUnitException {
        //Mysql连接 db4数据库名
        this.conn = new MySqlConnection(connection,"db4");
    }

    /**
     * 备份多个表
     * @param tabNames
     */
    public void backManyTable(String... tabNames) throws DataSetException, IOException {
        QueryDataSet dataSet = new QueryDataSet(conn);
        // 设置要备份的表
        for (String tabName : tabNames) {
            dataSet.addTable(tabName);
        }
        tempFile = new File("src/main/resources/dump/back.xml");

        //备份到back.xml文件
        FlatXmlDataSet.write(dataSet, new FileOutputStream(tempFile));
    }

    /**
     * 备份一张表
     * @param tabName
     */
    public void backOneTable(String tabName) throws IOException, DataSetException {
        backManyTable(tabName);
    }

    /**
     * 插入测试数据
     */
    public void insertTestData() throws DatabaseUnitException, SQLException {
        DatabaseOperation.CLEAN_INSERT.execute(conn,dataSet);
    }

    /**
     * 还原表数据
     */
    public void resumeTable() throws DatabaseUnitException, SQLException, FileNotFoundException {
        IDataSet dataSet = new FlatXmlDataSet(new FlatXmlProducer(new InputSource(new FileInputStream(tempFile))));
        DatabaseOperation.CLEAN_INSERT.execute(conn,dataSet);
    }

}
