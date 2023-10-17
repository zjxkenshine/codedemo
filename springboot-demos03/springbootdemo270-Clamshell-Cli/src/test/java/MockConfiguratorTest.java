import com.kenshine.clamshell.MockConfigurator;
import org.clamshellcli.api.Configurator;
import java.util.HashMap;
import java.util.Map;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MockConfiguratorTest {
    private MockConfigurator mock;

    public MockConfiguratorTest() {
        mock = new MockConfigurator();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testConstructor(){
        Configurator cfg = new MockConfigurator();
        assert cfg != null;
        assert cfg.getConfigMap() != null;
        assert cfg.getControllersMap() == null;
        assert cfg.getPropertiesMap() == null;
    }
    
    @Test
    public void testSetConfigMap() {
        Map<String, Map<String, ?>> config = new HashMap<String,Map<String,?>>();
        Map<String, String> props = new HashMap<String,String>();
        props.put("key", "Hello");
        config.put("props", props);
        mock.setConfigMap(config);
        assert mock.getConfigMap() != null;
        assert mock.getConfigMap().get("props") != null;
        assert mock.getConfigMap().get("props").get("key") != null;
        assert mock.getConfigMap().get("props").get("key").equals("Hello");
    }
    
    @Test
    public void testAddConfigMap(){
        Map<String, String> props = new HashMap<String,String>();
        props.put("key1", "Hello");
        props.put("key2", "World");
        
        mock.addConfigMap("config", props);
        assert mock.getConfigMap().get("config") != null;
        assert mock.getConfigMap().get("config").get("key1").equals("Hello");
        assert mock.getConfigMap().get("config").get("key2").equals("World");
    }
    
    @Test
    public void testPropertiesMap(){
        Map<String, String> props = new HashMap<String,String>();
        props.put("key1", "Hello");
        props.put("key2", "World");
        
        mock.setPropertiesMap(props);
        
        assert mock.getPropertiesMap() != null;
        assert mock.getPropertiesMap().get("key1").equals("Hello");
        assert mock.getPropertiesMap().get("key2").equals("World");
        
        mock.addProperty("key3", "Foo");
        assert mock.getPropertiesMap().get("key3").equals("Foo");
    }
    
}
