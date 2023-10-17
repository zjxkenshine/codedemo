package com.kenshine.clamshell;

import org.clamshellcli.api.Context;
import org.clamshellcli.api.Shell;

/**
 * 测试Shell
 */
public class MockShell implements Shell{

    @Override
    public void exec(Context ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void plug(Context plug) {
    }
    
}
