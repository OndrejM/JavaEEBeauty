package javaeebeauty.demoapp;

import javaeebeauty.core.ApplicationConfiguration;
import static javaeebeauty.demoapp.Constants.SESSION_TIMEOUT_IN_MINUTES;
import javaeebeauty.web.session.WebSessionConfig;
import javax.enterprise.context.*;

@ApplicationConfiguration
@Dependent
public class DemoAppConfig implements WebSessionConfig {
    public Integer getSessionTimeout() {
        return SESSION_TIMEOUT_IN_MINUTES;
    }
}
