package javaeebeauty.demoapp;

import javaeebeauty.core.ApplicationConfiguration;
import javaeebeauty.web.session.*;
import javax.enterprise.context.*;

@ApplicationConfiguration
@ConfigureWebSession(sessionTimeout = 30)
@Dependent
public class DemoAppConfig implements ConfiguringWebSession {
    @Override
    public void configureWebSession(WebSessionConfig config) {
        config.setSessionTimeout(20);
    }
}
