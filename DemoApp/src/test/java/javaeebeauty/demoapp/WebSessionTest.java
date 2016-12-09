package javaeebeauty.demoapp;

import static javaeebeauty.demoapp.Constants.SESSION_TIMEOUT_IN_MINUTES;
import javaeebeauty.demoapp.testsupport.TestPackager;
import javaeebeauty.web.session.control.WebSessionConfigSnapshot;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@ApplicationScoped
public class WebSessionTest {

    @Inject
    private TestContext context;
    
    @Inject
    private HttpSession session;
    
    @Deployment
    public static WebArchive createDeployment() {
        return TestPackager.createDeploymentWithDependencies()
                .addClass(DemoAppConfig.class);
    }

    public void setConfig(@Observes WebSessionConfigSnapshot config) {
        context.config = config;
    }

    @Test
    public void session_timeout_should_be_found_in_the_app_config() {
        final WebSessionConfigSnapshot config = context.config;
        assertNotNull("session config", config);
        assertNotNull("session-timeout", config.getSessionTimeout());
        assertEquals("session-timeout", SESSION_TIMEOUT_IN_MINUTES, config.getSessionTimeout().intValue());
    }

    @Test
    public void session_timeout_should_configured_in_the_servlet_context() {
        assertNotNull("session instance", session);
        assertEquals("session-timeout on instance", SESSION_TIMEOUT_IN_MINUTES * 60, session.getMaxInactiveInterval());
    }

    @ApplicationScoped
    public static class TestContext {

        private WebSessionConfigSnapshot config;

    }

}
