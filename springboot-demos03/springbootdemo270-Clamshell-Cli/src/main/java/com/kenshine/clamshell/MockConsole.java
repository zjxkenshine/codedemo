package com.kenshine.clamshell;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * IO console实现类
 */
public class MockConsole implements IOConsole{
    private InputStream in;
    private PrintStream out;
    
    public MockConsole(){
        in = System.in;
        out = System.out;
    }

    @Override
    public InputStream getInputStream() {
        return in;
    }
    @Override
    public OutputStream getOutputStream() {
        return out;
    }
    @Override
    public String readInput(String prompt) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void writeOutput(String value) {
        out.print(value);
    }
    @Override
    public void plug(Context plug) {
        
    }
    
}
