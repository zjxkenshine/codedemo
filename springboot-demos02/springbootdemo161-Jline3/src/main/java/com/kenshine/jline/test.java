package com.kenshine.jline;

import com.kenshine.jline.completer.FileVarsCompleter;
import com.kenshine.jline.history.FogHistory;
import org.jline.builtins.Completers;
import org.jline.reader.*;
import org.jline.reader.impl.completer.AggregateCompleter;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 22:40
 * @description：
 * @modified By：
 * @version: $
 */
public class test {
    private static List<String> fileVars = new ArrayList<>();
    private static FileVarsCompleter fileVarsCompleter = new FileVarsCompleter();


    public static void main(String[] args) throws IOException {
        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        //简单命令补全
        //Completer commandCompleter = new StringsCompleter("CREATE", "OPEN", "WRITE", "CLOSE");

        /**
         * 组合命令补全
         */
//        Completer createCompleter = new ArgumentCompleter(
//                new StringsCompleter("CREATE"),
//                new Completers.FileNameCompleter(),
//                //第三个单词开始不补全
//                NullCompleter.INSTANCE
//        );

        /**
         * Create命令补全
         */
        Completer createCompleter = new ArgumentCompleter(
                new StringsCompleter("CREATE"),
                new Completers.FileNameCompleter(),
                NullCompleter.INSTANCE
        );
        /**
         *  Open命令补全
         */
        Completer openCompleter = new ArgumentCompleter(
                new StringsCompleter("OPEN"),
                new Completers.FileNameCompleter(),
                new StringsCompleter("AS"),
                NullCompleter.INSTANCE
        );
        /**
         * Write命令补全
         */
        Completer writeCompleter = new ArgumentCompleter(
                new StringsCompleter("WRITE"),
                new StringsCompleter("TIME", "DATE", "LOCATION"),
                new StringsCompleter("TO"),
                fileVarsCompleter,
                NullCompleter.INSTANCE
        );

        /**
         * 多个命令组合
         */
        Completer fogCompleter = new AggregateCompleter(
                createCompleter,
                openCompleter,
                writeCompleter
        );

        LineReader lineReader = LineReaderBuilder.builder()
                .terminal(terminal)
                //命令补全
                .completer(fogCompleter)
                //历史记录
                .history(new FogHistory())
                .build();

        String prompt = "fog> ";
        while (true) {
            String line;
            try {
                line = lineReader.readLine(prompt);
                //输出读取到的字符
                System.out.println(line);
            } catch (UserInterruptException e) {
                // Do nothing
            } catch (EndOfFileException e) {
                System.out.println("\nBye.");
                return;
            }
        }
    }
}
