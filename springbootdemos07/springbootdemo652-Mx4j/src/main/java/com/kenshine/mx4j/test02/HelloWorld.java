package com.kenshine.mx4j.test02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class HelloWorld implements HelloWorldMBean {
    private int m_times;
    private Properties   m_configuration;

    public HelloWorld() {
    }

    public String getInfoFromConfiguration(String key) {
        synchronized(this) {
            return this.m_configuration.getProperty(key);
        }
    }

    @Override
    public void reloadConfiguration() throws IOException {
        String configuration = "jndi.properties";
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(configuration);
        if (is == null) {
            throw new FileNotFoundException("Cannot find " + configuration + " file in classpath");
        } else {
            Properties p = new Properties();
            p.load(is);
            synchronized(this) {
                this.m_configuration = p;
                ++this.m_times;
            }
        }
    }

    @Override
    public int getHowManyTimes() {
        return this.m_times;
    }
}