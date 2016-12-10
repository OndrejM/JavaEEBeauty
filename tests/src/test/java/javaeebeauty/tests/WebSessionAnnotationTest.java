package javaeebeauty.tests;

import static javaeebeauty.tests.testsupport.Constants.SESSION_TIMEOUT_IN_MINUTES;
import javaeebeauty.tests.testsupport.TestPackager;
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
public class WebSessionAnnotationTest {

    @Inject
    private HttpSession session;
    
    @Deployment
    public static WebArchive createDeployment() {
        return TestPackager.createDeploymentWithDependencies()
                .addClass(WebSessionAppConfigAnnotation.class);
    }

    @Test
    public void session_timeout_should_be_configured_in_the_container() {
        assertNotNull("session instance", session);
        assertEquals("session-timeout on instance", SESSION_TIMEOUT_IN_MINUTES * 60, session.getMaxInactiveInterval());
    }

    @Test
    public void cookie_config_should_be_configured_in_the_container() {
        assertNotNull("session instance", session);
        assertNotNull("session context", session.getServletContext());
        assertNotNull("session cookie config", session.getServletContext().getSessionCookieConfig());
        assertEquals("session cookie name", "MY_SESSION_COOKIE", session.getServletContext().getSessionCookieConfig().getName());
    }

    @Test
    public void tracking_mode_should_be_configured_in_the_container() {
        assertNotNull("session instance", session);
        assertNotNull("session context", session.getServletContext());
        assertEquals("Number of session tracking modes", 2, session.getServletContext().getEffectiveSessionTrackingModes().size());
    }

}
