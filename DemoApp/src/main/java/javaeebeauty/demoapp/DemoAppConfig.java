package javaeebeauty.demoapp;

import javaeebeauty.core.ApplicationConfiguration;
import static javaeebeauty.demoapp.Constants.SESSION_TIMEOUT_IN_MINUTES;
import javaeebeauty.web.session.*;
import javax.enterprise.context.*;

@ApplicationConfiguration
@Dependent
public class DemoAppConfig implements ConfiguringWebSession {
    public void configureWebSession(WebSessionConfig config) {
        config.setSessionTimeout(SESSION_TIMEOUT_IN_MINUTES);
    }
}
