package jsqlTest;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.MultiExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.util.SelectUtils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/11 10:26
 * @description：测试集1 基本使用 构建增删改查sql
 * @modified By：
 * @version: $
 */
public class JSqlParserTest01 {

    /**
     * SQL转换为Select对象
     */
    @Test
    public void test01_Select() throws JSQLParserException {
        // 使用工具类把SQL转换为Select对象
        Select select = (Select) CCJSqlParserUtil.parse("SELECT username,age,sex FROM user");
        SelectBody selectBody = select.getSelectBody();
        System.out.println(selectBody);
    }

    
    /**
     * 简单的构建单表查询
     */
    @Test
    public void buildSelectSql() throws JSQLParserException {
        Select select01 = SelectUtils.buildSelectFromTable(new Table("test"));
        System.out.println(select01.getSelectBody().toString()); // SELECT * FROM test

        Select select02 = SelectUtils.buildSelectFromTableAndExpressions(new Table("test"), new Column("col1"), new Column("col2"));
        System.out.println(select02.getSelectBody().toString()); // SELECT col1, col2 FROM test

        Select select03 = SelectUtils.buildSelectFromTableAndExpressions(new Table("mytable"), "col1", "col2");
        System.out.println(select03.getSelectBody().toString()); // SELECT col1, col2 FROM mytable
    }

    /**
     * 构建插入语句
     */
    @Test
    public void buildInsertSql() {
        // 创建表对象设置表名
        Table table = new Table();
        table.setName("table");

        // 创建插入对象
        Insert insert = new Insert();
        insert.setTable(table); // 设置插入对象的表对象

        // 设置插入列
        List<Column> columnList = Arrays.asList(new Column("col01"), new Column("col02"));
        insert.setColumns(columnList);

        // 设置插入值
        MultiExpressionList multiExpressionList = new MultiExpressionList();
        multiExpressionList.addExpressionList(Arrays.asList(new StringValue("1"), new StringValue("2")));
        insert.setItemsList(multiExpressionList);

        System.out.println(insert); // INSERT INTO table (col01, col02) VALUES ('1', '2')
    }

    /**
     * 构建更新语句
     */
    @Test
    public void buildUpdateSql() {
        // 创建表对象设置表名
        Table table = new Table();
        table.setName("table");

        // 创建更新对象
        Update update = new Update();
        update.setTable(table);// 设置更新对象的表对象

        // 设置更新列
        List<Column> columnList = Arrays.asList(new Column("col01"), new Column("col02"));
        update.setColumns(columnList);

        // 设置更新值
        update.setExpressions(Arrays.asList(new StringValue("1"), new StringValue("2")));

        // 添加Where条件
        EqualsTo equalsTo = new EqualsTo(); // 等于表达式
        equalsTo.setLeftExpression(new Column(table,"user_id")); // 设置表达式左边值
        equalsTo.setRightExpression(new StringValue("123456"));// 设置表达式右边值
        update.setWhere(equalsTo); // 设置Where

        System.out.println(update);
    }


    /**
     * 构建删除语句
     */
    @Test
    public void buildDeleteSql() {
        // 创建表对象设置表名
        Table table = new Table();
        table.setName("table");
        //设置别名
        table.setAlias(new Alias("a"));


        // 删除
        Delete delete = new Delete();
        delete.setTable(table);// 设置更新对象的表对象

        // 添加Where条件
        EqualsTo equalsTo = new EqualsTo(); // 等于表达式
        equalsTo.setLeftExpression(new Column(table,"user_id")); // 设置表达式左边值
        equalsTo.setRightExpression(new StringValue("123456"));// 设置表达式右边值
        delete.setWhere(equalsTo); // 设置Where

        // 输入语句
        System.out.println(delete);
    }





}
