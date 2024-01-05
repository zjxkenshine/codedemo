package com.kenshine.mx4j.test03;

public interface MyRemoteServiceObjectMBean {
    void start() throws Exception;

    void stop() throws Exception;

    boolean isRunning();
}
