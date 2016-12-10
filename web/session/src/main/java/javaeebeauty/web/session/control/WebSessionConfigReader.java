package javaeebeauty.web.session.control;

import javaeebeauty.core.boundary.Constants;
import javaeebeauty.web.session.*;

public class WebSessionConfigReader {

    private final Object providedConfigObject;
    private final ConfiguringWebSession providedConfig;

    public WebSessionConfigReader(Object providedConfig) {
        this.providedConfigObject = providedConfig;
        if (providedConfigObject instanceof ConfiguringWebSession) {
            this.providedConfig = (ConfiguringWebSession) providedConfigObject;
        } else {
            this.providedConfig = null;
        }
    }

    public WebSessionConfigSnapshot readConfig() {
        WebSessionConfigSnapshot configSnapshot = new WebSessionConfigSnapshot();
        readFromAnnotation(configSnapshot);
        readFromProvidedConfig(configSnapshot);
        return configSnapshot;
    }

    private void readFromProvidedConfig(WebSessionConfigSnapshot configSnapshot) {
        if (providedConfig != null) {
            providedConfig.configureWebSession(configSnapshot);
        }
    }

    private void readFromAnnotation(WebSessionConfigSnapshot configSnapshot) {
        final ConfigureWebSession annotation = providedConfigObject.getClass().getAnnotation(ConfigureWebSession.class);
        if (annotation != null) {
            if (annotation.sessionTimeout() != Constants.INT_NOT_SET) {
                configSnapshot.setSessionTimeout(annotation.sessionTimeout());
            }
        }
    }
}
