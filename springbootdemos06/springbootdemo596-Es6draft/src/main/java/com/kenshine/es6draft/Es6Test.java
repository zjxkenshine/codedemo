package com.kenshine.es6draft;

import com.github.anba.es6draft.Script;
import com.github.anba.es6draft.runtime.Realm;
import com.github.anba.es6draft.runtime.World;
import com.github.anba.es6draft.runtime.internal.RuntimeContext;
import com.github.anba.es6draft.runtime.internal.ScriptLoader;
import com.github.anba.es6draft.runtime.internal.Source;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author by kenshine
 * @Classname Es6Test
 * @Description Es6编译运行
 * @Date 2023-12-16 22:26
 * @modified By：
 * @version: 1.0$
 */
public class Es6Test {

    /**
     * 基本使用
     */
    @Test
    public void test01() throws IOException {
        // 构建runtimeContext
        RuntimeContext runtimeContext = new RuntimeContext.Builder()
                // 可以进行各种设置
                .setConsole(new SystemConsole())
                .build();
        // 设置ScriptLoader
        ScriptLoader scriptLoader = new ScriptLoader(runtimeContext);
        // 读取script
        Script script=scriptLoader.script(new Source("test01",0), Paths.get("D:\\Github\\codedemo\\springbootdemos06\\springbootdemo596-Es6draft\\src\\main\\resources\\test01.js"));
        // 执行，设置realm
        Object o =script.evaluate(new Realm(new World(runtimeContext)));
        System.out.println(o);
    }
}
