package com.kenshine.jopt.main;

import joptsimple.OptionParser;
import joptsimple.OptionSet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/7 22:31
 * @description：
 * @modified By：
 * @version: $
 * https://www.136.la/code/show-188419.html
 */
public class Demo01 {
    public static boolean useJline = true;
    public static boolean useConsole = true;

    public static void main(String[] args) {
        //模拟输入-help参数
        args=new String[]{"-help"};

        // 命令行解析器，支持长选项和段选项
        OptionParser parser = new OptionParser() {
            {
                //添加参数及描述
                acceptsAll(asList("?", "help"), "Show the help");
                acceptsAll(asList("c", "config"), "Properties file to use")
                        //需要参数
                        .withRequiredArg()
                        //参数要转换为的类型
                        .ofType(File.class)
                        //默认参数
                        .defaultsTo(new File("server.properties"))
                        //选项的参数的描述
                        .describedAs("Properties file");
                acceptsAll(asList("P", "plugins"), "Plugin directory to use")
                        .withRequiredArg()
                        .ofType(File.class)
                        .defaultsTo(new File("plugins"))
                        .describedAs("Plugin directory");
                acceptsAll(asList("h", "host", "server-ip"), "Host to listen on")
                        .withRequiredArg()
                        .ofType(String.class)
                        .describedAs("Hostname or IP");
                acceptsAll(asList("W", "world-dir", "universe", "world-container"), "World container")
                        .withRequiredArg()
                        .ofType(File.class)
                        .describedAs("Directory containing worlds");
                acceptsAll(asList("w", "world", "level-name"), "World name")
                        .withRequiredArg()
                        .ofType(String.class)
                        .describedAs("World name");
                acceptsAll(asList("p", "port", "server-port"), "Port to listen on")
                        .withRequiredArg()
                        .ofType(Integer.class)
                        .describedAs("Port");
                acceptsAll(asList("o", "online-mode"), "Whether to use online authentication")
                        .withRequiredArg()
                        .ofType(Boolean.class)
                        .describedAs("Authentication");
                acceptsAll(asList("s", "size", "max-players"), "Maximum amount of players")
                        .withRequiredArg()
                        .ofType(Integer.class)
                        .describedAs("Server size");
                acceptsAll(asList("d", "date-format"), "Format of the date to display in the console (for log entries)")
                        .withRequiredArg()
                        .ofType(SimpleDateFormat.class)
                        .describedAs("Log date format");
                acceptsAll(asList("log-pattern"), "Specfies the log filename pattern")
                        .withRequiredArg()
                        .ofType(String.class)
                        .defaultsTo("server.log")
                        .describedAs("Log filename");
                acceptsAll(asList("log-limit"), "Limits the maximum size of the log file (0 = unlimited)")
                        .withRequiredArg()
                        .ofType(Integer.class)
                        .defaultsTo(0)
                        .describedAs("Max log size");
                acceptsAll(asList("log-count"), "Specified how many log files to cycle through")
                        .withRequiredArg()
                        .ofType(Integer.class)
                        .defaultsTo(1)
                        .describedAs("Log count");
                acceptsAll(asList("log-append"), "Whether to append to the log file")
                        .withRequiredArg()
                        .ofType(Boolean.class)
                        .defaultsTo(true)
                        .describedAs("Log append");
                acceptsAll(asList("log-strip-color"), "Strips color codes from log file");
                acceptsAll(asList("b", "bukkit-settings"), "File for bukkit settings")
                        .withRequiredArg()
                        .ofType(File.class)
                        .defaultsTo(new File("bukkit.yml"))
                        .describedAs("Yml file");
                acceptsAll(asList("nojline"), "Disables jline and emulates the vanilla console");
                acceptsAll(asList("noconsole"), "Disables the console");
                acceptsAll(asList("v", "version"), "Show the CraftBukkit Version");
                acceptsAll(asList("demo"), "Demo mode");
            }
        };

        //OptionSet 检测到的命令行选项
        OptionSet options = null;
        try {
            //解析args为OptionSet，类似commons-cli的解析
            //配置了默认值的也会被解析
            options = parser.parse(args);
        } catch (joptsimple.OptionException ex) {
            Logger.getLogger(Demo01.class.getName()).log(Level.SEVERE, ex.getLocalizedMessage());
        }

        System.out.println(options.asMap());
        if ((options == null) || (options.has("?"))) {
            try {
                //打印帮助文档
                parser.printHelpOn(System.out);
            } catch (IOException ex) {
                Logger.getLogger(Demo01.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (options.has("v")) {
            System.out.println(Demo01.class.getPackage().getImplementationVersion());
        } else {
            try {
                // This trick bypasses Maven Shade's clever rewriting of our getProperty call when using String literals
                //这个技巧在使用字符串文字时绕过了 Maven Shade 对我们的 getProperty 调用的巧妙重写
                String jline_UnsupportedTerminal = new String(new char[] {'j','l','i','n','e','.','U','n','s','u','p','p','o','r','t','e','d','T','e','r','m','i','n','a','l'});
                String jline_terminal = new String(new char[] {'j','l','i','n','e','.','t','e','r','m','i','n','a','l'});
                useJline = !(jline_UnsupportedTerminal).equals(System.getProperty(jline_terminal));
                if (options.has("nojline")) {
                    System.setProperty("user.language", "en");
                    useJline = false;
                }

                if (!useJline) {
                    // This ensures the terminal literal will always match the jline implementation
                    //System.setProperty(jline.TerminalFactory.JLINE_TERMINAL, jline.UnsupportedTerminal.class.getName());
                }

                if (options.has("noconsole")) {
                    useConsole = false;
                }
                //MinecraftServer.main(options);
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    private static List<String> asList(String... params) {
        return Arrays.asList(params);
    }
}
