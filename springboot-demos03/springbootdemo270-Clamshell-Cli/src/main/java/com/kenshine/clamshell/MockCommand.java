package com.kenshine.clamshell;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;

/**
 * 自定义命令
 */
public class MockCommand implements Command{
    @Override
    public Descriptor getDescriptor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Object execute(Context ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public void plug(Context plug) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
