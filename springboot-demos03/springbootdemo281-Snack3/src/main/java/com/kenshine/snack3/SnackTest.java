package com.kenshine.snack3;

import com.kenshine.snack3.domain.OrderModel;
import com.kenshine.snack3.domain.User;
import org.junit.Test;
import org.noear.snack.ONode;
import org.noear.snack.core.Options;
import org.noear.snack.core.utils.DateUtil;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author by kenshine
 * @Classname SnackTest
 * @Description 测试
 * @Date 2023-10-19 13:03
 * @modified By：
 * @version: 1.0$
 */
public class SnackTest {

    /**
     * 基本序列化反序列化
     */
    @Test
    public void test01(){
        User user=new User(1,"kenshine");
        //demo0::字符串化
        String json = ONode.stringify(user);
        System.out.println(json);

        // 序列化 输出带@type
        String json1 = ONode.serialize(user);
        System.out.println(json1);

        // 反序列化
        // -- json 有已带@type
        User user1 = ONode.deserialize(json1);
        System.out.println(user1);
        // -- json 可以不带@type (clz 申明了)
        User user2 = ONode.deserialize(json, User.class);
        System.out.println(user2);
        // -- json 可以不带@type，泛型方式输出（类型是已知的）
        List<User> list = ONode.deserialize("[{'id':1,'name':'kenshine'}]", (new ArrayList<User>(){}).getClass());
        System.out.println(list);
    }

    /**
     * 转为ONode
     */
    @Test
    public void test02(){
        User user=new User(1,"kenshine");
        String json = "{'id':1,'nickname':'kenshine','user':{'id':2,'name':'666'},'list':[100]}";
        // 转为ONode
        ONode o1 = ONode.loadStr(json); //将json String 转为 ONode
        ONode o2 = ONode.loadObj(user); //将java Object 转为 ONode

        // 取子节点进行序列化 嵌套对象 取值转换
        User user1 = o1.get("user").toObject(User.class);
        System.out.println(user1);

        //取值
        System.out.println(o1.get("nickname").getString());
        System.out.println(o1.get("id").getInt());

        // 取值或新建并填充
        ONode o3 = o1.getOrNew("list").fill("[1,2,3,4,5,5,6]");
        System.out.println(o3);
    }

    /**
     * json path测试
     */
    @Test
    public void test03(){
        String json = "{'data':{'list':[{'id':1,'nickname':'kenshine','mobile':18712345678,'user':{'id':2,'name':'666'}}," +
                "{'id':1,'nickname':'sb','mobile':13756221289,'user':{'id':2,'name':'sb'}}]}}";
        // 转为ONode
        ONode o = ONode.loadStr(json); //将json String 转为 ONode

        //不确定返回数量的，者会返回array类型
        //找到所有的187开头的手机号，改为186，最后输出修改后的json
        String s= o.select("$..mobile[?(@ =~ /^187/)]").forEach(n->n.val("186")).toJson();
        System.out.println(s);

        //找到data.list[0]下的的mobile字段，并转为long
        long tel = o.select("$.data.list[0].mobile").getLong();
        System.out.println(tel);
        long tel1 = o.select("$.data.list[1].mobile").getLong();
        System.out.println(tel1);

        //查找所有手机号，并转为List<String>
        List<String> list = o.select("$..mobile").toObject(List.class);
        System.out.println(list);

        //查询data.list下的所有mobile，并转为List<String>
        List<String> list1 = o.select("$.data.list[*].mobile").toObject(List.class);
        System.out.println(list1);

        //找到137手机号的用户，并输出user
        User user = o.select("$.data.list[?(@.mobile =~ /^137/)]").get(0).get("user").toObject(User.class);
        System.out.println(user);

        // 输出ONode
        System.out.println(o.select("$.data.list[?(@.mobile =~ /^1/)]"));

    }

    /**
     * 遍历
     */
    @Test
    public void test04(){
        String json = "{'data':{'list':[{'id':1,'nickname':'kenshine','mobile':18712345678,'user':{'id':2,'name':'666'}}," +
                "{'id':1,'nickname':'sb','mobile':13756221289,'user':{'id':2,'name':'sb'}}]}}";
        // 转为ONode
        ONode o = ONode.loadStr(json); //将json String 转为 ONode

        //如果是个Object
        o.forEach((k,v)->{
            //...
        });
        //如果是个Array
        o.forEach((v)->{
            //...
        });
    }


    /**
     * 自定义编码
     */
    @Test
    public void test05(){
        // 自定义编码
        Options options = Options.def();
        options.addEncoder(Date.class, (data, node) -> {
            node.val().setString(DateUtil.format(data, "yyyy-MM-dd"));
        });

        // 测试
        OrderModel orderModel =new OrderModel(new Date());
        String json = ONode.loadObj(orderModel, options).toJson();
        System.out.println(json);
    }

}
