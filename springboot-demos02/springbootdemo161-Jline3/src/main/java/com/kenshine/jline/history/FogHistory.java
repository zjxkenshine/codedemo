package com.kenshine.jline.history;

import org.jline.reader.impl.history.DefaultHistory;

import java.time.Instant;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 23:02
 * @description：重写历史命令
 * @modified By：
 * @version: $
 *
 * 打包后在CMD窗口 java -jar执行可以看到效果
 */
public class FogHistory extends DefaultHistory {
    /**
     * # 开头的是注释命令，不记录历史命令
     * @param line
     * @return
     */
    private static boolean isComment(String line) {
        return line.startsWith("#");
    }

    @Override
    public void add(Instant time, String line) {
        if (isComment(line)) {
            return;
        }
        super.add(time, line);
    }

}
