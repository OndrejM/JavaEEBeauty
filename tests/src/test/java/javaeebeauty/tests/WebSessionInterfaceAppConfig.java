package javaeebeauty.tests;

import static javaeebeauty.tests.testsupport.Constants.SESSION_TIMEOUT_IN_MINUTES;
import javaeebeauty.web.session.*;
import javax.enterprise.context.*;
import static javax.servlet.SessionTrackingMode.*;
import javaeebeauty.core.ApplicationConfiguration;

@ApplicationConfiguration
@Dependent
public class WebSessionInterfaceAppConfig implements ConfiguringWebSession {
    @Override
    public void configureWebSession(WebSessionConfig config) {
        config.setSessionTimeout(SESSION_TIMEOUT_IN_MINUTES);
        config.getSessionCookieConfig().setName("MY_SESSION_COOKIE");
        config.addSessionTrackingMode(COOKIE, URL);
    }
}
