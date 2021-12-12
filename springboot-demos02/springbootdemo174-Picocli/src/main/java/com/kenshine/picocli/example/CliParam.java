package com.kenshine.picocli.example;

import picocli.CommandLine;

import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 21:10
 * @description：Cli参数
 * @modified By：
 * @version: $
 */
@CommandLine.Command(name = "java -jar cli.jar")
public class CliParam {

    @CommandLine.Option(names = {"-h", "--help"}, usageHelp = true, description = " cmd cli help msg")
    public boolean help = false;

    @CommandLine.Option(names = {"-s", "--server"}, required = true, split = ",", converter = ServerTypeConverter.class,
            description = " servers,split by comma: host1:port1,host2:port2 ")
    public String[] servers;

    @CommandLine.Option(names = {"-u", "--user"}, required = true, description = "login username")
    public String user;

    @CommandLine.Option(names = {"-p", "--password"}, required = true,
            description = "login secret or password")
    public String secret;

    /**
     * 一些额外的参数
     */
    @CommandLine.Option(names = {"-c", "--config"}, description = " -c k1=v1 -c k2=v2")
    public Map<String, String> configs;

    //在解析命令行参数并初始化时进行参数转换
    static class ServerTypeConverter implements CommandLine.ITypeConverter<String> {

        @Override
        public String convert(String s) {
            final String[] hp = s.split(":");
            if (hp.length != 2) {
                throw new CommandLine.TypeConversionException("Invalid servers, must be: host1:port1,host2:port2," +
                        " but was:'" + s + "'");
            }
            String host = hp[0].trim();
            int port = Integer.parseInt(hp[1].trim());
            return host + (port == 80 ? "" : ":" + port);
        }
    }

    // 示例二
    public static void main(String... args) {
        int exitCode = new CommandLine(new CliParam()).execute(args);
        System.exit(exitCode);
    }


}