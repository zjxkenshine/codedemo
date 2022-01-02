package com.kenshine.springshell.avaliability;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/2 20:08
 * @description： 动态命令可用性 两种方式
 * @modified By：
 * @version: $
 */
@ShellComponent
public class DownLoader {
    private boolean connected = false;

    @ShellMethod("Connect server")
    public void connect() {
        connected = true;
    }

    @ShellMethod("Download file")
    public void download1() {
        System.out.println("Downloaded.");
    }

    // 为命令download提供可用行支持
    public Availability downloadAvailability() {
        //连接后可用，否则报错
        return connected ? Availability.available():Availability.unavailable("you are not connected");
    }

    /**
     * ShellMethodAvailability 添加动态命令可用性
     * 使用方式一
     */
    @ShellMethod("Download")
    @ShellMethodAvailability({"connectCheck"})
    public void download() {
        System.out.println("Downloaded.");
    }

    @ShellMethod("Upload")
    @ShellMethodAvailability({"connectCheck"})
    public void upload() {
        System.out.println("Uploaded.");
    }


    // 另一种使用方式 直接在提供命令动态可用性的方法上通过注解`@ShellMethodAvailability`指定命令方法名
    //@ShellMethodAvailability({"download", "upload"})
    public Availability connectCheck() {
        return connected ? Availability.available():Availability.unavailable("you are not connected");
    }

}
