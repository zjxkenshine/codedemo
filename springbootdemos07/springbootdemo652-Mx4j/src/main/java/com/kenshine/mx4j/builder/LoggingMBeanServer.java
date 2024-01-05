package com.kenshine.mx4j.builder;

import mx4j.server.ChainedMBeanServer;
import javax.management.*;

/**
 * 测试MBeanServer
 * @author kenshine
 */
public class LoggingMBeanServer extends ChainedMBeanServer {
   @Override
   public void setMBeanServer(MBeanServer server) {
      super.setMBeanServer(server);
   }

   @Override
   public Object getAttribute(ObjectName objectName, String attribute)
      throws MBeanException, AttributeNotFoundException, InstanceNotFoundException, ReflectionException {
      Object value = super.getAttribute(objectName, attribute);
      System.out.println("[LOGGER] getAttribute() returned: " + value);
      return value;
   }
}
  