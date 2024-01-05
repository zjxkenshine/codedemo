package com.kenshine.mx4j.test02;

import java.io.IOException;

/**
 * @author kenshine
 */
public interface HelloWorldMBean {
    void reloadConfiguration() throws IOException;

    int getHowManyTimes();
}