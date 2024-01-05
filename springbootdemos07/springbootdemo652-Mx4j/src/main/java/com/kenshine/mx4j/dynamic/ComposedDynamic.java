package com.kenshine.mx4j.dynamic;

import mx4j.AbstractDynamicMBean;

import javax.management.*;

/**
 * 委派到AbstractDynamicMBean子类
 * @author kenshine
 */
public class ComposedDynamic extends MyBaseClass implements DynamicMBean {

   /* AbstractDynamicMBean子类进行委托*/
   private AbstractDynamicMBean delegate = new AbstractDynamicMBean() {
      @Override
      protected MBeanAttributeInfo[] createMBeanAttributeInfo() {
         return new MBeanAttributeInfo[]{
            new MBeanAttributeInfo("Status", int.class.getName(), "The status", true, true, false),
            new MBeanAttributeInfo("Enabled", boolean.class.getName(), "The enable status", true, false, true)
         };
      }

      @Override
      protected MBeanOperationInfo[] createMBeanOperationInfo()
      {
         return new MBeanOperationInfo[]
         {
            new MBeanOperationInfo("enable", "Enables this MBean", new MBeanParameterInfo[0], Void.class.getName(), MBeanOperationInfo.ACTION),
            new MBeanOperationInfo("disable", "Disables this MBean", new MBeanParameterInfo[0], Void.class.getName(), MBeanOperationInfo.ACTION)
         };
      }
   };

   private int status;
   private boolean enabled;

   public ComposedDynamic() {
      // Set the actual resource
      delegate.setResource(this);
   }

   /* Implement the methods of DynamicMBean interface to delegate to the AbstractDynamicMBean subclass */
   @Override
   public Object getAttribute(String attribute) throws AttributeNotFoundException, MBeanException, ReflectionException
   {
      return delegate.getAttribute(attribute);
   }

   @Override
   public void setAttribute(Attribute attribute) throws AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {

   }

   @Override
   public AttributeList getAttributes(String[] attributes) {
      return null;
   }

   @Override
   public AttributeList setAttributes(AttributeList attributes) {
      return null;
   }

   @Override
   public Object invoke(String actionName, Object[] params, String[] signature) throws MBeanException, ReflectionException {
      return null;
   }

   @Override
   public MBeanInfo getMBeanInfo() {
      return null;
   }


   public void setStatus(int status)
   {
      this.status = status;
   }

   public int getStatus()
   {
      return status;
   }

   public boolean isEnabled()
   {
      return this.enabled;
   }

   public void enable()
   {
      this.enabled = true;
   }

   public void disable()
   {
      this.enabled = false;
   }
}