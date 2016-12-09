package javaeebeauty.demoapp;

import javaeebeauty.core.ApplicationConfiguration;
import javaeebeauty.web.session.WebSessionConfig;
import javax.enterprise.context.*;

@ApplicationConfiguration
@Dependent
public class DemoAppConfig implements WebSessionConfig {
    public Integer getSessionTimeout() {
        return 30;
    }
}
