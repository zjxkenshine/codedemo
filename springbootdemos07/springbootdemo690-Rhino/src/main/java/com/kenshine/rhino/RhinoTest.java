package com.kenshine.rhino;

import org.junit.Test;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname RhinoTest
 * @Description rhino js引擎测试
 * @Date 2024-01-22 11:11
 * @modified By：
 * @version: 1.0$
 */
public class RhinoTest {

    /**
     * 执行js代码
     */
    @Test
    public void test01(){
        Context ctx = Context.enter();
        Scriptable scope=ctx.initStandardObjects();
        String jsStr = "100*20/10";
        Object result = ctx.evaluateString(scope,jsStr,null,0,null);
        System.out.println(result);
    }

    /**
     * 调用js方法
     */
    @Test
    public void test02(){
        String jsPath = "js\\test.js";
        String jsFunction = "Transfer";
        String content = "<html><head><title>测试测试</title></head><body><div>aaaa</div>html body ,hahahaha ，kenshine</body></html>";
        String baseurl = "http://www.edzh.com";

        //开始调用javascript函数
        Context cx = Context.enter();
        try {
            Scriptable scope = cx.initStandardObjects();
            cx.evaluateReader(scope, new FileReader(jsPath), "<cmd>", 1, null);

            Object fObj = scope.get(jsFunction, scope);
            if (!(fObj instanceof Function)) {
                System.out.println("找不到方法" +jsFunction);
            } else {
                Object functionArgs[] = { content, baseurl};
                Function f = (Function)fObj;
                Object result = f.call(cx, scope, scope, functionArgs);
                System.out.println("返回结果："+Context.toString(result));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Context.exit();
        }
    }

    /**
     * 访问js对象属性
     */
    @Test
    public void test03(){
        Context cx = Context.enter();
        try {
            Scriptable scope = cx.initStandardObjects();
            String jsCode = "var obj = { name: 'kenshine', age: 22 }; obj";
            Object result = cx.evaluateString(scope, jsCode, "<cmd>", 1, null);
            ScriptableObject jsObj = (ScriptableObject) result;
            String name = (String) jsObj.get("name", jsObj);
            int age = (int) jsObj.get("age", jsObj);
            System.out.println("Name: " + name + ", Age: " + age);
        } finally {
            Context.exit();
        }
    }
}
