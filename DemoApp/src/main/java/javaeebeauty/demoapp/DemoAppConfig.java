package javaeebeauty.demoapp;

import javaeebeauty.web.session.*;
import javax.enterprise.context.*;
import javaeebeauty.core.ApplicationConfiguration;

@ApplicationConfiguration
@ConfigureWebSession(sessionTimeout = 30)
@Dependent
public class DemoAppConfig implements ConfiguringWebSession {
    @Override
    public void configureWebSession(WebSessionConfig config) {
        config.setSessionTimeout(20);
    }
}
