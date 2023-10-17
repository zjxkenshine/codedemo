package com.kenshine.clamshell;

import org.clamshellcli.api.Configurator;
import java.util.HashMap;
import java.util.Map;

/**
 * 配置
 */
public class MockConfigurator implements Configurator{
    private Map<String, Map<String, ? extends Object>> configMap;
    
    public MockConfigurator() {
        configMap = new HashMap<String,Map<String, ? extends Object>>();
    }

    @Override
    public Map<String, Map<String, ? extends Object>> getConfigMap() {
        return configMap;
    }
    public void setConfigMap(Map<String,Map<String,? extends Object>> map){
        configMap = map;
    }
    public void addConfigMap(String cfgName, Map<String, ? extends Object> val){
        configMap.put(cfgName, val);
    }
    @Override
    public Map<String, String> getPropertiesMap() {
        return (Map<String, String>) configMap.get(Configurator.KEY_CONFIG_PROPS);
    }    
    public void setPropertiesMap(Map<String,String> map){
        configMap.put(Configurator.KEY_CONFIG_PROPS, map);
    }
    
    public void addProperty(String name, String val){
        if(getPropertiesMap() != null)
            getPropertiesMap().put(name, val);
        else{
            this.setPropertiesMap(new HashMap<String,String>());
            getPropertiesMap().put(name, val);
        }
            
    }
    @Override
    public Map<String, Map<String, ? extends Object>> getControllersMap() {
        return (Map<String, Map<String, ? extends Object>>) configMap.get(Configurator.KEY_CONFIG_CTRLS);
    }
    
    public void setControllersMap(Map<String, Map<String, ? extends Object>> map){
        configMap.put(Configurator.KEY_CONFIG_CTRLS, map);
    }
    
    public void addControllerMap(String name, Map<String,? extends Object> attribs){
        if(getControllersMap() != null){
            getControllersMap().put(name, attribs);
        }else{
            this.setControllersMap(new HashMap<String, Map<String, ? extends Object>>());
            this.getControllersMap().put(name, attribs);
        }
    }
}
