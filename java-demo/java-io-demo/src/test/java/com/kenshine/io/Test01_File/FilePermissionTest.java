package com.kenshine.io.Test01_File;

import org.junit.Test;

import java.io.FilePermission;
import java.security.PermissionCollection;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/5 22:06
 * @description： FilePermission类
 * @modified By：
 * @version: $
 * FilePermission
 * 此类表示对文件和目录的访问。FilePermission 由路径名和对该路径名有效的操作集合组成
 * read 读权限
 * write 写权限
 * execute 执行权限。允许调用  Runtime.exec。对应于  SecurityManager.checkExec。
 * delete 删除权限。允许调用  File.delete。对应于  SecurityManager.checkDelete
 * READLINK 读取符号链接
 *
 * NIO中的PosixFilePermission类似
 */
public class FilePermissionTest {

    //FilePermission使用示例
    @Test
    public void test01(){
        String srg = "F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\aaa.txt";
        FilePermission file1 = new FilePermission("F:\\IDEAworkespace\\codedemo\\java-demo\\java-io-demo\\src\\main\\resources\\test01\\-", "read");
        //创建新的PermissonCollection 以存储FilePermission对象
        PermissionCollection permission = file1.newPermissionCollection();
        permission.add(file1);
        //添加write权限
        FilePermission file2 = new FilePermission(srg, "write");
        permission.add(file2);
        //检查是否拥有指定权限
        if(permission.implies(new FilePermission(srg, "read,write"))) {
            System.out.println("Read, Write permission is granted for the path "+srg );
        }else {
            System.out.println("No Read, Write permission is granted for the path "+srg);
        }
        //返回动作的规范字符串表示
        System.out.println(file2.getActions());
    }

}
