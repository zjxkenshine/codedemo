package com.kenshine.groovy.util;

import groovy.lang.Binding;
import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyShell;
import groovy.lang.Script;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.groovy.runtime.InvokerHelper;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author by kenshine
 * @Classname ScriptUtil
 * @Description script脚本工具
 * @Date 2024-04-19 13:32
 * @modified By：
 * @version: 1.0$
 *
 * 未验证
 * https://blog.csdn.net/weiwosuoai/article/details/137896668
 */
@Slf4j
public class ScriptUtil {

    /**
     * 缓存Script，避免创建太多
     */
    private static final Map<String, Script> SCRIPT_MAP =new HashMap<>();

    private static final GroovyClassLoader CLASS_LOADER = new GroovyClassLoader();

    public static Script loadScript(String key, String rule) {
        if (SCRIPT_MAP.containsKey(key)) {
            return SCRIPT_MAP.get(key);
        }
        Script script = loadScript(rule, new Binding());
        SCRIPT_MAP.put(key, script);
        return script;
    }


    public static Script loadScript(String rule, Binding binding) {
        if (StringUtils.isEmpty(rule)) {
            return null;
        }
        try {
            Class ruleClazz = CLASS_LOADER.parseClass(rule);
            if (ruleClazz != null) {
                log.info("load rule:" + rule + " success!");
                return InvokerHelper.createScript(ruleClazz, binding);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            CLASS_LOADER.clearCache();
        }
        return null;
    }

    /**
     * 调用脚本方法
     */
    public static List<JSONObject> invokeMethod(String key, String rule,String templateScript,String methodName, JSONObject configParam) {
        Script script = loadScript(key,rule);
        // 缓存脚本
        if(script==null){
            Binding groovyBinding = new Binding();
            GroovyShell groovyShell = new GroovyShell(groovyBinding);
            script = groovyShell.parse(templateScript);
            SCRIPT_MAP.put(key,script);
        }
        Object[] params = new Object[]{configParam};
        // 执行脚本并返回值
        return (List<JSONObject>) script.invokeMethod(methodName, params);
    }
}
