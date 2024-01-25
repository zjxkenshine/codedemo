package com.kenshine.j2v8;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
import org.junit.Test;

/**
 * @author by kenshine
 * @Classname J2V8Test
 * @Description j2v8使用测试
 * @Date 2024-01-25 11:06
 * @modified By：
 * @version: 1.0$
 */
public class J2V8Test {

    /**
     * 执行v8
     */
    @Test
    public void test01(){
        V8 runtime = V8.createV8Runtime();
        int result = runtime.executeIntegerScript(""
                + "var hello = 'hello, ';\n"
                + "var world = 'world!';\n"
                + "hello.concat(world).length;\n");
        System.out.println(result);
        runtime.release();
    }

    /**
     * js对象操作
     */
    @Test
    public void test02(){
        V8 runtime = V8.createV8Runtime();
        runtime.executeVoidScript(""
                + "var person = {};\n"
                + "var hockeyTeam = {name : 'WolfPack'};\n"
                + "person.first = 'Ian';\n"
                + "person['last'] = 'Bull';\n"
                + "person.hockeyTeam = hockeyTeam;\n");
        // 使用js对象
        V8Object person = runtime.getObject("person");
        V8Object hockeyTeam = person.getObject("hockeyTeam");
        System.out.println(hockeyTeam.getString("name"));
        person.release();
        hockeyTeam.release();
        runtime.release();
    }

    /**
     * v8数组
     */
    @Test
    public void test03(){
        V8 runtime = V8.createV8Runtime();
        runtime.executeVoidScript(""
                + "var person = {};\n"
                + "var hockeyTeam = {name : 'WolfPack'};\n"
                + "person.first = 'Ian';\n"
                + "person['last'] = 'Bull';\n"
                + "person.hockeyTeam = hockeyTeam;\n");
        V8Object person = runtime.getObject("person");
        V8Object hockeyTeam = person.getObject("hockeyTeam");
        V8Object player1 = new V8Object(runtime).add("name", "John");
        V8Object player2 = new V8Object(runtime).add("name", "Chris");
        V8Array players = new V8Array(runtime).push(player1).push(player2);
        hockeyTeam.add("players", players);
        player1.release();
        player2.release();
        players.release();
    }

    /**
     * 调用js方法
     */
    @Test
    public void test04(){
        V8 runtime = V8.createV8Runtime();
        runtime.executeVoidScript("      " +
                "var hockeyTeam = {\n" +
                "                name      : 'WolfPack',\n" +
                "                players   : [],\n" +
                "        addPlayer : function(player) {\n" +
                "            this.players.push(player);\n" +
                "            return this.players.size();\n" +
                "        }\n" +
                "}"
        );
        V8Object person = runtime.getObject("person");
        V8Object hockeyTeam = person.getObject("hockeyTeam");
        V8Object player1 = new V8Object(runtime).add("name", "John");
        V8Array parameters = new V8Array(runtime).push(player1);
        int size = hockeyTeam.executeIntegerFunction("addPlayer", parameters);
        System.out.println(size);
        parameters.release();
    }

}
