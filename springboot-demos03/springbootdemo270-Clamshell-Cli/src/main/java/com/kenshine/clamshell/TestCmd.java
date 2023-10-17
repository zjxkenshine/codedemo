package com.kenshine.clamshell;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;

import java.util.Collections;
import java.util.Map;

public class TestCmd implements Command {
    private static final String NAMESPACE = "syscmd";
    private static final String ACTION_NAME = "ktest";

    @Override
    public Object execute(Context ctx) {
        IOConsole console = ctx.getIoConsole();
        console.writeOutput("这是测试命令！");
        return null;
    }

    @Override
    public void plug(Context plug) {
        // no load-time setup needed
    }
    
    @Override
    public Command.Descriptor getDescriptor(){
        return new Command.Descriptor() {
            @Override public String getNamespace() {return NAMESPACE;}
            
            @Override
            public String getName() {
                return ACTION_NAME;
            }

            @Override
            public String getDescription() {
               return "ktest cmd";
            }

            @Override
            public String getUsage() {
                return "Type 'ktest'";
            }

            @Override
            public Map<String, String> getArguments() {
                return Collections.emptyMap();
            }
        };
    }
    
}