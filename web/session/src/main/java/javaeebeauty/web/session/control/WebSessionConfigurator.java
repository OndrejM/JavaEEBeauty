package javaeebeauty.web.session.control;

import javaeebeauty.core.control.UndefinedConfigurationValueException;
import javaeebeauty.web.session.WebSessionConfig;

public class WebSessionConfigurator {

    private final Object providedConfigObject;
    private final WebSessionConfig providedConfig;

    public WebSessionConfigurator(Object providedConfig) {
        this.providedConfigObject = providedConfig;
        if (providedConfigObject instanceof WebSessionConfig) {
            this.providedConfig = (WebSessionConfig) providedConfigObject;
        } else {
            this.providedConfig = null;
        }
    }

    public WebSessionConfigSnapshot readConfig() {
        WebSessionConfigSnapshot configSnapshot = new WebSessionConfigSnapshot();
        configSnapshot.setSessionTimeout(readSessionTimeout());
        return configSnapshot;
    }

    private Integer readSessionTimeout() {
        if (providedConfig != null) {
            try {
                return providedConfig.getSessionTimeout();
            } catch (UndefinedConfigurationValueException e) {
            }
        }
        return null;
    }
}
