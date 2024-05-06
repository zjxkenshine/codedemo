package com.kenshine.cmdlineparser;

import idea.verlif.parser.cmdline.ArgParser;
import idea.verlif.parser.cmdline.ArgValues;
import idea.verlif.parser.cmdline.CmdHandler;

/**
 * @author kenshine
 * 自定义参数解析器
 */
public class HtmlUrlArgParser implements ArgParser {

    @Override
    public ArgValues parseLine(String line) {
        String[] ss = line.split("\\?", 2);
        if (ss.length == 1) {
            return new ArgValues();
        }
        return toArgValues(ss[1]);
    }

    private ArgValues toArgValues(String paramStr) {
        ArgValues argValues = new ArgValues();
        String[] params = paramStr.split("&");
        for (String param : params) {
            int i = param.indexOf('=');
            if (i == -1) {
                argValues.add(param, null);
            } else {
                argValues.add(param.substring(0, i), param.substring(i + 1));
            }
        }
        return argValues;
    }
}