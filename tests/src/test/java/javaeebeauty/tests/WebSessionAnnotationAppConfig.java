package javaeebeauty.tests;

import static javaeebeauty.tests.testsupport.Constants.SESSION_TIMEOUT_IN_MINUTES;
import javaeebeauty.web.session.ConfigureWebSession;
import javax.enterprise.context.*;
import javax.servlet.SessionTrackingMode;
import javaeebeauty.core.ApplicationConfiguration;
import javaeebeauty.web.session.*;

@ApplicationConfiguration
@ConfigureWebSession(sessionTimeout = SESSION_TIMEOUT_IN_MINUTES,
        trackingModes = {SessionTrackingMode.COOKIE, SessionTrackingMode.URL},
        cookieConfig = @ConfigureSessionCookie(
                name = "MY_SESSION_COOKIE"
        ))
@Dependent
public class WebSessionAnnotationAppConfig {
}
