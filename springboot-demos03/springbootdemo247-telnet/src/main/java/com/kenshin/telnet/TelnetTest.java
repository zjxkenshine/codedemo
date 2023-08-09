package com.kenshin.telnet;

import java.io.UnsupportedEncodingException;

/**
 * @author by kenshine
 * @Classname TelnetTest
 * @Description 测试
 * @Date 2023-08-05 18:03
 * @modified By：
 * @version: 1.0$
 * https://blog.csdn.net/qq969422014/article/details/50859291
 */
public class TelnetTest {
    static  Integer xh= 34;
    static String mac = "E0D5-5EEC-287F";


    public static void main(String[] args) throws UnsupportedEncodingException {
        String gw = "rule "+xh+" deny source-mac "+mac+"  FFFF-FFFF-FFFF\n";
        String kw = "undo rule "+xh+" deny source-mac "+mac+"  FFFF-FFFF-FFFF\n";

        StringBuilder sb = new StringBuilder();
        sb.append("undo ");
        sb.append(xh);
        sb.append(" deny source-mac ");
        sb.append(mac);
        sb.append(" FFFF-FFFF-FFFF\n");
        System.out.println(sb.toString());

        TelnetUtil.connection("192.168.2.1", 23);//登录本机,23端口
        if(TelnetUtil.findStr("in:"))//如果远程计算机返回login字符
            TelnetUtil.sendTelnetMsg("admin\n");//传输用户名,改写你的用户名,该用户名属于TelnetClients组
        if(TelnetUtil.findStr("rd:"))//如果远程计算机返回password
            TelnetUtil.sendTelnetMsg("aaaa\n");//传输用户密码,改写你的密码
        if(TelnetUtil.findStr("C>"))//如果远程计算机返回<H3C>字符
            TelnetUtil.sendTelnetMsg("system-view\n");//进入SYS
        if(TelnetUtil.findStr("C]"))//如果远程计算机返回[H3C]字符
            TelnetUtil.sendTelnetMsg("acl mac 4998\n");
        if(TelnetUtil.findStr("8"))
            TelnetUtil.sendTelnetMsg(gw.trim()+"\n");
        TelnetUtil.sendTelnetMsg("dis this\n");
        TelnetUtil.sendTelnetMsg("rule 200 permit\n");
        TelnetUtil.sendTelnetMsg("quit\n");
        if(TelnetUtil.findStr("C]"))
            TelnetUtil.sendTelnetMsg("quit\n");
        if(TelnetUtil.findStr("C>"))
            TelnetUtil.sendTelnetMsg("save\n");
        if(TelnetUtil.findStr("N]"))
            TelnetUtil.sendTelnetMsg("y\n");
        if(TelnetUtil.findStr("y):"))
            TelnetUtil.sendTelnetMsg("\n");
        if(TelnetUtil.findStr("N]"))
            TelnetUtil.sendTelnetMsg("y\n");
        if(TelnetUtil.findStr("successfully"))
            System.out.println("操作成功");
    }

}
