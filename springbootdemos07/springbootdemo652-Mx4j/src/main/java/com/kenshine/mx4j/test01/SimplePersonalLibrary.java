package com.kenshine.mx4j.test01;

import javax.management.relation.RelationTypeSupport;
import javax.management.relation.RoleInfo;

public class SimplePersonalLibrary extends RelationTypeSupport {
    public SimplePersonalLibrary(String relationTypeName) {
        super(relationTypeName);

        try {
            RoleInfo ownerRoleInfo = new RoleInfo("owner", "com.kenshine.mx4j.test01.SimpleOwner", true, true, 1, 1, "Owner");
            this.addRoleInfo(ownerRoleInfo);
            RoleInfo booksRoleInfo = new RoleInfo("books", "com.kenshine.mx4j.test01.SimpleBooks", true, true, 1, 4, "Books");
            this.addRoleInfo(booksRoleInfo);
        } catch (Exception var4) {
            throw new RuntimeException(var4.getMessage());
        }
    }
}