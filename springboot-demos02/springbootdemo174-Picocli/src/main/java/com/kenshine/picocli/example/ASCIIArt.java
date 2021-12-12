package com.kenshine.picocli.example;

import picocli.CommandLine;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/12 21:42
 * @description：代码示例3
 * @modified By：
 * @version: $
 *
 * https://picocli.info/quick-guide.html
 *
 *  java -cp "myapp.jar;picocli-4.6.2.jar" ASCIIArt --font-size=9 hello picocli
 *
 *  mixinStandardHelpOptions：
 *  将标准-h和--help usageHelp选项以及-V和--version versionHelp选项添加到此命令的选项中
 */
@CommandLine.Command(name = "ASCIIArt", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true)
public class ASCIIArt implements Runnable {

    @CommandLine.Option(names = { "-s", "--font-size" }, description = "Font size")
    int fontSize = 19;

    @CommandLine.Parameters(paramLabel = "<word>", defaultValue = "Hello, picocli",
            description = "Words to be translated into ASCII art.")
    private String[] words = { "Hello,", "picocli" };

    @Override
    public void run() {
        // 你的业务逻辑
    }

    //示例三
    public static void main(String[] args) {
        int exitCode = new CommandLine(new ASCIIArt()).execute(args);
        System.exit(exitCode);
    }

}
