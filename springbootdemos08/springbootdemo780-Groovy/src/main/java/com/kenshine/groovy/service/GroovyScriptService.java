package com.kenshine.groovy.service;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @author kenshine
 * 执行外部脚本
 */
@Service
public class GroovyScriptService {

    private final GroovyClassLoader groovyClassLoader;

    public GroovyScriptService() {
        this.groovyClassLoader = new GroovyClassLoader(getClass().getClassLoader());
    }

    /**
     * 路径加载执行
     */
    public Object executeScript(String scriptPath) throws IOException, IllegalAccessException, InstantiationException {
        Class<?> groovyClass = groovyClassLoader.parseClass(new File(scriptPath));
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
        return groovyObject.invokeMethod("execute", null);
    }

    /**
     * 资源文件加载执行
     */
    public Object executeScriptFromResource(String resourceName) throws IOException, IllegalAccessException, InstantiationException {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(resourceName);
        if (inputStream == null) {
            throw new FileNotFoundException("Groovy script not found: " + resourceName);
        }
        Reader reader = new InputStreamReader(inputStream);
        Class<?> groovyClass = new GroovyClassLoader(getClass().getClassLoader()).parseClass(reader,"test");
        GroovyObject groovyObject = (GroovyObject) groovyClass.newInstance();
        return groovyObject.invokeMethod("execute", null);
    }

}