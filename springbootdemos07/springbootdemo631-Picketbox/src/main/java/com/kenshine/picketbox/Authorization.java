package com.kenshine.picketbox;

import com.kenshine.picketbox.pojo.AuthAuthorizationAnnotatedPOJO;
import org.jboss.security.AuthenticationManager;
import org.jboss.security.AuthorizationManager;
import org.jboss.security.SimplePrincipal;
import org.jboss.security.authorization.AuthorizationContext;
import org.jboss.security.authorization.AuthorizationException;
import org.jboss.security.authorization.Resource;
import org.jboss.security.authorization.ResourceType;
import org.jboss.security.identity.RoleGroup;
import org.junit.Test;
import org.picketbox.config.PicketBoxConfiguration;
import org.picketbox.exceptions.PicketBoxProcessingException;
import org.picketbox.factories.SecurityFactory;
import org.picketbox.plugins.PicketBoxProcessor;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author by kenshine
 * @Classname Authorization
 * @Description 鉴权验证
 * @Date 2023-12-25 11:30
 * @modified By：
 * @version: 1.0$
 */
public class Authorization {
    private final String securityDomainName = "test";
    private final String configFile = "config/authorization.conf";

    /**
     * 配置文件方式 authorization.conf"
     */
    @Test
    public void test01(){
        SecurityFactory.prepare();
        try {
            PicketBoxConfiguration idtrustConfig = new PicketBoxConfiguration();
            idtrustConfig.load(configFile);

            AuthenticationManager am = SecurityFactory.getAuthenticationManager(securityDomainName);
            assertNotNull(am);

            Subject subject = new Subject();
            Principal principal = getPrincipal("anil");
            Object credential = "pass";

            boolean result = am.isValid(principal, credential, subject);
            assertTrue("Valid Auth", result);
            assertTrue("Subject has principals", subject.getPrincipals().size() > 0);

            AuthorizationManager authzM = SecurityFactory.getAuthorizationManager(securityDomainName);
            assertNotNull(authzM);
            Resource resource = getResource();
            int decision = authzM.authorize(resource, subject);
            assertEquals(decision, AuthorizationContext.PERMIT);
        } catch (AuthorizationException e) {
            e.printStackTrace();
        } finally{
            SecurityFactory.release();
        }
    }

    /**
     * 注解方式鉴权
     */
    @Test
    public void test02() throws LoginException, PicketBoxProcessingException {
        AuthAuthorizationAnnotatedPOJO pojo = new AuthAuthorizationAnnotatedPOJO();

        PicketBoxProcessor processor = new PicketBoxProcessor();
        processor.setSecurityInfo("anil", "pass");
        processor.process(pojo);

        Principal anil = new SimplePrincipal("anil");
        assertEquals("Principal == anil", anil, processor.getCallerPrincipal());
        Subject callerSubject = processor.getCallerSubject();
        assertNotNull("Subject is not null", callerSubject);
        assertTrue("Subject contains principal anil", callerSubject.getPrincipals().contains(anil));
        RoleGroup callerRoles = processor.getCallerRoles();
    }

    private Principal getPrincipal(final String name) {
        return new Principal() {
            @Override
            public String getName()
            {
                return name;
            }
        };
    }

    private Resource getResource() {
        return new Resource() {
            @Override
            public ResourceType getLayer() {
                return ResourceType.WEB;
            }

            @Override
            public Map<String, Object> getMap() {
                return new HashMap<>();
            }

            @Override
            public void add(String s, Object o) {

            }
        };
    }
}
