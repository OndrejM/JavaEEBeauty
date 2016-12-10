package javaeebeauty.demoapp;

import static javaeebeauty.demoapp.Constants.SESSION_TIMEOUT_IN_MINUTES;
import javaeebeauty.demoapp.testsupport.TestPackager;
import javax.enterprise.context.ApplicationScoped;
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
    private HttpSession session;
    
    @Deployment
    public static WebArchive createDeployment() {
        return TestPackager.createDeploymentWithDependencies()
                .addClass(DemoAppConfig.class);
    }

    @Test
    public void session_timeout_should_be_configured_in_the_container() {
        assertNotNull("session instance", session);
        assertEquals("session-timeout on instance", SESSION_TIMEOUT_IN_MINUTES * 60, session.getMaxInactiveInterval());
    }

}
