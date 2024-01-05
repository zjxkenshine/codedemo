package com.kenshine.mx4j.test01;

import mx4j.log.Log;
import mx4j.log.Logger;
import org.junit.Test;

import javax.management.*;
import javax.management.relation.RelationServiceMBean;
import javax.management.relation.Role;
import javax.management.relation.RoleList;
import javax.management.relation.RoleResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author by kenshine
 * @Classname RelationServiceExample
 * @Description 关系服务
 * @Date 2024-01-05 17:26
 * @modified By：
 * @version: 1.0$
 */
public class RelationServiceExample {
    private MBeanServer m_server = null;
    private RelationServiceMBean m_proxy = null;
    private String m_relationServiceClass = "javax.management.relation.RelationService";
    private String m_libraryClassName = "com.kenshine.mx4j.test01.SimplePersonalLibrary";
    private ObjectName m_libraryObjectName = null;
    private ObjectName m_relationObjectName = null;
    private SimplePersonalLibrary m_library = null;

    public RelationServiceExample() {
        this.m_server = MBeanServerFactory.createMBeanServer("RelationExample");
    }

    public void setUpRelations() {
        try {
            System.out.println("Creating RelationService in the MBeanServer");
            Object[] params = new Object[]{Boolean.TRUE};
            String[] signature = new String[]{"boolean"};
            this.m_relationObjectName = new ObjectName("relations:class=" + this.m_relationServiceClass);
            this.m_server.createMBean(this.m_relationServiceClass, this.m_relationObjectName, null, params, signature);
            this.m_proxy = MBeanServerInvocationHandler.newProxyInstance(this.m_server, this.m_relationObjectName, RelationServiceMBean.class, false);
            System.out.println("----------------------- done ----------------------------");
            System.out.println("create the relationType");
            String libraryTypeName = "personal_library";
            this.m_library = new SimplePersonalLibrary(libraryTypeName);
            this.addRelationType();
            this.printRelationTypeInfo();
            System.out.println("----------------------- done ----------------------------");
            System.out.println("create RelationId for the relationType");
            String personalLibraryId = libraryTypeName + "_internal";
            System.out.println("----------------------- done ----------------------------");
            String ownerClassName = "com.kenshine.mx4j.test01.SimpleOwner";
            String bookClassName = "com.kenshine.mx4j.test01.SimpleBooks";
            System.out.println("Creating MBeans to represent our relations");
            ObjectName ownerName1 = new ObjectName("library:name=" + ownerClassName + "1");
            ObjectName ownerName2 = new ObjectName("library:name=" + ownerClassName + "2");
            ObjectName bookName1 = new ObjectName("library:name=" + bookClassName + "1");
            ObjectName bookName2 = new ObjectName("library:name=" + bookClassName + "2");
            ObjectName bookName3 = new ObjectName("library:name=" + bookClassName + "3");
            ObjectName bookName4 = new ObjectName("library:name=" + bookClassName + "4");
            ObjectName bookName5 = new ObjectName("library:name=" + bookClassName + "5");
            // 创建Mbean
            this.m_server.createMBean(bookClassName, bookName1, new Object[]{"Lord of the rings"}, new String[]{"java.lang.String"});
            this.m_server.createMBean(bookClassName, bookName2, new Object[]{"The Hobbit"}, new String[]{"java.lang.String"});
            this.m_server.createMBean(bookClassName, bookName3, new Object[]{"Harry Potter"}, new String[]{"java.lang.String"});
            this.m_server.createMBean(bookClassName, bookName4, new Object[]{"UML Distilled"}, new String[]{"java.lang.String"});
            this.m_server.createMBean(bookClassName, bookName5, new Object[]{"Applying UML"}, new String[]{"java.lang.String"});
            this.m_server.createMBean(ownerClassName, ownerName1, new Object[]{"Fred"}, new String[]{"java.lang.String"});
            this.m_server.createMBean(ownerClassName, ownerName2, new Object[]{"Humpty Dumpty"}, new String[]{"java.lang.String"});
            System.out.println("----------------------- done ----------------------------");
            System.out.println("Build the roles");
            ArrayList ownerList = new ArrayList();
            ownerList.add(ownerName1);
            Role ownerRole = new Role("owner", ownerList);
            System.out.println("created owner Role");
            ArrayList bookList = new ArrayList();
            bookList.add(bookName1);
            bookList.add(bookName2);
            bookList.add(bookName3);
            Role bookRole = new Role("books", bookList);
            System.out.println("Created book role");
            System.out.println("----------------------- done ----------------------------");
            System.out.println("Creating the relation");
            RoleList libraryList = new RoleList();
            libraryList.add(ownerRole);
            libraryList.add(bookRole);
            this.createLibraryRelation(personalLibraryId, libraryTypeName, libraryList);
            System.out.println("Getting all the related info");
            this.printAllRelationInfo();
            System.out.println("----------------------- done ----------------------------");
            System.out.println("borrow a book we have 3 one more does not invalidate our relation");
            this.borrowBooks(personalLibraryId, "books", bookName4);
            ArrayList newBookList4 = this.getRoleValue(personalLibraryId, "books");
            System.out.println("we now have 4 books: " + newBookList4.toString());
            System.out.println("----------------------- done ----------------------------");
            System.out.println("2 MBeans removed from the MBeanServer - no problem we still have a valid relation.");
            this.m_server.unregisterMBean(bookName1);
            this.m_server.unregisterMBean(bookName2);
            ArrayList newBookList = this.getRoleValue(personalLibraryId, "books");
            System.out.println("After removing the 2 MBeans we have only 2 Book MBeans left " + newBookList.toString());
            System.out.println("----------------------- done ----------------------------");
            System.out.println("Deregistering the last of our books from the MBeanServer");
            this.m_server.unregisterMBean(bookName3);
            this.m_server.unregisterMBean(bookName4);
            System.out.println("----------------------- done ----------------------------");
            System.out.println("Testing access by running queries: ");
            System.out.println("The relation should have been removed and an exception of RelationNotFoundException returned");
            this.testAllAccessQueries(personalLibraryId);
            System.out.println("----------------------- done ----------------------------");
        } catch (Exception var21) {
            System.out.println("Could Not create the RelationService: " + var21);
            var21.printStackTrace();
        }

    }

