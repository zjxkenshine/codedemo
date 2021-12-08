package com.kenshine.jline.completer;

import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/8 22:52
 * @description： 文件变量补全
 * @modified By：
 * @version: $
 */
public class FileVarsCompleter implements Completer {

    Completer completer;

    public FileVarsCompleter() {
        this.completer = new StringsCompleter();
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        completer.complete(reader, line, candidates);
    }

    public void setFileVars(List<String> fileVars) {
        this.completer = new StringsCompleter(fileVars);
    }

}
