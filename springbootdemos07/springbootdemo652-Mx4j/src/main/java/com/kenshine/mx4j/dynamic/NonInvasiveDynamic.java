package com.kenshine.mx4j.dynamic;

import mx4j.AbstractDynamicMBean;

import javax.management.*;

/**
 * AbstractDynamicMBean 子类
 * @author kenshine
 */
public class NonInvasiveDynamic extends AbstractDynamicMBean {
//   protected MBeanOperationInfo[] createMBeanOperationInfo()
//   {
//      return new MBeanOperationInfo[]
//      {
//         new MBeanOperationInfo("start", "Starts this MBean", new MBeanParameterInfo[0], Void.class.getName(), MBeanOperationInfo.ACTION),
//         new MBeanOperationInfo("stop", "Stops this MBean", new MBeanParameterInfo[0], Void.class.getName(), MBeanOperationInfo.ACTION)
//      };
//   }
//
//   protected String getMBeanDescription(){
//      return "A non invasive DynamicMBean that manages resource";
//   }
//
//   public NonInvasiveDynamic(ExternalService service){
//      // Set the actual resource that this MBean represents.
//      setresource(service);
//   }
//
//   public static void main(String[] args) throws Exception {
//      // Create the service
//      ExternalService service = new ExternalService();
//
//      MBeanServer server = MBeanServerFactory.createMBeanServer();
//      NonInvasiveDynamic mbean = new NonInvasiveDynamic(service);
//      ObjectName name = new ObjectName("domain:key=value");
//      server.registerMBean(mbean, name);
//      server.invoke(name, "start", null, null);
//   }
}