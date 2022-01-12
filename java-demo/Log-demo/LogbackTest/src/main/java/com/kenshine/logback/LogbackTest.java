package com.kenshine.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
    public static final Logger logger= LoggerFactory.getLogger(LogbackTest.class);

    @Test
    public void quickStart(){
        logger.error("error");
        logger.warn("warn");
        logger.info("info");
        logger.debug("debug");
        logger.trace("trace");

    }
}
