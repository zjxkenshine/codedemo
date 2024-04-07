package com.kenshine.proxool.listener;

import com.kenshine.proxool.util.Util;
import org.apache.commons.io.IOUtils;
import org.logicalcobwebs.proxool.ProxoolException;
import org.logicalcobwebs.proxool.ProxoolFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.InputStream;

/**
 * Proxool加载监听
 * @author kenshine
 */
@WebListener
public class ProxoolLoaderListener implements ServletContextListener {
    public static final String PROXOOL_CONFIG_LOCATION = "proxoolConfigLocation";
 
    private static Logger log = LoggerFactory.getLogger(ProxoolLoaderListener.class);
 
    @Override
    public void contextDestroyed(ServletContextEvent event){
        // do nothing
    }
 
    @Override
    public void contextInitialized(ServletContextEvent event){
        proxoolLoaderInit(event.getServletContext());
    }
 
    private void proxoolLoaderInit(ServletContext sc){
        String xmlpath = sc.getInitParameter(PROXOOL_CONFIG_LOCATION);
        log.info("proxoolLoaderInit, the initParam config path: {}", xmlpath);
        if(xmlpath == null){
            xmlpath = "classpath:proxool.xml";
        }
 
        xmlpath = xmlpath.trim().toLowerCase();
        InputStream is = null;
        try{
            if(xmlpath.startsWith("classpath:")){
                is = this.getClass().getClassLoader().getResourceAsStream(xmlpath.split(":")[1]); 
                org.logicalcobwebs.proxool.configuration.JAXPConfigurator.configure(new InputSource(is), false);
            }else{
                String appDir = sc.getRealPath("/");
                try{
                    org.logicalcobwebs.proxool.configuration.JAXPConfigurator.configure(appDir + "/" + xmlpath, false);
                }catch(ProxoolException e){
                    log.error("loadding proxool config error: {}/{}", appDir, xmlpath, e);
                    is = this.getClass().getClassLoader().getResourceAsStream(xmlpath.split(":")[1]);
                    org.logicalcobwebs.proxool.configuration.JAXPConfigurator.configure(new InputSource(is), false);
                }
            }
            
            //对连接池增加监控：监控连接的创建与释放、sql的执行时长等
            //ProxoolSqlListener类为自定义的继承自org.logicalcobwebs.proxool.ConnectionListenerIF的普通类
            String[] aliasArr = ProxoolFacade.getAliases();
            ProxoolSqlListener sqlListener = new ProxoolSqlListener();
            if (Util.isNotEmpty(aliasArr)){
                for (String alias: aliasArr){
                   if (alias.startsWith("proxool.")){
                        alias = alias.substring(alias.indexOf('.') + 1);
                   }
                 
                   ProxoolFacade.addConnectionListener(alias, sqlListener);
                }
            }
        }catch(ProxoolException e){
            log.error("loadding proxool config error form classpath: {}", xmlpath, e);
        }finally{
        	   IOUtils.closeQuietly(is);
        }
    }
}