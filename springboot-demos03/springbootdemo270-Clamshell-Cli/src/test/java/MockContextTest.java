import com.kenshine.clamshell.MockContext;
import org.clamshellcli.api.Command;
import org.clamshellcli.api.Context;
import org.clamshellcli.api.IOConsole;
import org.clamshellcli.api.Plugin;
import org.clamshellcli.api.Shell;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class MockContextTest {
    MockContext ctx;
    public MockContextTest() {
        ctx = MockContext.createInstance();
    }
    
    @Test
    public void testCreateInstance(){
        assert ctx != null;
    }
    
    @Test
    public void testValuesMap() {
        ctx.putValue("Key", "Hello");
        assert ctx.getValue("Key").equals("Hello");
        
        Map<String,String> values = new HashMap<String,String>();
        values.put("Key2", "World");
        ctx.putValues(values);
        assert ctx.getValue("Key2").equals("World");
    }
    
    @Test
    public void testPluginsList() {
        List<Plugin> plugins = new ArrayList<Plugin>();
        plugins.add(new TestShell());
        plugins.add(new TestIoConsole());
        plugins.add(new TestCommand());
        plugins.add(new TestCommand());
        
        ctx.setPlugins(plugins);
        
        assert ctx.getPlugins().size() >= 4;
        assert ctx.getIoConsole() != null;
        List<Command> cmds = ctx.getCommands();
        assert cmds.size() == 2;
    }
   
    static class TestShell  implements Shell {

        public void exec(Context ctx) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void plug(Context plug) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    
    static class TestIoConsole implements IOConsole {

        public InputStream getInputStream() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public OutputStream getOutputStream() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public String readInput(String prompt) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void writeOutput(String value) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void plug(Context plug) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
    
    static class TestCommand implements Command {

        public Descriptor getDescriptor() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public Object execute(Context ctx) {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        public void plug(Context plug) {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        
    }
}
