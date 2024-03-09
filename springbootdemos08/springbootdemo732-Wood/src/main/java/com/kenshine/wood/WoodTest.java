package com.kenshine.wood;

import com.kenshine.wood.dao.UserDao;
import com.kenshine.wood.model.User;
import org.junit.Test;
import org.noear.wood.DbContext;
import org.noear.wood.DbTableQuery;
import org.noear.wood.WoodConfig;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname WoodDemo
 * @Description 入门实例
 * @Date 2024-03-09 8:37
 * @modified By：
 * @version: 1.0$
 */
public class WoodTest {

    /**
     * 1.实例化上下文
     */
    @Test
    public void test01() throws IOException {
        DbContext db  = new DbContext("user","jdbc:mysql://127.0.0.1:3306/springboot05","root","123456");
        // 如果是动态创建，临时用的。用完要关掉
        db.close();
    }

    /**
     * 2.配置事件，执行后打印sql
     */
    @Test
    public void test02(){
        //或者使用 WoodConfig.onExecuteBef 事件
        WoodConfig.onExecuteAft(cmd -> {
            System.out.println("[Wood]" + cmd.text + "\r\n" + cmd.paramMap());
        });
    }

    /**
     * 3.多实例切换并查询
     */
    @Test
    public void test03() throws SQLException {
        new DbContext("wood","jdbc:mysql://127.0.0.1:3306/springboot05","root","123456").nameSet("a");
        new DbContext("wood","jdbc:mysql://127.0.0.1:3306/springboot05","root","123456").nameSet("b");
        User user=DbContext.use("a").table("wood").limit(1).selectItem("*", User.class);
        System.out.println(user);
    }

    /**
     * 4.mapper使用
     */
    @Test
    public void test04(){
        DbContext db  = new DbContext("wood","jdbc:mysql://127.0.0.1:3306/springboot05","root","123456");
        UserDao userDao = db.mapper(UserDao.class);
        //调用 BaseMapper 方法
        User user1 = userDao.selectById(1);
        //调用 @Sql 方法
        User user = userDao.getUser(2);
        //调用 Xml sql
        userDao.addUser(user);
        System.out.println(user);
        System.out.println(user1);
    }

    /**
     * 5.db.table 用法
     */
    @Test
    public void test05() throws SQLException {
        DbContext db  = new DbContext("user","jdbc:mysql://127.0.0.1:3306/springboot05","root","123456");
        User user = new User();
        Map map = new HashMap();
        //增::
        db.table("user").setEntity(user).insert();
        db.table("user").setMap(map).insert();
        //构建查询命令（即查询语句）
        db.table("user").setMap(map).insertAsCmd();
        //删::
        db.table("user").whereEq("id",2).delete();
        //改::
        db.table("user").set("sex",1).whereEq("id",2).update();
        //字段自+1
        db.table("user").setInc("level",1).whereEq("id",2).update();
        //查::
        db.table("user u")
                .innerJoin("user_ext e").onEq("u.id","e.user_id")
                .whereEq("u.id",1001)
                .selectItem("u.*,e.sex,e.label", User.class);

        boolean a=true;
        boolean b=true;
        //查++（折开来拼接条件）::
        DbTableQuery tb = db.table("user u");
        if(a){
            tb.innerJoin("user_ext e").onEq("u.id","e.user_id");
        }
        if(b){
            tb.whereEq("u.id",1001);
        }
        tb.selectItem("u.*,e.sex,e.label", User.class);
        //查++2（通过构建函数拼接条件）::
        db.table("user u")
                .build(tb1->{
                    if(a){
                        tb1.innerJoin("user_ext e").onEq("u.id","e.user_id");
                    }
                    if(b){
                        tb1.whereEq("u.id",1001);
                    }
                }).selectItem("u.*,e.sex,e.label", User.class);
    }

    /**
     * 6.db.call调用存储过程/xml sql
     */
    @Test
    public void test06() throws SQLException {
        DbContext db  = new DbContext("user","jdbc:mysql://127.0.0.1:3306/springboot05","root","123456");
        //调用存储过程
        db.call("user_get_list_by").set("_type",12).getList(User.class);
        //调用xml sql
        db.call("@demo.dso.db.user_get").set("id",1001).getItem(User.class);
    }

    /**
     * 7.db.sql 快速执行sql
     */
    @Test
    public void test07() throws SQLException {
        DbContext db  = new DbContext("user","jdbc:mysql://127.0.0.1:3306/springboot05","root","123456");
        //快速执行SQL语句
        db.sql("select * from user id=?",12).getItem(User.class);
    }


}
