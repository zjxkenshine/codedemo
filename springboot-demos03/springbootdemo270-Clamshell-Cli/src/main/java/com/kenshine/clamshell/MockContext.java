package com.kenshine.clamshell;

import org.clamshellcli.api.Command;
import org.clamshellcli.api.Configurator;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;
import org.clamshellcli.api.Plugin;
import org.clamshellcli.api.Prompt;
import org.clamshellcli.api.Shell;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 上下文
 * 
 */
public final class MockContext implements Context {
    private Map<String, Object> values;
    private static MockContext context;
    private Configurator config;
    private List<Plugin> plugins;

    public static MockContext createInstance(){
        return (context != null) ? context : (context = new MockContext());
    }

    private MockContext(){
        values = new HashMap<String,Object>();
        config = new MockConfigurator();
        plugins = new ArrayList<Plugin>();
        plugins.add(new MockShell());
        plugins.add(new MockConsole());

        values.put(KEY_INPUT_STREAM, System.in);
        values.put(KEY_OUTPUT_STREAM, System.out);
    }

    @Override
    public Map<String, ? extends Object> getValues() {
        return values;
    }
    @Override
    public void putValues(Map<String, ? extends Object> values) {
        this.values.putAll(values);
    }
    @Override
    public void putValue(String key, Object val) {
        values.put(key,val);
    }
    @Override
    public Object getValue(String key) {
        return values.get(key);
    }
    @Override
    public void removeValue(String key) {
        values.remove(key);
    }
    @Override
    public Configurator getConfigurator() {
        return config;
    }

    public void setConfigurator(Configurator conf){
        config = conf;
    }
    @Override
    public Shell getShell() {
        List<Shell> shells = this.getPluginsByType(Shell.class);
        return (shells != null && shells.size() > 0)  ? shells.get(0) : null;
    }
    @Override
    public IOConsole getIoConsole() {
        List<IOConsole> consoles = this.getPluginsByType(IOConsole.class);
        return (consoles != null && consoles.size() > 0)  ? consoles.get(0) : null;
    }

    @Override
    public Prompt getPrompt() {
        List<Prompt> prompts = this.getPluginsByType(Prompt.class);
        return (prompts != null && prompts.size() > 0)  ? prompts.get(0) : null;
    }
    @Override
    public List<Plugin> getPlugins() {
        return plugins;
    }

    public void setPlugins(List<Plugin> p){
        plugins.addAll(p);
    }

    @Override
    public <T> List<T> getPluginsByType(Class<T> type) {
        List<T> result = new ArrayList<T>();
        for (Plugin p : getPlugins()) {
            if (type.isAssignableFrom(p.getClass())) {
                result.add((T) p);
            }
        }
        return result;
    }
    @Override
    public List<Command> getCommands() {
        return this.getPluginsByType(Command.class);
    }
    @Override
    public List<Command> getCommandsByNamespace(String namespace) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    @Override
    public Map<String, Command> mapCommands(List<Command> commands) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
