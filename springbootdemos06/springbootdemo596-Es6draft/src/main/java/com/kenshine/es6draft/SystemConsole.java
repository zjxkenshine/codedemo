package com.kenshine.es6draft;

import com.github.anba.es6draft.runtime.internal.Console;

import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;

public final class SystemConsole implements Console {
    private final StringReader reader = new StringReader("");
    private final PrintWriter writer = new PrintWriter(System.out, true);
    private final PrintWriter errorWriter = new PrintWriter(System.err, true);

    @Override
    public void printf(String format, Object... args) {
        writer.printf(format, args);
    }

    @Override
    public void flush() {
        writer.flush();
        errorWriter.flush();
    }

    @Override
    public String readLine() {
        return "";
    }

    @Override
    public String readLine(String prompt) {
        return "";
    }

    @Override
    public Reader reader() {
        return reader;
    }

    @Override
    public PrintWriter writer() {
        return writer;
    }

    @Override
    public PrintWriter errorWriter() {
        return errorWriter;
    }
}