package com.kenshine.mx4j.builder;

import mx4j.server.ChainedMBeanServerBuilder;

import javax.management.MBeanServer;
import javax.management.MBeanServerDelegate;

/**
 * MBeanServerBuilder MBeanServer构建器
 * @author kenshine
 */
public class LoggingBuilder extends ChainedMBeanServerBuilder {
   public LoggingBuilder() {
      // 可以链式调用多个Builder
      super(new mx4j.server.MX4JMBeanServerBuilder());
   }

   /**
    * 创建MBeanServer
    */
   @Override
   public MBeanServer newMBeanServer(String defaultDomain, MBeanServer outer, MBeanServerDelegate delegate) {
      LoggingMBeanServer extern = new LoggingMBeanServer();
      MBeanServer nested = getMBeanServerBuilder().newMBeanServer(defaultDomain, outer == null ? extern : outer, delegate);
      extern.setMBeanServer(nested);
      return extern;
   }
}