    public void borrowBooks(String relationId, String roleName, ObjectName bookToAdd) {
        Logger logger = this.getLogger();

        try {
            ArrayList oldRoleValue = this.getRoleValue(relationId, roleName);
            ArrayList newRoleValue = (ArrayList)oldRoleValue.clone();
            newRoleValue.add(bookToAdd);
            Role role = new Role(roleName, newRoleValue);
            Object[] params1 = new Object[]{relationId, role};
            String[] signature1 = new String[]{"java.lang.String", "javax.management.relation.Role"};
            this.m_server.invoke(this.m_relationObjectName, "setRole", params1, signature1);
        } catch (Exception var10) {
            logger.error("Unable to add a book");
            var10.printStackTrace();
        }

    }

    private void printList(List list) {
        Iterator i = list.iterator();

        while(i.hasNext()) {
            System.out.println(">>>> Names representing roles: " + i.next());
        }

    }

    private ArrayList getRoleValue(String relationId, String roleName) {
        Logger logger = this.getLogger();

        try {
            Object[] params = new Object[]{relationId, roleName};
            String[] signature = new String[]{"java.lang.String", "java.lang.String"};
            return (ArrayList)this.m_server.invoke(this.m_relationObjectName, "getRole", params, signature);
        } catch (Exception var6) {
            logger.error("Unable to get the list of roles for ID: " + relationId);
            return null;
        }
    }

    public void endExample() {
        try {
            System.out.println("Cleaning up......");
            Set mbeanSet = this.m_server.queryMBeans((ObjectName)null, Query.initialSubString(Query.classattr(), Query.value("management*")));
            Iterator i = mbeanSet.iterator();

            while(i.hasNext()) {
                this.m_server.unregisterMBean(((ObjectInstance)i.next()).getObjectName());
            }

            this.m_server.unregisterMBean(this.m_relationObjectName);
            MBeanServerFactory.releaseMBeanServer(this.m_server);
            System.exit(0);
        } catch (Exception var3) {
            var3.printStackTrace();
            System.exit(1);
        }

    }

    private void addRelationType() {
        try {
            Object[] params = new Object[]{this.m_library};
            String[] signature = new String[]{"javax.management.relation.RelationType"};
            this.m_server.invoke(this.m_relationObjectName, "addRelationType", params, signature);
        } catch (Exception var3) {
            var3.printStackTrace();
        }

    }

    private void printRelationTypeInfo() {
        try {
            ArrayList relTypeNameList = (ArrayList)this.m_server.getAttribute(this.m_relationObjectName, "AllRelationTypeNames");
            System.out.println("The RelationType Names found in the RelationService: " + relTypeNameList.toString());
        } catch (Exception var2) {
            var2.printStackTrace();
        }

    }

    private void createLibraryRelation(String personalLibraryId, String libraryTypeName, RoleList libraryList) {
        Logger logger = this.getLogger();

        try {
            Object[] params = new Object[]{personalLibraryId, libraryTypeName, libraryList};
            String[] signature = new String[]{"java.lang.String", "java.lang.String", "javax.management.relation.RoleList"};
            this.m_server.invoke(this.m_relationObjectName, "createRelation", params, signature);
        } catch (Exception var7) {
            logger.error("Exception creating Library Relation: " + var7.getMessage());
            var7.printStackTrace();
        }

    }

    private void printAllRelationInfo() {
        Logger logger = this.getLogger();

        try {
            ArrayList allRelationIds = (ArrayList)this.m_server.getAttribute(this.m_relationObjectName, "AllRelationIds");
            Iterator i = allRelationIds.iterator();

            while(i.hasNext()) {
                String currentRelationId = (String)i.next();
                System.out.println("All RelationIds: " + currentRelationId);
                this.testAllAccessQueries(currentRelationId);
            }
        } catch (Exception var5) {
            logger.error("Unable to print the relations");
            var5.printStackTrace();
        }

    }

    private void testAllAccessQueries(String relationId) {
        Logger logger = this.getLogger();

        try {
            Object[] params = new Object[]{relationId};
            String[] signature = new String[]{"java.lang.String"};
            RoleResult roleResult = (RoleResult)this.m_server.invoke(this.m_relationObjectName, "getAllRoles", params, signature);
            RoleList roleList = roleResult.getRoles();
            Iterator i = roleList.iterator();

            while(i.hasNext()) {
                Role currentRole = (Role)i.next();
                System.out.println(">>>> role name: " + currentRole.getRoleName());
                System.out.println(">>>> role values: " + currentRole.getRoleValue().toString());
            }

            System.out.println("No unresolved Roles roleUnresolved size: " + roleResult.getRolesUnresolved().size());
        } catch (Exception var9) {
            logger.error("Exception printing the results from relationId: " + relationId);
            System.out.println("Printing the Exception message to validate exception: " + var9.getMessage());
        }

    }

    private Logger getLogger() {
        return Log.getLogger(this.getClass().getName());
    }

    @Test
    public void main(){
        RelationServiceExample example = new RelationServiceExample();
        example.setUpRelations();
        example.endExample();
    }
}
