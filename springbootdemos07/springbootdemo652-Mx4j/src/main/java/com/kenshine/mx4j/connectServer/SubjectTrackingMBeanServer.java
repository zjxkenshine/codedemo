package com.kenshine.mx4j.connectServer;

import javax.management.*;
import javax.management.loading.ClassLoaderRepository;
import javax.management.remote.MBeanServerForwarder;
import javax.security.auth.Subject;
import java.io.ObjectInputStream;
import java.security.AccessController;
import java.util.Set;

/**
 * 简单Subject拦截
 */
public class SubjectTrackingMBeanServer implements MBeanServerForwarder{
   private MBeanServer server;

   @Override
   public synchronized MBeanServer getMBeanServer()
   {
      return server;
   }

   @Override
   public synchronized void setMBeanServer(MBeanServer server) throws IllegalArgumentException
   {
      if (server == null) throw new IllegalArgumentException("Cannot forward to a null MBeanServer");
      this.server = server;
   }

   private void trackSubject()
   {
      Subject subject = Subject.getSubject(AccessController.getContext());
      System.out.println("Subject = " + subject);
   }

   @Override
   public ObjectInstance createMBean(String className, ObjectName name) throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException, NotCompliantMBeanException {
      return null;
   }

   @Override
   public ObjectInstance createMBean(String className, ObjectName name, ObjectName loaderName) throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException, NotCompliantMBeanException, InstanceNotFoundException {
      return null;
   }

   @Override
   public ObjectInstance createMBean(String className, ObjectName name, Object[] params, String[] signature) throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException, NotCompliantMBeanException {
      return null;
   }

   @Override
   public ObjectInstance createMBean(String className, ObjectName name, ObjectName loaderName, Object[] params, String[] signature) throws ReflectionException, InstanceAlreadyExistsException, MBeanRegistrationException, MBeanException, NotCompliantMBeanException, InstanceNotFoundException {
      return null;
   }

   @Override
   public ObjectInstance registerMBean(Object object, ObjectName name) throws InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
      return null;
   }

   @Override
   public void unregisterMBean(ObjectName name) throws InstanceNotFoundException, MBeanRegistrationException {

   }

   @Override
   public ObjectInstance getObjectInstance(ObjectName name) throws InstanceNotFoundException {
      return null;
   }

   @Override
   public Set<ObjectInstance> queryMBeans(ObjectName name, QueryExp query) {
      return null;
   }

   @Override
   public Set<ObjectName> queryNames(ObjectName name, QueryExp query) {
      return null;
   }

   @Override
   public boolean isRegistered(ObjectName name) {
      return false;
   }

   @Override
   public Integer getMBeanCount() {
      return null;
   }

   @Override
   public Object getAttribute(ObjectName name, String attribute) throws MBeanException, AttributeNotFoundException, InstanceNotFoundException, ReflectionException {
      return null;
   }

   @Override
   public AttributeList getAttributes(ObjectName name, String[] attributes) throws InstanceNotFoundException, ReflectionException {
      return null;
   }

   @Override
   public void setAttribute(ObjectName name, Attribute attribute) throws InstanceNotFoundException, AttributeNotFoundException, InvalidAttributeValueException, MBeanException, ReflectionException {

   }

   @Override
   public AttributeList setAttributes(ObjectName name, AttributeList attributes) throws InstanceNotFoundException, ReflectionException {
      return null;
   }

   @Override
   public Object invoke(ObjectName name, String operationName, Object[] params, String[] signature) throws InstanceNotFoundException, MBeanException, ReflectionException {
      return null;
   }

   @Override
   public String getDefaultDomain() {
      return null;
   }

   @Override
   public String[] getDomains() {
      return new String[0];
   }

   @Override
   public void addNotificationListener(ObjectName observed, NotificationListener listener, NotificationFilter filter, Object handback)
           throws InstanceNotFoundException
   {
      trackSubject();
      getMBeanServer().addNotificationListener(observed, listener, filter, handback);
   }

   @Override
   public void addNotificationListener(ObjectName name, ObjectName listener, NotificationFilter filter, Object handback) throws InstanceNotFoundException {

   }

   @Override
   public void removeNotificationListener(ObjectName name, ObjectName listener) throws InstanceNotFoundException, ListenerNotFoundException {

   }

   @Override
   public void removeNotificationListener(ObjectName name, ObjectName listener, NotificationFilter filter, Object handback) throws InstanceNotFoundException, ListenerNotFoundException {

   }

   @Override
   public void removeNotificationListener(ObjectName name, NotificationListener listener) throws InstanceNotFoundException, ListenerNotFoundException {

   }

   @Override
   public void removeNotificationListener(ObjectName name, NotificationListener listener, NotificationFilter filter, Object handback) throws InstanceNotFoundException, ListenerNotFoundException {

   }

   @Override
   public MBeanInfo getMBeanInfo(ObjectName name) throws InstanceNotFoundException, IntrospectionException, ReflectionException {
      return null;
   }

   @Override
   public boolean isInstanceOf(ObjectName name, String className) throws InstanceNotFoundException {
      return false;
   }

   @Override
   public Object instantiate(String className) throws ReflectionException, MBeanException {
      return null;
   }

   @Override
   public Object instantiate(String className, ObjectName loaderName) throws ReflectionException, MBeanException, InstanceNotFoundException {
      return null;
   }

   @Override
   public Object instantiate(String className, Object[] params, String[] signature) throws ReflectionException, MBeanException {
      return null;
   }

   @Override
   public Object instantiate(String className, ObjectName loaderName, Object[] params, String[] signature) throws ReflectionException, MBeanException, InstanceNotFoundException {
      return null;
   }

   @Override
   public ObjectInputStream deserialize(ObjectName name, byte[] data) throws InstanceNotFoundException, OperationsException {
      return null;
   }

   @Override
   public ObjectInputStream deserialize(String className, byte[] data) throws OperationsException, ReflectionException {
      return null;
   }

   @Override
   public ObjectInputStream deserialize(String className, ObjectName loaderName, byte[] data) throws InstanceNotFoundException, OperationsException, ReflectionException {
      return null;
   }

   @Override
   public ClassLoader getClassLoaderFor(ObjectName mbeanName) throws InstanceNotFoundException {
      return null;
   }

   @Override
   public ClassLoader getClassLoader(ObjectName loaderName) throws InstanceNotFoundException {
      return null;
   }

   @Override
   public ClassLoaderRepository getClassLoaderRepository() {
      return null;
   }
}