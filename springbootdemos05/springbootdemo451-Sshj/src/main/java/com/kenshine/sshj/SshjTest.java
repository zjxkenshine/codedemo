package com.kenshine.sshj;

import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.connection.channel.direct.Session;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import net.schmizz.sshj.userauth.password.ConsolePasswordFinder;
import net.schmizz.sshj.userauth.password.PasswordFinder;
import net.schmizz.sshj.xfer.FileSystemFile;
import net.schmizz.sshj.xfer.scp.SCPFileTransfer;
import org.junit.Test;
import sun.misc.IOUtils;

import java.io.IOException;

/**
 * @author by kenshine
 * @Classname SshjTest
 * @Description 测试
 * @Date 2023-11-02 17:05
 * @modified By：
 * @version: 1.0$
 */
public class SshjTest {

    /**
     * 连接SSH服务器
     */
    @Test
    public void test01() throws IOException {
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new PromiscuousVerifier());
        ssh.connect("localhost");
    }

    /**
     * 密码认证
     */
    @Test
    public void test02() throws IOException {
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new PromiscuousVerifier());
        ssh.connect("localhost",22);
        ssh.authPassword("Administrator", "9988");
    }


    /**
     * 公钥认证
     */
    @Test
    public void test03() throws IOException {
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new PromiscuousVerifier());
        ssh.connect("localhost");
        String privateKeyPath="C:\\Users\\Administrator\\.ssh\\id_rsa";
        String publicKeyPath="C:\\Users\\Administrator\\.ssh\\id_rsa.pub";
        // 明文密码
        PasswordFinder passphrase=new ConsolePasswordFinder();
        ssh.authPublickey("Administrator",ssh.loadKeys(privateKeyPath, publicKeyPath, passphrase));
    }

    /**
     * 远程执行命令
     */
    @Test
    public void test04() throws IOException {
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new PromiscuousVerifier());
        ssh.connect("localhost");
        Session session = ssh.startSession();
        Session.Command cmd = session.exec("echo 'Hello World!'");
        IOUtils.readFully(cmd.getInputStream(),100,true);
        cmd.join();
    }

    /**
     * SCP 文件上传下载
     */
    @Test
    public void test05() throws IOException {
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new PromiscuousVerifier());
        ssh.connect("localhost");
        String sourceFile = "C:\\imsdk_report";
        String targetDir = "D:\\imsdk_report";
        String sourceFilePath = "C:\\imsdk_report";
        // 上传文件
        SCPFileTransfer scp = ssh.newSCPFileTransfer();
        scp.upload(new FileSystemFile(sourceFile), targetDir);
        // 下载
        SCPFileTransfer scp1 = ssh.newSCPFileTransfer();
        scp1.download(sourceFilePath, new FileSystemFile(targetDir));
    }

    /**
     * SFTP 文件上传下载
     */
    @Test
    public void test06() throws IOException {
        SSHClient ssh = new SSHClient();
        ssh.addHostKeyVerifier(new PromiscuousVerifier());
        ssh.connect("localhost");
        String sourceFile = "C:\\imsdk_report";
        String targetDir = "D:\\imsdk_report";
        String sourceFilePath = "C:\\imsdk_report";
        // 上传
        SFTPClient sftp = ssh.newSFTPClient();
        sftp.put(new FileSystemFile(sourceFile), targetDir);
        // 下载
        SFTPClient sftp1 = ssh.newSFTPClient();
        sftp1.get(sourceFilePath, new FileSystemFile(targetDir));
    }



}
