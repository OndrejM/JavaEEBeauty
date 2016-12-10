package javaeebeauty.web.session.control;

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
        //configSnapshot.setSessionTimeout(readSessionTimeout());
        readFromProvidedConfig(configSnapshot);
        return configSnapshot;
    }

    private void readFromProvidedConfig(WebSessionConfigSnapshot configSnapshot) {
        if (providedConfig != null) {
            providedConfig.configureWebSession(configSnapshot);
        }
    }
}
