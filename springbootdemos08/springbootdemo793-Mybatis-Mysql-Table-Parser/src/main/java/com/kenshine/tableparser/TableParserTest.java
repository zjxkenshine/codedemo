package com.kenshine.tableparser;

import com.adrninistrator.mybatis_mysql_table_parser.dto.MyBatisMySqlInfo;
import com.adrninistrator.mybatis_mysql_table_parser.entry.Entry4GetMyBatisMySqlTableDetailInfo;
import com.adrninistrator.mybatis_mysql_table_parser.entry.Entry4GetMyBatisMySqlTableInfo;
import com.adrninistrator.mybatis_mysql_table_parser.entry.Entry4GetMyBatisMySqlTableName;
import com.adrninistrator.mybatis_mysql_table_parser.entry.Entry4ParseMyBatisMySqlTable;
import org.junit.Test;

import java.util.Map;

/**
 * @author by kenshine
 * @Classname TableParserTest
 * @Description 测试table解析
 * @Date 2024-04-29 8:47
 * @modified By：
 * @version: 1.0$
 */
public class TableParserTest {

    /**
     * Entry4GetMyBatisMySqlTableDetailInfo.getDetailInfo
     * 将表名的详细信息写入文件
     */
    @Test
    public void test01(){
        Entry4GetMyBatisMySqlTableDetailInfo entry4GetMyBatisMySqlTableDetailInfo = new Entry4GetMyBatisMySqlTableDetailInfo();
        entry4GetMyBatisMySqlTableDetailInfo.getDetailInfo("src/main/resources/test", "result/test01.txt");
    }

    /**
     * Entry4GetMyBatisMySqlTableInfo.getTableInfo
     * 将表名及sql语句类型写入文件
     */
    @Test
    public void test02(){
        Entry4GetMyBatisMySqlTableInfo entry4GetMyBatisMySqlAllTables = new Entry4GetMyBatisMySqlTableInfo();
        entry4GetMyBatisMySqlAllTables.getTableInfo("src/main/resources/test", "result/test02.txt");
    }

    /**
     * Entry4GetMyBatisMySqlTableName.getTableName
     * 将表名写入文件
     */
    @Test
    public void test03(){
        Entry4GetMyBatisMySqlTableName entry4GetMyBatisMySqlAllTableName = new Entry4GetMyBatisMySqlTableName();
        entry4GetMyBatisMySqlAllTableName.getTableName("src/main/resources/test", "result/test03.txt");
    }

    /**
     * 获取解析结果到java代码中
     */
    @Test
    public void test04(){
        Entry4ParseMyBatisMySqlTable entry4ParseMyBatisMySqlTable = new Entry4ParseMyBatisMySqlTable();
        Map<String, MyBatisMySqlInfo> myBatisSqlInfoMap = entry4ParseMyBatisMySqlTable.parseDirectory("src/main/resources/test");
        MyBatisMySqlInfo myBatisSqlInfo = entry4ParseMyBatisMySqlTable.parseFile("src/main/resources/test/TestDemoMapper.xml");
        System.out.println(myBatisSqlInfo.getMapperInterfaceName());
        System.out.println(myBatisSqlInfo.getFullSqlMap());
        System.out.println(myBatisSqlInfo.getPossibleTableName());

        System.out.println(myBatisSqlInfoMap.keySet());
    }


}
