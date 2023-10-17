package com.kenshine.clamshell;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ：kenshine
 * @date ：Created in 2023/10/18 0:35
 * @description： 自定义命令
 * @modified By：
 * @version: $
 */
public class MockCommand1 implements Command {
    @Override
    public Descriptor getDescriptor() {
        return new Command.Descriptor() {

            @Override
            public String getNamespace() {
                return "TEST_COMMAND";
            }

            @Override
            public String getName() {
                return "mock";
            }

            @Override
            public String getDescription() {
                return "A mock command object";
            }

            @Override
            public String getUsage() {
                return "Do not use. Not usable.";
            }

            @Override
            public Map<String, String> getArguments() {
                Map<String,String> args = new HashMap<String,String>();
                args.put("arg0", "Argument 0.");
                args.put("arg1", "Argument 1.");
                args.put("arg2", "Argument 2.");
                args.put("arg3", "Argument 3.");
                args.put("arg4", "Argument 4.");
                args.put("arg5", "Argument 5.");
                args.put("arg6", "Argument 6.");
                return args;
            }
        };
    }

    @Override
    public Object execute(Context ctx) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void plug(Context plug) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void unplug(Context plug) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
