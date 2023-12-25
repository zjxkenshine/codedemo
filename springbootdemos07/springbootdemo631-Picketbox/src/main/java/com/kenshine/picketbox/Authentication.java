package com.kenshine.picketbox;

import com.kenshine.picketbox.pojo.AuthenticationAnnotatedPOJO;
import org.jboss.security.AuthenticationManager;
import org.jboss.security.SimplePrincipal;
import org.junit.Test;
import org.picketbox.config.PicketBoxConfiguration;
import org.picketbox.exceptions.PicketBoxProcessingException;
import org.picketbox.factories.SecurityFactory;
import org.picketbox.plugins.PicketBoxProcessor;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import java.security.Principal;

import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname Authentication
 * @Description 登录验证
 * @Date 2023-12-25 11:00
 * @modified By：
 * @version: 1.0$
 */
public class Authentication {

    /**
     * 配置文件方式
     */
    @Test
    public void test01(){
        //安全域名
        String securityDomainName = "test";
        SecurityFactory.prepare();
        try {
            String configFile = "config/authentication.conf";
            PicketBoxConfiguration idtrustConfig = new PicketBoxConfiguration();
            idtrustConfig.load(configFile);

            AuthenticationManager am = SecurityFactory.getAuthenticationManager(securityDomainName);
            if(am == null){
                throw new RuntimeException("Authentication Manager is null");
            }

            Subject subject = new Subject();
            // 身份 用户名
            Principal principal = getPrincipal("anil");
            // 证明 密码
            Object credential = "pass";

            boolean result = am.isValid(principal, credential);
            if(!result){
                throw new RuntimeException("Authentication Failed");
            }

            result = am.isValid(principal, credential, subject);
            if(!result){
                throw new RuntimeException("Authentication Failed");
            }

            if(subject.getPrincipals().size() < 1){
                throw new RuntimeException("Subject has zero principals");
            }
            System.out.println("Authentication Successful");
        } finally {
            SecurityFactory.release();
        }
    }

    /**
     * 注解方式验证
     */
    @Test
    public void test02() throws PicketBoxProcessingException, LoginException {
        AuthenticationAnnotatedPOJO pojo = new AuthenticationAnnotatedPOJO();

        PicketBoxProcessor processor = new PicketBoxProcessor();
        processor.setSecurityInfo("anil", "pass");
        processor.process(pojo);


        Principal anil = new SimplePrincipal("anil");
        assertEquals("Principal == anil", anil, processor.getCallerPrincipal());
        Subject callerSubject = processor.getCallerSubject();
        assertNotNull("Subject is not null", callerSubject);
        assertTrue("Subject contains principal anil", callerSubject.getPrincipals().contains(anil));
    }


    /**
     * 获取
     */
    private Principal getPrincipal(final String name) {
        return new Principal() {
            @Override
            public String getName() {
                return name;
            }
        };
    }
}
