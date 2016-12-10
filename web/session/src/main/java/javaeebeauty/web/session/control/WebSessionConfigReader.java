package javaeebeauty.web.session.control;

import javaeebeauty.core.boundary.Constants;
import javaeebeauty.web.session.*;
import javax.servlet.SessionTrackingMode;

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
            for (SessionTrackingMode mode : annotation.trackingModes()) {
                configSnapshot.addSessionTrackingMode(mode);
            }
            if (annotation.cookieConfig().length > 0) {
                final ConfigureSessionCookie cookieConfig = annotation.cookieConfig()[0];
                final SessionCookieConfigSnapshot cookieConfigSnapshot = configSnapshot.getSessionCookieConfig();
                if (!cookieConfig.comment().isEmpty()) {
                    cookieConfigSnapshot.setComment(cookieConfig.comment());
                }
                if (!cookieConfig.domain().isEmpty()) {
                    cookieConfigSnapshot.setDomain(cookieConfig.domain());
                }
                if (!cookieConfig.name().isEmpty()) {
                    cookieConfigSnapshot.setName(cookieConfig.name());
                }
                if (!cookieConfig.path().isEmpty()) {
                    cookieConfigSnapshot.setPath(cookieConfig.path());
                }
                if (cookieConfig.httpOnly()) {
                    cookieConfigSnapshot.setHttpOnly(true);
                }
                if (cookieConfig.secure()) {
                    cookieConfigSnapshot.setSecure(true);
                }
                if (cookieConfig.maxAge() != Constants.INT_NOT_SET) {
                    cookieConfigSnapshot.setMaxAge(cookieConfig.maxAge());
                }

            }
        }
    }
}
